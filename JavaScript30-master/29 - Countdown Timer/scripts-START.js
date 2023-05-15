const timerSelector = document.querySelectorAll('.timer__button');

// TODO 
// 시간 표출 하여 주기 !!!!
function triggerTimer(e) {
    let selectTimeSec = e.srcElement.dataset.time;

    console.log('select time sec data : ' + selectTimeSec);
}

timerSelector.forEach((timeSelect) => {
    timeSelect.addEventListener('click', triggerTimer);
})

