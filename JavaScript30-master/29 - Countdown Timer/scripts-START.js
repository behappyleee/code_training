const timerSelector = document.querySelectorAll('.timer__button');
let selectedTimeSec = 0;
let selectedTimer;
// TODO 
// 시간 표출 하여 주기 !!!!
function triggerTimer(e) {
    let selectTime = e.srcElement.dataset.time;
    if(selectedTimeSec == selectTime) {
        resetTimer();
        return true;
    }
    selectedTimeSec = selectTime;
    let calTimeStr = calFromNowToSelctTime();
    let endTimeHtml = document.querySelector('.display__end-time');
    endTimeHtml.innerHTML = "Be Back At " + calTimeStr;

    showSelectTimer();
}

function showSelectTimer() {
    let timerHtml = document.querySelector('.display__time-left');
    timerHtml.innerHTML = "INNER HTML TEST !!!!";
    timerOper();
    
}

 function timerOper() {
   
}

function showHtml() {
    console.log('SHOW HTML DATA CHECK TIMER OPER : ' + selectedTimeSec);
    let timerHtml = document.querySelector('.display__time-left');
    selectedTimeSec -= 1;
    timerHtml.innerHTML = selectedTimeSec;
    console.log('SHOW HTML DATA CHECK SELECTED TIME SEC : ' + selectedTimeSec);
}

function calFromNowToSelctTime() {
    let currentNow = new Date();
    let afterSelectedTime = new Date(currentNow.setSeconds(currentNow.getMilliseconds() + selectedTimeSec));
    let calHour = afterSelectedTime.getHours();
    let calMin = afterSelectedTime.getMinutes();
    return calHour + " : " + calMin;
}

function resetTimer() {
    let timerHtml = document.querySelector('.display__time-left');
    let endTimeHtml = document.querySelector('.display__end-time');
    selectedTimeSec = 0
    clearInterval(selectedTimer);
    timerHtml.innerText = '';
    endTimeHtml.innerText = '';
}

timerSelector.forEach((timeSelect) => {
    timeSelect.addEventListener('click', triggerTimer);
})

