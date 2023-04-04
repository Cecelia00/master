window.onload = function() {
    let slideshow = new Slideshow();
    slideshow.init();
}

function Slideshow() {
    let imgBtnGroup = document.querySelector('#img-btn-box').children;
    let imgGroup = document.querySelector('#img-box').children;
    // 计数器
    let showIndex = 0;
    // 计时器
    let timer = null;

    // 初始化
    this.init = function() {
        changeImg(showIndex);
        onListenEvent();
        onAutoPlay();
    }

    // 事件监听
    function onListenEvent() {
        Object.values(imgBtnGroup).forEach((item, index) => {
            item.onmouseover = function() {
                clearInterval(timer)
                showIndex = index;
                changeImg(showIndex);
            }
            item.onmouseout = function() {
                onAutoPlay();
            }
        })
    }

    // 改变图片
    function changeImg(index) {
        Object.values(imgBtnGroup).forEach((item, i) => {
            item.classList.remove('img-btn-show');
            imgGroup[i].classList.remove('img-show');
            if(index === i) {
                item.classList.add('img-btn-show');
                imgGroup[i].classList.add('img-show');
            }
        })
    }

    // 自动播放
    function onAutoPlay() {
        timer = setInterval(() => {
            showIndex = showIndex === imgGroup.length - 1? 0 : ++showIndex;
            changeImg(showIndex);
        }, 4000);
    }
}