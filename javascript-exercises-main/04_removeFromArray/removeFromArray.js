const removeFromArray = function(arr, ...filterArgs) {
    let filteredArr = [];
    let filteredArgs = [...filterArgs];

    for(let i = 0; i<arr.length; i++) {
        if(!filteredArgs.includes(arr[i])) {
            filteredArr.push(arr[i]);
        }
    }
    console.log('FILTERED ARR DATA TEST : ' + JSON.stringify(filteredArr));
    return filteredArr;
};

const removeFromArray_2 = function(arr, ...filterArgs) {
    return arr.filter((item) => !filterArgs.includes(item));
}

// Do not edit below this line
module.exports = removeFromArray;
module.exports = removeFromArray_2;