const { gql } = require('apollo-server');

const movementTypeDefs = gql`
    type Movement {
        id: String!
        userId: String
        productId: String 
        movement: String
        quantity: Int
        dateMovement: String
    }

    input MovementInput {
        userId: String
        productId: String 
        movement: String
        quantity: Int
    }

    type Query {
        obtainMovements: [Movement]
        movementById(movementId: String!): Movement
        movementsByUserId(userId: String!): [Movement]
        movementByProductId(productId: String!): [Movement]
    }

    type Mutation {
        createMovement(movement: MovementInput!): Movement
        deleteMovementById(movementId: String!): String
    }

`;

module.exports = movementTypeDefs;