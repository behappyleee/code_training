const reverseString = function(str) {
    let reverseStr = '';
    if(!str) {
        return reverseStr;
    }
    let strArr = str.split('');

    for(let i = (strArr.length-1); i >= 0; i--){
        reverseStr += strArr[i];    
    }

    console.log('reverseStr Test : ' + reverseStr);

    return reverseStr;
};

// Do not edit below this line
module.exports = reverseString;
