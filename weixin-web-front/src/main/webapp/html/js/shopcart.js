/**
 * Created by 光灿 on 2016/6/19.
 */


$(function () {


    if ($(".list input[type='checkbox']").prop('checked')) {
        $("#allSelect input[type='checkbox']").prop('checked',true);
        addTotalPrice();
    }

    // 购买
    $(".add").click(function () {
        var obj = $(this);
        var isCheckbox = obj.parents('.weui_cells').find("input[type='checkbox']").is(':checked');
        if (!isCheckbox) {
            obj.parents('.weui_cells').find("input[type='checkbox']").prop("checked",true);
        }
        addCount(obj);
        addSinglePrice(obj);
    });

    // 全选
    var evTimeStamp = 0;
    $('#allSelect').click(function(){
        var now = +new Date();
        if (now - evTimeStamp < 100) {
            return;
        }
        evTimeStamp = now;

        if (!$(this).find('.weui_check').prop('checked')) {
             addTotalPrice();
             $(".list input[type='checkbox']").each(function(index, value){
                 if (!$(value).is(':disabled')) {
                     $(value).prop('checked', true);
                 }
             });
        }else {
            subTotalPrice();
            $(".list input[type='checkbox']").prop("checked",false);
        }
    });
    // 添加数量
    function addCount(obj) {
        var numObj = obj.siblings('.count');
        var num = parseInt(numObj.text());
        num += 1;
        numObj.text(num);
        //if (num > 0) {
        //    obj.animate({marginRight:'8px','fontSize':'28px'},'fast');
        //    obj.siblings('.count').show();
        //    obj.siblings('.sub').show();
        //}
    };
    // 添加单个商品金额
    function addSinglePrice(obj) {
        var totalPrice = parseFloat($('#amount').text().trim());
        var price = parseFloat(obj.parents('.weui_cells').find('.detail .price strong').text().trim());
        //var count = obj.prev().text();
        totalPrice += price;
        $('#amount').text(totalPrice.toFixed(1));
    }


    // 添加金额
    function addTotalPrice() {
        var products = $(".list input[type='checkbox']").map(function(index, value){
            if (!$(value).is(':disabled')) {
                var price = $(value).parents('.weui_cells').find('.detail .price strong').text();
                var count = $(value).parents('.weui_cells').find('.count').text();
                var amount = parseFloat(price.trim()) * parseInt(count.trim());
                var product = {'amount':amount};
                return product;
            }
        }).get();
        var totalPrice = parseFloat($('#amount').text().trim());
        $(products).each(function(index, value) {
            totalPrice += value.amount;
        });
        $('#amount').text(totalPrice.toFixed(1));
    };

    // 添加金额
    function subTotalPrice() {
        var products = $(".list input[type='checkbox']").map(function(index, value){
            if (!$(value).is(':disabled')) {
                var price = $(value).parents('.weui_cells').find('.detail .price strong').text();
                var count = $(value).parents('.weui_cells').find('.count').text();
                var amount = parseFloat(price.trim()) * parseInt(count.trim());
                var product = {'amount':amount};
                return product;
            }
        }).get();
        var totalPrice = parseFloat($('#amount').text().trim());
        $(products).each(function(index, value) {
            totalPrice -= value.amount;
        });
        $('#amount').text(totalPrice.toFixed(1));
    };
});