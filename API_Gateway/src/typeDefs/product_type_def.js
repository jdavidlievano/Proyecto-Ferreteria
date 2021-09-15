const { gql } = require('apollo-server');

const productTypeDefs = gql`
    type Product {
        id: String!
        name: String
        description: String
        stock: Int
        price: Int
        createAt: String
    }

    input ProductInput {
        id: String!
        name: String
        description: String
        stock: Int
        price: Int
    }

    type Query {
        obtainProducts: [Product]
        productById(productId: String!): Product
        productsByName(productName: String!): [Product] 
    }

    type Mutation {
        createProduct(product: ProductInput!): Product
        deleteProductById(productId: String!): String
        updateProductById(productId: String!, name: String, description:String, stock: Int, price:Int): Product
    }

`;

module.exports = productTypeDefs;