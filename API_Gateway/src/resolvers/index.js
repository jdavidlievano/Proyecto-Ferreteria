const usersResolver = require('./users_resolver');
const productResolver = require('./product_resolver');
const movementResolver = require('./movement_resolver');

const lodash = require('lodash');

const resolvers = lodash.merge(usersResolver, productResolver, movementResolver);

module.exports = resolvers;