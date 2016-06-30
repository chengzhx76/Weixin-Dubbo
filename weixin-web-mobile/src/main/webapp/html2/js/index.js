/**
 * Created by cheng on 2016/6/15.
 */
$(function () {

    $('.sub').hide();
    $('.count').hide();

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
        var $add = $(this);

        addCount($add);

        if($(".total-price").hide()) {
            $(".total-price").show();
            addPrice($add);
        }else {
            addPrice($add);
        }

        var imgSrc = $add.parents(".item").children('.pic').children('img').attr('src');
        var imgObj = $('<img src="' + imgSrc + '">').appendTo("body").css({
            "width": "30px",
            "height": "30px",
            "border-radius": "50px",
            "position": "absolute",
            "top": toInteger($add.offset().top) + toInteger($add.css("width"))/2-15,
            "left": toInteger($add.offset().left)+ toInteger($add.css("height"))/2-15,
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
    // 减少操作
    $(".sub").click(function () {
        var $sub = $(this);
        subCount($sub);
        subPrice($sub);
    });


    //jsonp模式：进入该页，请求数据
    $.ajax({
        type: 'get',
        async: false,
        url: server_url + 'v1/index',
        contentType: 'application/json',
        dataType: "jsonp",
        jsonp: "callback",
        jsonpCallback: "handler",
        success: function(data, status, xhr) {
            console.log(data);
            console.log(status);
            console.log(xhr);
        },
        error: function(xhr, errorType, error) {
            console.log(error);
        },
    });
});

// 添加数量
function addCount(obj) {
    obj.siblings('.sub').show();
    obj.prev('.count').show();
    var count = parseInt(obj.prev().text());
    count += 1;
    obj.prev().text(count);
    obj.parent().siblings(".price").css({
        "font-size":"14px",
        "color":"white",
        "position":"absolute",
        "bottom":"82px",
        "left":"0",
        "border-radius":"6px",
        "background":"#EF4F4F"
    }).children('strong').css("font-size","14px");
}
// 减少数量
function subCount(obj) {
    var count = parseInt(obj.next().text());
    count -= 1;
    if(count == 0) {
        obj.hide();
        obj.siblings('.count').hide();
        obj.parent().siblings(".price").removeAttr('style').children('strong').removeAttr('style');
    }
    obj.next().text(count);
}

// 添加金额
function addPrice(obj) {
    var price = parseFloat(obj.parent().siblings(".price").children("strong").text());
    var totalPrice = parseFloat($(".total-price").children("strong").text());
    totalPrice += price;
    $(".total-price").children("strong").text(totalPrice.toFixed(1));
}
// 减少金额
function subPrice(obj) {
    var price = parseFloat(obj.parent().siblings(".price").children("strong").text());
    var totalPrice = parseFloat($(".total-price").children("strong").text());
    totalPrice -= price;
    if (totalPrice == 0) {
        $(".total-price").hide();
    }
    $(".total-price").children("strong").text(totalPrice.toFixed(1));
}


// 转换成Int类型
function toInteger(text){
    text = parseInt(text);
    return isFinite(text) ? text : 0;
}


function handler(data) {
    console.log(data.data.totalPirce);
}