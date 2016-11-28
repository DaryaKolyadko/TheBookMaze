(function(){
    $(window).scroll(function () {
        // значение, на которое сместилась страница при прокрутке
        var top = $(document).scrollTop();
        $('.splash').css({
            //задаём позицию фонового изображения
            'background-position': '0px -'+(top/3).toFixed(2)+'px'
        });
    });
})();

function selectMenuItem(itemId) {
    $(itemId).addClass('active');
}