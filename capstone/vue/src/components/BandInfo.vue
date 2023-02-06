<template>
  <div>
      <h1>{{ band.bandName }}</h1>
      <button v-on:click="followBand()" v-if="followingBand">Follow Band</button>
      <button v-on:click="unfollowBand()" v-if="!followingBand">Unfollow Band</button>
      <button v-on:click="editBand()">Edit Band</button>
      <div v-if="!edit" >
        <p>{{ band.description }}</p>
      <img src="" alt="cover image">
      <h5>List of genres</h5>
      <img src="" alt="photo gallergy">
      </div>
      <div v-else> 
        <new-band-form v-bind:editing="true" v-bind:bandId="this.bandId"></new-band-form>
      </div>
      
      

  </div>
</template>

<script>
import AuthService from '../services/AuthService'
import NewBandForm from './NewBandForm.vue';

export default {
  components: { NewBandForm },
    name: 'bandInfo',
    data(){
      return {
        band: {},
        userId: -1,
        bandId: -1,
        edit: false
      }
    },
    computed: {
      followingBand() {
        if (this.$store.state.bandsFollowing.includes(this.bandId)){
          return false;
        }else {
          return true;
        }
      }
    },
    methods: {
      editBand(){
        this.edit = true;
      },
      followBand(){
        this.$store.state.bandsFollowing.push(this.bandId);
        const follower = {
          userId: this.userId,
          bandId: this.bandId,
        }
        console.log(follower);
        AuthService.followBand(follower).then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
          console.log("didn't follow")
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
          console.log(error.message)
          console.log("didnt unfollow")
        })
      }
    },
    created(){
      this.band = this.$store.state.band;
      this.bandId = this.$store.state.band.bandId;
      this.userId = this.$store.state.user.id;
    }
}
</script>

<style>

</style>