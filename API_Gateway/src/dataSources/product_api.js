const { RESTDataSource } = require('apollo-datasource-rest');
const { extend } = require('lodash');

const serverConfig = require('../server');

class ProductAPI extends RESTDataSource {
    constructor() {
        super();
        this.baseURL = serverConfig.product_api_url;
    }

    async obtainProducts(){
        return await this.get(`/product/`);
    }

    async createProduct(product){
        product = new Object(JSON.parse(JSON.stringify(product)));
        return await this.post(`/product/`, product);
    }

    async productById(productId){
        return await this.get(`/product/${productId}`);
    }

    async productsByName(productName){
        return await this.get(`/product/query?name=${productName}`);
    }

    async deleteProductById(productId){
        return await this.delete(`/product/${productId}`);
    }

    async updateProductById(productId, name, description, stock, price){
        return await this.put(`/product/${productId}`, {name, description, stock, price});
    }


    async obtainMovements(){
        return await this.get(`/movement/`);
    }

    async createMovement(movement){
        movement = new Object(JSON.parse(JSON.stringify(movement)));
        return await this.post(`/movement/`, movement);
    }

    async movementById(movementId){
        return await this.get(`/movement/${movementId}`);
    }

    async deleteMovementById(movementId){
        return await this.delete(`/movement/${movementId}`);
    }

    async movementsByUserId(userId){
        return await this.get(`/movement/queryuid?userid=${userId}`);
    }

    async movementByProductId(productId){
        return await this.get(`/movement/querypid?productid=${productId}`);
    }

}

module.exports = ProductAPI;