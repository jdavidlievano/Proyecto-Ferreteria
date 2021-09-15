const movementResolver = {
    Query: {
        obtainMovements: (_, {}, { dataSources }) => dataSources.productAPI.obtainMovements(),
        movementById: (_, { movementId }, { dataSources }) => dataSources.productAPI.movementById(movementId),
        movementsByUserId: (_, { userId }, { dataSources }) => dataSources.productAPI.movementsByUserId(userId),
        movementByProductId: (_, { productId }, { dataSources }) => dataSources.productAPI.movementByProductId(productId),
    },
    Mutation: {
        createMovement: (_, { movement }, { dataSources }) => dataSources.productAPI.createMovement(movement),
        deleteMovementById: (_, { movementId }, { dataSources }) => dataSources.productAPI.deleteMovementById(movementId),
    }
};

module.exports = movementResolver;