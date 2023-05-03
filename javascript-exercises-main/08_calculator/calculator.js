const add = function(a, b) {
	return (a+b);
};

const subtract = function(a, b) {
	return (a-b);
};

const sum = function(...args) {
	let arrSum = 0;
  let sumTest = args.forEach((item) => {
    return (arrSum += item)
  });
  
  console.log(sumTest);

  return arrSum;  
};

const multiply = function(a ,b) {
  return (a*b);
};

const power = function(num) {
  let loopNum = num;
  let returnNum = 1;
  while(loopNum > 0) {
    returnNum *= num;
    loopNum--;
  }
  return returnNum;
};

const factorial = function(num) {
  return recursiveFactorial(num);
};

const recursiveFactorial = function (num) {
  if(num == 0) return;
  return (num * recursiveFactorial(--num));
}


// Do not edit below this line
module.exports = {
  add,
  subtract,
  sum,
  multiply,
  power,
  factorial
};
