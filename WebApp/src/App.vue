<template>
  <div id="app" class="app">
    <div class="header">
      <h2>Bibbble</h2>

      <nav class="navbar navbar-dark bg-whitesmoke p-0">
        <button class="btn btn-outline-info" v-on:click="init" v-if="is_auth" > Inicio </button>
        <button class="btn btn-outline-info" v-on:click="product" v-if="is_auth" > Productos </button>
        <button class="btn btn-outline-info" v-on:click="movements" v-if="is_auth" > Movimientos </button>
        <button class="btn btn-outline-info" v-on:click="logOut" v-if="is_auth" > Salir </button>
      </nav>

      <a href="#" class="bt-menu" ><i class="icon-menu" ></i></a>

      
      <ul class="navbar-secundary">
        <li><button class="btn btn-outline-info" v-on:click="init" v-if="is_auth" > Inicio </button></li>
        <li><button class="btn btn-outline-info" v-on:click="product" v-if="is_auth" > Productos </button></li>
        <li><button class="btn btn-outline-info" v-on:click="movements" v-if="is_auth" > Movimientos </button></li>
        <li><button class="btn btn-outline-info" v-on:click="logOut" v-if="is_auth" > Salir </button></li>
      </ul>
      
      
      
    </div>
    
    <div class="main-component">
      <router-view  v-on:log-in="logIn"></router-view>
    </div>

    <div class="footer">
      <h2>Misión TIC 2022</h2>
    </div>
  </div>
</template>

<script>


import gql from 'graphql-tag'

export default {
  name: 'App',

  data: function(){
      return{ 
        is_auth: false
      }    
  },

  created: function(){
    this.updateAccessToken();
  },

  methods:{

    updateAccessToken: async function(){
      if(localStorage.getItem('refresh_token')==null){
        this.$router.push({name: "user_auth"})
        this.is_auth = false
        return;
      }

      await this.$apollo.mutate({
        mutation: gql`
          mutation ($refreshTokenRefresh: String!) {
            refreshToken(refresh: $refreshTokenRefresh) {
              access
            }
          }`
        , 
        variables: {
          refreshTokenRefresh: localStorage.getItem('refresh_token')
        }
      }).then((result) => {
        localStorage.setItem('access_token', result.data.refreshToken.access)
        this.is_auth = true
      }).catch((error) => {
        alert("Su sesión expiró, vuelva a iniciar sesión.")
        this.$router.push({name: "user_auth"})
        this.is_auth = false
      });
    },

    logIn: async function(data, username){
      localStorage.setItem('access_token', data.access)
      localStorage.setItem('refresh_token', data.refresh)
      localStorage.setItem('user_id', data.user_id)
      localStorage.setItem('current_username', username)

      await this.updateAccessToken();
      if(this.is_auth) this.init();
    },

    init: function(){
      this.$router.push({name: "user", params:{ username: localStorage.getItem("current_username") }})
    },

    product: function(){
      this.$router.push({
        name: "product", 
        params:{ username: localStorage.getItem("current_username") }})
    },

    movements: function(){
      this.$router.push({
        name: "movements",
      });
    },

    
    logOut: async function(){
      localStorage.removeItem('access_token')
      localStorage.removeItem('refresh_token')
      localStorage.removeItem('user_id')
      localStorage.removeItem('current_username')

      await this.updateAccessToken();
    }   
  }
  
}






</script>

<style>

  *{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }
  

  .header{
    position: fixed;
    left: 0px;
    top: 0px;
    width: 100%;
    margin: 0;
    padding: 0;
    background-color: whitesmoke ;
    color:black  ;
    display: flex;
    justify-content: space-between;
    align-items: center;
    z-index: 100;
    border-bottom: 1px solid gray;
  }

  .header h2{
    width: 20%;
    padding-left: 10px;
  }

  .header .navbar {
    height: 100%;
    display: flex;
    align-items: center;
    font-size: 15px;
  }

  .header .navbar button{
    color: black;
    border: none;
    margin: 0;
  }

  .header .navbar button:hover{
    color: #283747;
    background: #E5E7E9;
    border: 1px solid #E5E7E9;
  }
  .header .bt-menu{
    display: none;
  }
  .navbar-secundary{
    display: none;
  }

  .main-component{
    height: 75vh;
    margin: 0%;
    padding: 0%;

    background: #FDFEFE ;
  }
 
  .footer{
    position: fixed;
    left: 0px;
    bottom: 0px;
    width: 100%;
    height: 75px;

    background-color: #283747;
    color: #E5E7E9;
  }

  .footer h2{
    margin: 0px;
    width: 100%;
    height: 100%;
    
    display: flex;
    justify-content: center;
    align-items: center;
  }

  @media (max-width : 767px){
    .header .navbar{
      display: none;
    }
    .header .bt-menu{
      display: block;
      text-decoration: none;
      color: black;
      font-size: x-large;
    }
    
    .navbar-secundary{
      display: none;
      width: 100%;
      left: 0px;
      top: 48px;
      position: absolute;
      background: rgba(100, 98, 98, 0.8);
      padding: 0;
      border-right: 1px solid black;
    }
    .navbar-secundary.show{
      display: block;
    }
    
    .navbar-secundary li{
      display: block;
      width: 100%;
      height: 100%;
      border-bottom: 1px solid black ;
    }
    .navbar-secundary li button{
      width: 100%;
      color: white;
      border: none;
      text-align: left;
      border-radius: 0;
    }
    .navbar-secundary li button:hover{
      background: rgb(187, 84, 187);
    }
    
  }
</style>
