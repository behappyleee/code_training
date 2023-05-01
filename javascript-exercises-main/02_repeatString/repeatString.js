const repeatString = function(msg, repeatCount) {
    let appendMsg = ''; 
    
    if(repeatCount < 0) {
        throw new ('ERROR');
    }
    if(repeatCount == 0) {
        return appendMsg;
    }
    
    for(let i= 0; i<repeatCount; i++) {
        appendMsg += msg;
    }

    return appendMsg;
};

// Do not edit below this line
module.exports = repeatString;
