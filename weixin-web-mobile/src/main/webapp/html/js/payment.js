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
    });
})