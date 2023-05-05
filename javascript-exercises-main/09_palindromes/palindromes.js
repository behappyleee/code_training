const palindromes = function (str) {
    // 특수문자, 괄호, 점, 공백 모두 제거
    let reg = /[`~!@#$%^&*()_|+\-=?;:'",.<>\{\}\[\]\\\/ ]/gim;
    let plainStr = str.replace(reg, '');
    let smallStr = plainStr.toLowerCase();
    let strArr = smallStr.split('');
    // 앞 뒤가 똑같은 문자 인지 판별 
    for(let i=0;  i<Math.floor(strArr.length/2); i++) {
        if(strArr[i] != strArr[(strArr.length-1-i)]) {
            return false;
        }
    }
    return true;
};

// Do not edit below this line
module.exports = palindromes;
