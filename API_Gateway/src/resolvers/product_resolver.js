const productResolver = {
    Query: {
        obtainProducts: (_,{}, { dataSources }) => dataSources.productAPI.obtainProducts(),
        productById: (_, { productId }, { dataSources }) => dataSources.productAPI.productById(productId),
        productsByName: (_, { productName }, { dataSources }) => dataSources.productAPI.productsByName(productName),
    },
    Mutation: {
        createProduct: (_, { product }, { dataSources }) => dataSources.productAPI.createProduct(product),
        deleteProductById: (_, { productId }, { dataSources }) => dataSources.productAPI.deleteProductById(productId),
        updateProductById: (_, { productId, name, description, stock, price }, { dataSources }) => {
            const product = {}
            if (!product){
                throw new Error(`No se puedo encontrar el producto con id: ${productId}`);
            }
        
            return dataSources.productAPI.updateProductById(productId,name, description, stock, price)
        },
    }
};

module.exports = productResolver;