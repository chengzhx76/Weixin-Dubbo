/**
 * Created by cheng on 2016/6/15.
 */
$(function () {
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

    // 增加事件
    $(".add").click(function () {
        var obj = $(this);
        var num = parseInt(obj.prev('.count').text());
        if (num >= 999) { // 最多支持购买999个
            $.alert("商品不能超过999个","提示");
            return;
        }
        addCount(obj);
        addTotalCount(obj);

        addTotalPrice(obj);
    });
// 减少事件
    $(".sub").click(function () {
        var obj = $(this);

        var numObj = obj.siblings('.count');
        var num = parseInt(numObj.text());
        if (num<=1) {
            $.alert("至少得购买一个","提示");
            return;
        }

        subCount(obj);
        subTotalCount(obj);

        subTotalPrice(obj);
    })
    // 添加数量
    function addCount(obj) {
        var numObj = obj.siblings('.count');
        var num = parseInt(numObj.text());
        num += 1;
        numObj.text(num);
    };
    // 增加总个数
    function addTotalCount(obj) {
        var totalNum = parseInt($('#count').text().trim());
        var num  = totalNum % 9;
        if(!num) {
            totalNum += 2
        } else {
            totalNum += 1;
        }
        $('#count').text(totalNum);
    }
    // 添加商品金额
    function addTotalPrice(obj) {
        var totalPrice = parseFloat($('#amount').text().trim());
        var singlePrice = parseFloat($('#single').text().trim());
        totalPrice += singlePrice;
        $('#amount').text(totalPrice.toFixed(1));
    }
    // 减少数量
    function subCount(obj) {
        var numObj = obj.siblings('.count');
        var num = parseInt(numObj.text());
        num -= 1;
        numObj.text(num);
    };
    // 减少总个数
    function subTotalCount(obj) {
        var totalNum = parseInt($('#count').text().trim());
        var num  = totalNum % 9;
        if(!num) {
            totalNum -= 2
        } else {
            totalNum -= 1;
        }
        $('#count').text(totalNum);
    }
    // 添加商品金额
    function subTotalPrice(obj) {
        var totalPrice = parseFloat($('#amount').text().trim());
        var singlePrice = parseFloat($('#single').text().trim());
        totalPrice -= singlePrice;
        $('#amount').text(totalPrice.toFixed(1));
    }
});