const helloWorld = function() {
  return 'Hello, World!'
};

const customLog = function(msg) {
  return console.log(`This is Custom MSG : ${msg}`);
}

function logCustomPrototype(test) {
  
}

logCustomPrototype.prototype = function () {
  console.log('THIS IS CONSOLE.LOG PROTITYPE !!')
};

module.exports = helloWorld;
