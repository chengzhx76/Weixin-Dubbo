/**
 * Created by cheng on 2016/6/15.
 */
$(function(){
    $(".weui_textarea").on("input paste" , function(){
        var num_left=60-$(this).val().length;
        if(num_left<0){
            $("#textarea_num").text("超过"+(-num_left)+"字");
            $("#textarea_num").css("color","#E44443");
        }else{
            $("#textarea_num").text("剩余"+(num_left)+"字");
            $("#textarea_num").css("color","#999999");
        }
    });
    $(".more-pay").hide();
    $("#more").click(function(){
        $(".more-pay").fadeToggle('fast');
        var isHas = $(this).hasClass('more');
        if (isHas) {
            $(this).removeClass('more');
        } else {
            $(this).addClass('more');
        }
    });

    $('#back').click(function(){
        $.modal({
            //title: "支付方式",
            text: "你真的不要下单尝尝吗？",
            buttons: [
                { text: "我在想想", onClick: function(){}},
                { text: "不再考虑了", onClick: function(){
                    window.location.href="shopcart.html";
                }},
            ]
        });
    });


});