const findTheOldest = function(people) {
    // TODO Solution 과 데이터 비교하여 보기 !
    if(people.length == 0) return null;
    let oldestPerson = people[0];
    people.forEach((item) => {
        let liveYear = (item.yearOfDeath - item.yearOfBirth);
        let oldestPersonLiveYear = (oldestPerson.yearOfDeath - oldestPerson.yearOfBirth);
        if(liveYear > oldestPersonLiveYear) {
            oldestPerson = item; 
        }
    });//test

    return oldestPerson;
};

const findTheOldestPersonStillLiving = (people) => {
    let person = people[0];
    
    people.forEach((item) => {

    })

    return person;
}

// Do not edit below this line
module.exports = {
    findTheOldest,
    findTheOldestPersonStillLiving
};
