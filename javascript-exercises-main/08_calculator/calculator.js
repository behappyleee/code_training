const add = function(a, b) {
	return (a+b);
};

const subtract = function(a, b) {
	return (a-b);
};

const sum = function(args) {
	let arrSum = 0;
  let sumTest = args.forEach((item) => {
    return (arrSum += Number.parseInt(item));
  });
  return arrSum;  
};

const multiply = function(args) {
  let multiDefault = 1;
  args.forEach((item) => {
    multiDefault *= item;
  })
  console.log('ARGS DATA TEST CHECK : ' + multiDefault);

  return multiDefault;
};

const power = function(num, mul) {
  let mulNum = 1;
  for(let i=0; i < mul; i++) {
    mulNum *= num;
  }


  console.log('POWER MUL NUM TEST : ' + mulNum);


  return mulNum;
  // let loopNum = num;
  // let returnNum = 1;
  // while(loopNum > 0) {
  //   returnNum *= num;
  //   loopNum--;
  // }
  // return returnNum;





};

const factorial = function(num) {
  if(num == 0) return 1;
  return recursiveFactorial(num);
};

const recursiveFactorial = function (facNum) {
  if(facNum == 0) return 1;
  return (facNum * recursiveFactorial(--facNum));
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
