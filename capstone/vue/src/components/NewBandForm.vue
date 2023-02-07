<template>
  <div>
    <form id="newBandForm">
      <div class="form-element">
        <label for="bandName">Band Name: </label>
        <input type="text" id="bandName" v-model="band.bandName" />
      </div>
      <div class="form-element">
        <label for="description">Description: </label>
        <input type="text" id="description"  v-model="band.description"/>
      </div>
      <div class="form-element">
        <label for="coverImage">Cover Image Link: </label>
        <input type="text" id="coverImage" v-model="band.image" />
      </div>
      <div class="form-element">
        <label for="genres">Genres: </label>
        <p v-for="(genre, index) in genres" v-bind:key="index"> {{ index }}: {{ genre.name }}
        </p>
        <ul>
            <li v-for="(genre, index) in possibleGenres" v-bind:key="index">
                <input type="checkbox" :id="index" :value="genre" v-on:change="editSelectedGenres(genre)" v-bind:checked="boxChecked(genre)">
                <label :for="index">{{ genre.name }}</label>
            </li>
        </ul>
      </div>
      <div v-if="editing">
        <label for="galleryImageLink">Photo Gallery: </label>
        <div v-for="(photo, index) in photoGallery" v-bind:key="index">
          <span>{{ index+1}}: {{ photo.imgUrl }}</span>
          <input type="checkbox" v-bind:checked="true" v-on:change="editSelectedPhotos(photo)"> <!--call method with index as param, add/remove to new list of links? -->
        </div>
        <input id="galleryImageLink" type="text" v-model="photoLink">
        <button v-on:click.prevent="addLinkToGallery()">Add Image to Gallery</button>
      </div>
      <button class="MakeBand" type="submit" v-on:click.prevent="submitForm()">Create Band</button>
    </form>
  </div>
</template>

<script>
import AuthService from '../services/AuthService';
export default {
  data() {
    return {
      possibleGenres: this.$store.state.genreOptions,
      band: {},
      genres: [],
      photoGallery: [],
      photoLink: ""
    };
  },
  props: {
    editing: Boolean,
    bandId: Number //may be null, unsure if matters
  },
  methods: {
    boxChecked(genre){
      const filtered = this.genres.filter(eachGenre => {
        return eachGenre.id === genre.id
      })
      return filtered.length === 1;
    },
    editSelectedPhotos(photo){
      const filteredPhotos = this.photoGallery.filter( (eachPhoto) => {
        return eachPhoto.imgUrl === photo.imgUrl;
      } )
      if (filteredPhotos.length === 0){
        this.photoGallery.push(photo);
      } else {
        this.photoGallery = this.photoGallery.filter( (eachPhoto) => {
          return eachPhoto.imgUrl !== photo.imgUrl;
        })

      }
    },
      editSelectedGenres(genre){
          const filteredList = this.genres.filter( (eachGenre)=> {
              return eachGenre.id == genre.id;
          })
          if (filteredList.length === 0){
              this.genres.push(genre);
              this.band.genreIds.push(genre.id);
          } else {
              this.genres = this.genres.filter( (eachGenre) => {
                  return eachGenre.id !== genre.id;
              } );
              this.band.genreIds = this.band.genreIds.filter( (eachId) => {
                return eachId !== genre.id
              })
          }
          console.log(this.genres);
      },
      addLinkToGallery(){
        const photo = {
          imgUrl: this.photoLink,
          bandId: this.$store.state.band.bandId
        }
        this.photoGallery.push(photo);
        this.photoLink = "";
      },
      submitForm(){
          this.band.userId = this.$store.state.user.id;
          if (this.editing){
            AuthService.updateBand(this.bandId, this.band).then( response => {
              console.log(response);
              this.updatePhotoGallery();
            })
            .catch(error => {
              console.log(error);
            })
          }else{
          AuthService.createBand(this.band)
            .then( response => {
                if (response.status == 200){
                    //this.resetForm();
                    
                    //this.assignGenres();
                }
            })
          .catch((error)=> {
              console.log("failed to create band");
              console.log(error);
          });
          //dont call update photos if empty
          }
      },
      resetFrom(){
        this.band = {
          bandName: "", 
          description: "",
          image: "",
          userId: -1
      }
      },
      updatePhotoGallery(){
        let postObject= [];
        if (this.photoGallery.length !==0){
          postObject = {
          photos: this.photoGallery
        };
        } else {
          postObject = {
            photos: []
          }
        }
      AuthService.updatePhotos(postObject).then( response => {
        console.log(response)
      })
      .catch(error => {
        console.log(error)
      });

      },
      setBand(){
        if (this.editing){
      this.band = this.$store.state.band;
      this.band.genreIds =[];
      AuthService.getGenresByBandId(this.bandId).then(response => {
     response.data.forEach(genre => {
       this.genres.push(genre);
       this.band.genreIds.push(genre.id)
     })
    })
    .catch(error => {
      console.log(error)
    } );
    AuthService.getPhotos(this.bandId).then(response => {
      this.photoGallery = response.data;
    })
    .catch(error => {
      console.log(error);
    })
    console.log(this.genres);
    }else{
      this.band = {
          bandName: "", 
          description: "",
          image: "",
          userId: -1,
          genreIds: []
      };
      console.log(this.band);
    }
      }
  },
  created() {
    this.setBand();
    //get photo gallery for band

  }
};
</script>

<style>

#newBandForm {
    text-align: center;
}
ul {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
}

li {
    list-style: none;
}

.MakeBand {
--color: #ffa260;
--hover: hsl(197, 77%, 58%);
color: var(--color);
transition: 0.25s;
border: 2px solid var(--color);
}

.MakeBand:hover,
.MakeBand:focus {
box-shadow: 0 0.5em 0.5em -0.4em var(--hover);
transform: translateY(-0.25em);
border-color: var(--hover);
color: #fff;
}

button {
background: none;
border: 2px solid;
font: inherit;
line-height: 1;
margin: 0.5em;
padding: 1em 2em;
}
</style>
