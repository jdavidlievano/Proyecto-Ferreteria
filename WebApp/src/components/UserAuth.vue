<template>
    <div id="AuthUser" class="auth_user">
        
        <div class="container_auth_user">
            <h2>Iniciar Sesión</h2>
            <div>
                <form v-on:submit.prevent="processAuthUser" >
                    <label for="">Usuario:</label>
                    <input class="form-control" type="text" v-model="user_in.username" placeholder="Username">
                    <br>
                    <label for="">Password:</label>
                    <input class="form-control" type="password" v-model="user_in.password" placeholder="Password">
                    <br>
                    <div class="divButton">
                        <button class="btn btn-primary" type="submit">Iniciar Sesion</button>
                    </div>
                </form>
            </div>
        </div>

    </div>
</template>

<script>
import gql from 'graphql-tag'
import jwt_decode from "jwt-decode"

export default {
    name: "UserAuth",

    data: function(){
        return {
            user_in: {
                username:"",
                password:""
            }
        }
    },

    methods: {
        processAuthUser: async function(){
            await this.$apollo.mutate({
                mutation: gql`
                    mutation ($authenticateCredentials: CredentialsInput!) {
                        authenticate(credentials: $authenticateCredentials) {
                            refresh
                            access
                        }
                    }`, 
                variables: {
                    authenticateCredentials: this.user_in
                }

            }).then((result) => {

                let data = result.data.authenticate
                data.user_id = jwt_decode(data.access).user_id.toString().padStart(3, "0")

                this.$emit('log-in', data, this.user_in.username)

            }).catch((error) => {
                alert("El usuario y/o contraseña son incorrectos")
            });
        }
    }
}
</script>

<style>
    .auth_user{
        padding-top: 80px;
        height: 100%;
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;

    }
    .container_auth_user{
        width: 25%;
        height: 100%;
        border: 3px solid  #283747;
        border-radius: 10px;
        padding: 20px;
    }
    .auth_user h2{
        color: #283747;
        text-align: center;
    }
    .divButton{
        text-align: center;
    }
    .auth_user form{
        width: 100%;
    }
    .auth_user button{
        width: 100%;
        height: 100%;
        color: #E5E7E9;
        background: rgb(187, 84, 187);
        border: 1px solid #E5E7E9;
        border-radius: 5px;
        padding: 10px 25px;
        margin: 5px 0;
    }
    /*

    

    .auth_user form{
        width: 50%;
        
    }

    .auth_user input{
        height: 40px;
        width: 100%;

        box-sizing: border-box;
        padding: 10px 20px;
        margin: 5px 0;

        border: 1px solid #283747;
        
    }

    

    .auth_user button:hover{
        color: #E5E7E9;
        background: crimson;
        border: 1px solid #283747;
    }*/
</style>