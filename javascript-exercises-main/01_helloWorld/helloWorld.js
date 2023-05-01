const helloWorld = function() {
  return 'Hello, World!'
};

function customLog(msg) {
  return console.log(`This is Custom MSG : ${msg}`);
}

function customLog(strMsg, msg) {
  return console.log(strMsg, msg);
}

// const customLog = function(msg) {
//   return console.log(`This is Custom MSG : ${msg}`);
// }

// const customLog = function(strMsg, msg) {
//   return console.log(`This is Custom MSG : ${msg}`);
// }



function logCustomPrototype(test) {
  
}

logCustomPrototype.prototype = function () {
  console.log('THIS IS CONSOLE.LOG PROTITYPE !!')
};

module.exports = helloWorld;
