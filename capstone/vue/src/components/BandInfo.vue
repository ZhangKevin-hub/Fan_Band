<template>
  <div>
      <h1>{{ band.bandName }}</h1>
      <button v-on:click="followBand()" v-if="followingBand">Follow Band</button>
      <button v-on:click="unfollowBand()" v-else>Unfollow Band</button>
      <p>{{ band.description }}</p>
      <img src="" alt="cover image">
      <h5>List of genres</h5>
      <img src="" alt="photo gallergy">
      

  </div>
</template>

<script>
import AuthService from '../services/AuthService'

export default {
    name: 'bandInfo',
    data(){
      return {
        band: {},
        userId: -1,
        bandId: -1
      }
    },
    computed: {
      followingBand() {
        if (this.$store.state.bandsFollowing.includes(this.bandId)){
          return true;
        }else {
          return false;
        }
      }
    },
    methods: {
      followBand(){
        this.$store.state.bandsFollowing.push(this.bandId);
        const follower = {
          userId: this.userId,
          bandId: this.bandId,
        }
        AuthService.followBand(follower).then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
        })
      },
      unfollowBand(){
        //remove from store list
        this.$store.commit('REMOVE_BAND_FOLLOWING', this.bandId)
        const follower= {
          userId: this.userId,
          bandId: this.bandId
        }
        AuthService.unfollowBand(follower).then(response => {
          console.log(response)
        }
        )
        .catch(error => {
          console.log(error)
        })
      }
    },
    created(){
      this.band = this.$store.state.band;
      this.bandId = this.$store.state.band.id;
      this.userId = this.$store.state.user.id;
    }
}
</script>

<style>

</style>