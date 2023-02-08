<template>
  <div id="band">
      <h1>{{ band.bandName }}</h1>
      <button id ="followButton" v-on:click="followBand()" v-if="followingBand">Follow Band</button>
      <button id ="unfollowButton" v-on:click="unfollowBand()" v-if="!followingBand">Unfollow Band</button>
      <button id ="editButton" v-on:click="editBand()" v-if="this.$store.state.user.id === this.$store.state.band.userId">Edit Band</button>
      <button id="messageButton" v-on:click="messageFollowers = true" v-if="this.$store.state.user.id === this.$store.state.band.userId"><span>Message Followers</span></button>
      <div v-if="messageFollowers">
        <notification-form @add-message="swapMessage"></notification-form>
      </div>
      <div id="bandInfo1" v-if="!edit" >
        <p>{{ band.description }}</p>
      <img :src="band.image" alt="cover image">
      <h5>List of genres</h5>
      <ul id="genres">
        <li v-for="genre in genres" v-bind:key="genre.id">{{ genre.name }}</li>
      </ul>
      <img :src="photo.imgUrl" alt="photo gallergy image" v-for="photo in photoGallery" v-bind:key="photo.id">
      </div>
      <div v-else> 
        <new-band-form v-bind:editing="true" v-bind:bandId="this.bandId"></new-band-form>
      </div>
  </div>
</template>

<script>
import AuthService from '../services/AuthService'
import NewBandForm from './NewBandForm.vue';
import NotificationForm from './NotificationForm.vue';

export default {
  components: { NewBandForm, NotificationForm },
    name: 'bandInfo',
    data(){
      return {
        band: {},
        userId: -1,
        bandId: -1,
        edit: false,
        photoGallery: [],
        genres: [],
        messageFollowers: false
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
      swapMessage(msg){
        this.messageFollowers = msg;
        console.log("it worked");
      },
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
      AuthService.getPhotos(this.bandId).then(response => {
        this.photoGallery = response.data;
      })
      .catch(error => {
        console.log(error);
      });
      AuthService.getGenresByBandId(this.bandId).then(response => {
        this.genres = response.data
      })
      .catch(error => {
        console.log(error);
      });
      console.log(this.$store.state.user);
    }
}
</script>

<style scoped>
#followButton{
  --color: hsl(204, 55%, 51%);
  --hover: hsl(204, 55%, 51%);
  color: var(--color);
  transition: 0.25s;
  border: 2px solid var(--color);
}
#followButton:hover,
#followButton:focus {
  box-shadow: inset 6.5em 0 0 0 var(--hover);
}
#unfollowButton{
  --color: hsl(19, 88%, 62%);
  --hover: hsl(19, 88%, 62%);
  color: var(--color);
  transition: 0.25s;
  border: 2px solid var(--color);
}
#unfollowButton:hover,
#unfollowButton:focus {
  box-shadow: inset -6.5em 0 0 0 var(--hover);
}
#editButton{
  --color: hsl(135, 58%, 57%);
  --hover: hsl(135, 58%, 57%);
  color: var(--color);
  transition: 0.25s;
  border: 2px solid var(--color);
}
#editButton:hover,
#editButton:focus {
  box-shadow: inset 0 0 0 2em var(--hover);
}
#messageButton{
  color:white;
  background-color: hsl(183, 58%, 66%);
}
#messageButton span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

#messageButton span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

#messageButton:hover span {
  padding-right: 25px;
}
#messageButton span:after {
  opacity: 1;
  right: 0;
}
#bandInfo1 {
  margin-left: 33%;
}
img {
  height: 150px;
}

#genres {
  justify-content: left;
}

</style>