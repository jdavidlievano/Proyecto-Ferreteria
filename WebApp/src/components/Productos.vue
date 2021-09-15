<template>
    <div id="Products" class="products">
        
        <div class="container_products">
            <div class="imageTools">
                <div class="crearProductos">
                    <h5>Product Manager</h5>
                    <div class="caja-search">
                        <input type="text" id="searchProduct" class="searchProduct" placeholder="Buscar">
                    </div>
                    
                        
                    
                    
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalcrearProducto" id="crearProducto">
                    Crear 
                    </button>
                </div>
            </div>
            
            

            <!-- Button trigger modal -->
            <!--<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalactualizarProducto" id="actualizarProducto">
            Actualizar Producto
            </button>-->

            <!-- Button trigger modal -->
            <!--<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modaleliminarProducto" id="eliminarProducto">
            Eliminar Producto
            </button>-->
            <div id="contenedor">
                <!-- Modal -->
                <div class="modal fade" id="modalcrearProducto" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="staticBackdropLabel">Crear Producto</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form v-on:submit.prevent="createProduct">
                                <label for="">Id:</label>
                                <input class="form-control" type="text" v-model="product_in.id">
                                <label for="">Nombre:</label>
                                <input class="form-control" type="text" v-model="product_in.name">
                                <!--<label for="">Icono:</label>
                                <input class="form-control" type="text">-->
                                <label for="">Cantidad:</label>
                                <input class="form-control" type="number" v-model="product_in.stock">
                                <label for="">Precio:</label>
                                <input class="form-control" type="number" v-model="product_in.price">
                                <label for="">Descripción:</label>
                                <input class="form-control" type="text" v-model="product_in.description">
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Agregar Producto</button>
                                </div>
                                
                            </form>
                        </div>
                        <!--<div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Agregar Producto</button>
                        </div>-->
                        </div>
                    </div>
                </div>

                <!-- Modal -->
                <!--<div class="modal fade" id="modalactualizarProducto" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">Actualizar Producto</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="" method="post">
                            <label for="">Id: </label>
                            <input class="form-control" type="text" disabled=true >
                            <label for="">Nombre:</label>
                            <input class="form-control" type="text">
                            <label for="">Icono:</label>
                            <input class="form-control" type="text">
                            <label for="">Cantidad:</label>
                            <input class="form-control" type="text">
                            <label for="">Precio:</label>
                            <input class="form-control" type="text">
                            <label for="">Descripción:</label>
                            <input class="form-control" type="text">
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Actualizar Producto</button>
                    </div>
                    </div>
                </div>
                </div>-->

                <!-- Modal -->
                <div class="modal fade" id="modaleliminarProducto" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">Eliminar Producto</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="" method="post">
                            <h3>Esta seguro de eliminar el producto?</h3>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Eliminar Producto</button>
                    </div>
                    </div>
                </div>
                </div>

                <div class="row row-cols-3 row-cols-md-5 g-0">
                    <div class="card" v-for="producto in obtainProducts" :key="producto.name">
                        <!-- <img src="..." class="card-img-top" alt="..."> -->
                        <div class="card-body">
                            <h5 class="card-title">{{ producto.name }}</h5>
                            <br>
                            <input type="hidden" name="{{ producto.id }}" id="{{ producto.id }}">
                            <div>Id: {{ producto.id }}</div>
                            <div>Cantidad: {{ producto.stock }}</div>
                            <div>Precio: {{ producto.price }}</div>
                            <br>
                            <div class="buttons">
                                <button class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#modalactualizarProducto"  id="actualizarProducto" v-on:click="mostrarModalActualizar">Actualizar</button>
                                
                                <button class="btn btn-danger" type="button"  data-bs-toggle="modal" data-bs-target="#modaleliminarProducto" id="eliminarProducto" v-on:click="mostrarModalEliminar">Eliminar</button>
                            </div>
                            <h5>{{producto.id}}</h5>

                            <!-- Modal -->
                            <div class="modal fade" id="modalactualizarProducto"  data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="staticBackdropLabel">Actualizar Producto</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <form action="" method="post">
                                                <h5>{{producto.id}}</h5>
                                                <label for="">Id: {{producto.id}}</label>
                                                <input class="form-control" type="text" disabled=true >
                                                <label for="">Nombre:</label>
                                                <input class="form-control" type="text">
                                                <label for="">Icono:</label>
                                                <input class="form-control" type="text">
                                                <label for="">Cantidad:</label>
                                                <input class="form-control" type="text">
                                                <label for="">Precio:</label>
                                                <input class="form-control" type="text">
                                                <label for="">Descripción:</label>
                                                <input class="form-control" type="text">
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                            <button type="submit" class="btn btn-primary">Actualizar Producto</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        
                    </div>
                </div>
            </div>

        </div>

    </div>
</template>

<script>
import gql from 'graphql-tag'
import jwt_decode from "jwt-decode"

export default {
    name: "Productos",

    data: function(){
        return {
                username:"none",
                obtainProducts: [],
                product_in: {
                    id: "",
                    name: "",
                    description: "",
                    stock: null,
                    price: null,
                }
            }
    },

    created: function () {
        this.username = this.$route.params.username;
    },

    apollo: {
        obtainProducts: {
            query: gql`
                query {
                    obtainProducts {
                        id
                        name
                        description
                        stock
                        price
                        createAt
                    }
                }
            `,
            variables() {
                // return {
                //     transacctionByIdUserUserId: localStorage.getItem("user_id"),
                // };
            },
        },
    },

    methods: {

         createProduct: async function(){
             await this.$apollo.mutate({
                 mutation: gql`
                    mutation($createProductProduct: ProductInput!){
                        createProduct(product: $createProductProduct){
                            id
                            name
                            description
                            stock
                            price
                            createAt
                        }
                    }`,
                variables:{
                    createProductProduct: this.product_in
                },
             }).then((result) => {
                 alert("Producto creado satisfactoriamente")
             }).catch((error) => {
                 console.log(error)
                 alert("No se ha podido crear el producto")
             });
         },
     },
};


</script>

<style>
    *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    #Products{
        margin-top: 45px;
        padding-bottom: 100px;
    }
    .imageTools{
        background-image: url('../../public/tools.jpg');
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
        display: flex;
        height: 30vh;
        align-items: center;
        justify-content: center;
        justify-items: center;
        align-content: center;
        text-align: center;
    }
    .crearProductos{
        display: flex;
        background: whitesmoke;
        margin: 0px auto;
        padding: 10px;
        width: 60%;
        justify-content: center;
        align-items: center;
        border-radius: 5px;
    }
    .crearProductos .caja-search{
        border:  1px solid rgba(128, 128, 128, 0.76);
        border-radius: 20px;
        padding: 4px 10px;
        width: 40%;
        margin: 0 10px;
    }
    .crearProductos input{
        outline: none;
        background: transparent;
        border:  0;
        width: 100%;
    }
    .crearProductos button{
        background: rgb(187, 84, 187);
    }

    .row{
        justify-content: center;
        padding-top: 20px;
    }
    .card{
        margin: 5px;
        border-radius: 20px;
        height: 100%;
    }
    .buttons{
        text-align: center;
    }

    @media (max-width : 767px){
        .crearProductos{
            width: 80%;
        }
    }
    
    /*.auth_user{
        margin: 0;
        padding: 0%;
        height: 100%;
        width: 100%;
    
        display: flex;
        justify-content: center;
        align-items: center;

    }

    .container_auth_user {
        border: 3px solid  #283747;
        border-radius: 10px;
        width: 95%;
        height: 95%;
        
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .auth_user h2{
        color: #283747;

    }

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

    .auth_user button{
        width: 100%;
        height: 40px;

        color: #E5E7E9;
        background: #283747;
        border: 1px solid #E5E7E9;

        border-radius: 5px;
        padding: 10px 25px;
        margin: 5px 0;
    }

    .auth_user button:hover{
        color: #E5E7E9;
        background: crimson;
        border: 1px solid #283747;
    }*/
</style>