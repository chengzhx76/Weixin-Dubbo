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
        var num = parseInt(obj.next('.count').text());
        if (num >= 999) { // 最多支持购买999个
            return;
        }
        addCount(obj);
        addSinglePrice(obj);
    });

    // 减少事件
    $(".sub").click(function () {
        var obj = $(this);
        var num = parseInt(obj.next('.count').text());
        if (num <= 0) {
            return;
        }
        var isCheckbox = obj.parents('.weui_cells').find("input[type='checkbox']").is(':checked');
        if (num != 1) {
            if (!isCheckbox) {
                obj.parents('.weui_cells').find("input[type='checkbox']").prop("checked",true);
            }
        }else if (num == 1){
            if (isCheckbox) {
                obj.parents('.weui_cells').find("input[type='checkbox']").prop("checked",false);
            }
        }
        subCount(obj);
        subSinglePrice(obj);
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
    };
    // 减少数量
    function subCount(obj) {
        var numObj = obj.next('.count');
        var num = parseInt(numObj.text());
        if (num > 1) {
            num -= 1;
            numObj.text(num);
        }else if (num == 1) {
            $.confirm("您确定要删除吗?", "确认删除?", function () {
                obj.parents('.weui_cells').fadeOut("200", function (){
                    $(this).remove();
                });
                num -= 1;
                numObj.text(num);
                //$.toast("删除成功!");
            }, function () {
                //取消操作
            });

        }
    };
    // 添加单个商品金额
    function addSinglePrice(obj) {
        var totalPrice = parseFloat($('#amount').text().trim());
        var price = parseFloat(obj.parents('.weui_cells').find('.detail .price strong').text().trim());
        //var count = obj.prev().text();
        totalPrice += price;
        $('#amount').text(totalPrice.toFixed(1));
    }
    // 减少单个商品金额
    function subSinglePrice(obj) {
        var totalPrice = parseFloat($('#amount').text().trim());
        var price = parseFloat(obj.parents('.weui_cells').find('.detail .price strong').text().trim());
        if (totalPrice > 0) {
            totalPrice -= price;
            $('#amount').text(totalPrice.toFixed(1));
        }
    };
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