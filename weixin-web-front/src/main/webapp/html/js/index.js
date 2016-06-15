/**
 * Created by cheng on 2016/6/15.
 */
$(function () {
    $(".add").click(function () {
    });

    $(".alert").click(function(){
        alert("还没做！");
    });

    var $totalPrice = $(".total-price").children("strong").text();
    if($totalPrice!="" && $totalPrice!="0") {
        $(".total-price").show();
    }else {
        $(".total-price").hide();
    }

    $('#slideshow').swipeSlide({
        autoSwipe: true,//自动切换默认是
        speed: 3000,//速度默认4000
        continuousScroll: true,//默认否
        transitionType: 'cubic-bezier(0.22, 0.69, 0.72, 0.88)',//过渡动画linear/ease/ease-in/ease-out/ease-in-out/cubic-bezier
        lazyLoad: true,//懒加载默认否
        firstCallback: function (i, sum, me) {
            me.find('.dot').children().first().addClass('cur');
        },
        callback: function (i, sum, me) {
            me.find('.dot').children().eq(i).addClass('cur').siblings().removeClass('cur');
        }
    });
    $('#notify-txt').swipeSlide({
        autoSwipe: true,//自动切换默认是
        speed: 5000,//速度默认4000
        continuousScroll: true,//默认否
        transitionType: 'ease-in'
    });

    // 购买
    $(".add").click(function (event) {
        event.preventDefault();
        var obj = $(this);

        if($(".total-price").hide()) {
            $(".total-price").show();
            addPrice(obj);
        }else {
            addPrice(obj);
        }

        var imgSrc = obj.parents(".item").children('.pic').children('img').attr('src');
        var imgObj = $('<img src="' + imgSrc + '">').appendTo("body").css({
            "width": "30px",
            "height": "30px",
            "border-radius": "50px",
            "position": "absolute",
            "top": toInteger(obj.offset().top) + toInteger(obj.css("width"))/2-15,
            "left": toInteger(obj.offset().left)+ toInteger(obj.css("height"))/2-15,
        });
        var bool = new Parabola({
            el: imgObj,
            callback: function () {

            },
            stepCallback: function (x, y) {
            }
        });
        // 设置配置参数
        bool.setOptions({
            targetEl: $("#cart"),
            curvature: 0.01,
            duration: 600
        });
        // 开始运动
        bool.start();
    });

    // 添加金额
    function addPrice(obj) {
        var price = obj.siblings(".price").children("strong").text();
        var totalPrice = $(".total-price").children("strong").text();
        var tp = 0;
        if(totalPrice=="") {
            tp = 0 + parseFloat(price);
        }else {
            tp = parseFloat(totalPrice)+parseFloat(price);
        }
        $(".total-price").children("strong").text(tp.toFixed(1));
    }

    // 转换成Int类型
    function toInteger(text){
        text = parseInt(text);
        return isFinite(text) ? text : 0;
    }

});