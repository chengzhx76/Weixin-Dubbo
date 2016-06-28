/**
 * Created by 光灿 on 2016/6/19.
 */


$(function () {
    var evTimeStamp = 0;
    if ($(".list input[type='checkbox']").prop('checked')) {
        $("#allSelect input[type='checkbox']").prop('checked',true);
        addTotalPrice();
    }

    // 选择单个商品
    $('.list .weui_check_label').click(function() {
        var now = +new Date();
        if (now - evTimeStamp < 100) return;
        evTimeStamp = now;
        var obj = $(this);

        // 无货或下架的不可点击
        var isDisabled = obj.find("input[type='checkbox']").is(':disabled');
        if(isDisabled) return;

        // 全选是否勾选
        var isSelfCheckbox = obj.find("input[type='checkbox']").prop('checked');
        if (isSelfCheckbox) {
            var $allSelect = $('#allSelect').find("input[type='checkbox']");
            var isChecked = $allSelect.prop("checked");
            if (isChecked) {
                $allSelect.prop("checked", false);
            }
        }

        // 总金额的+/-
        if (!obj.find("input[type='checkbox']").prop('checked')) {
            addSingleAllPrice(obj);
        }else {
            subSingleAllPrice(obj);
        }
    });


    // 增加事件
    $(".add").click(function () {
        var obj = $(this);
        // 无货或下架的不可点击
        var isDisabled = obj.parents('.weui_cells').find("input[type='checkbox']").is(':disabled');
        if(isDisabled) return;

        var num = parseInt(obj.prev('.count').text());
        if (num >= 999) { // 最多支持购买999个
            $.alert("商品不能超过"+num+"个","提示");
            return;
        }
        // 该商品是否已勾选
        var isCheckbox = obj.parents('.weui_cells').find("input[type='checkbox']").is(':checked');
        if (!isCheckbox) {
            obj.parents('.weui_cells').find("input[type='checkbox']").prop("checked",true);
            addSingleAllPrice(obj);
        }

        addCount(obj);
        addSinglePrice(obj);
    });

    // 减少事件
    $(".sub").click(function () {
        var obj = $(this);
        // 无货或下架的不可点击
        var isDisabled = obj.parents('.weui_cells').find("input[type='checkbox']").is(':disabled');
        if(isDisabled) return;

        // 数量小于0不执行 后面的函数
        var num = parseInt(obj.next('.count').text());
        if (num <= 0) {
            return;
        }
        if (num != 1) {
            var isCheckbox = obj.parents('.weui_cells').find("input[type='checkbox']").is(':checked');
            if (!isCheckbox) {
                obj.parents('.weui_cells').find("input[type='checkbox']").prop("checked",true);
                addSingleAllPrice(obj);
            }
        }
        subCountAndSinglePrice(obj);
    });

    // 全选
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

    // 小计金额
    function addSubtotal(totalPrice) {
        $('#cost').text(totalPrice.toFixed(1));
        if (totalPrice >= 5) {
            $('#remark').html("运费已免");
        }else if(totalPrice == 0) {
            $('#remark').html("没有选择商品哦");
        }else {
            $('#remark').html("还差"+(5-totalPrice)+"可免运费");
        }
    };

    // 增加单个商品的所有价格
    function addSingleAllPrice(obj) {
        var price = obj.parents('.weui_cells').find('.detail .price strong').text();
        var count = obj.parents('.weui_cells').find('.count').text();
        var amount = parseFloat(price.trim()) * parseInt(count.trim());
        var totalPrice = parseFloat($('#amount').text().trim());

        totalPrice += amount;
        $('#amount').text(totalPrice.toFixed(1));
        addSubtotal(totalPrice);
    }
    // 减少单个商品的所有价格
    function subSingleAllPrice(obj) {
        var price = obj.parents('.weui_cells').find('.detail .price strong').text();
        var count = obj.parents('.weui_cells').find('.count').text();
        var amount = parseFloat(price.trim()) * parseInt(count.trim());
        var totalPrice = parseFloat($('#amount').text().trim());

        totalPrice -= amount;
        $('#amount').text(totalPrice.toFixed(1));
        addSubtotal(totalPrice);
    }
    // 添加数量
    function addCount(obj) {
        var numObj = obj.siblings('.count');
        var num = parseInt(numObj.text());
        num += 1;
        numObj.text(num);
    };
    // 减少数量和单个商品的价格
    function subCountAndSinglePrice(obj) {
        var numObj = obj.next('.count');
        var num = parseInt(numObj.text());
        if (num > 1) {
            num -= 1;
            numObj.text(num);
            subSinglePrice(obj);
        }else if (num == 1) {
            $.confirm("您确定要删除吗?", "删除确认", function () {
                subSinglePrice(obj);
                obj.parents('.weui_cells').fadeOut("200", function (){
                    $(this).remove();
                });
                num -= 1;
                numObj.text(num);
                if (num == 1){
                    var isCheckbox = obj.parents('.weui_cells').find("input[type='checkbox']").is(':checked');
                    if (isCheckbox) {
                        obj.parents('.weui_cells').find("input[type='checkbox']").prop("checked",false);
                    }
                }
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
        totalPrice += price;
        $('#amount').text(totalPrice.toFixed(1));
        addSubtotal(totalPrice);
    }
    // 减少单个商品金额
    function subSinglePrice(obj) {
        var num = parseInt(obj.next('.count').text());
        var totalPrice = parseFloat($('#amount').text().trim());
        var price = parseFloat(obj.parents('.weui_cells').find('.detail .price strong').text().trim());
        if (totalPrice > 0) {
            totalPrice -= price;
            $('#amount').text(totalPrice.toFixed(1));
            addSubtotal(totalPrice);
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
        //var totalPrice = parseFloat($('#amount').text().trim());
        var totalPrice = 0;
        $(products).each(function(index, value) {
            totalPrice += value.amount;
        });
        $('#amount').text(totalPrice.toFixed(1));
        addSubtotal(totalPrice);
    };

    // 减少金额
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
        addSubtotal(totalPrice);
    };
});