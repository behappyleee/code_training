const videoPlayButton = document.querySelector('.player__button.toggle');
// querySelector 로만 사용 할 경우 첫번쨰 요소만 속함
const videoPlaySkipButton = document.querySelectorAll('.player__button.skip_button'); 

const clickPlayVideoButton = () => {
    const videoSelector = document.querySelector('.player__video');
    if(videoSelector.paused) {
        videoSelector.play();
        return;
    }
    videoSelector.pause();
}

// TODO 구현 하기 !
// TODO 비디오 빨리 감기 구현 필요 !!!
// const clickVideSkipButton = (e) => { // 함수 표현식일 경우 this 가 사용 불가함 ...
function  clickVideSkipButton(e) {
    let videoSkipTime = this.dataset.skip;
    const videoSelector = document.querySelector('.player__video');

    console.log('video skip time : ' , videoSkipTime);
    console.log('VIDEO SELECTOR : ' , videoSelector);

    if(!videoSelector.paused) {

        console.log('before video current time : ', videoSelector.currentTime);

        videoSelector.currentTime +=  videoSkipTime;

        console.log('afterrrr !! video current time : ', videoSelector.currentTime);

        videoSelector.play();
    }
}

videoPlayButton.addEventListener('click', clickPlayVideoButton);
videoPlaySkipButton.forEach((skipButton) => skipButton.addEventListener('click', clickVideSkipButton));
   

