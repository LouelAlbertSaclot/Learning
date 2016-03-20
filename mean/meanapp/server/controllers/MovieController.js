//var restful = require('node-restful');

var Resource = require('resourcejs');
module.exports = function(app, route) {

//  // Setup the controller for REST;
//  var rest = restful.model(
//    'movie',
//    app.models.movie
//  ).methods(['get', 'put', 'post', 'delete']);
//
//  // Register this endpoint with the application
//  rest.register(app, route);

  // Setup the controller for REST;
  Resource(app, '', route, app.models.movie).rest();

  // Return middleware.
  return function(req, res, next) {
    next();
  };
};