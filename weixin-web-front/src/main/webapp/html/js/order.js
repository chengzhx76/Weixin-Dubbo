/**
 * Created by cheng on 2016/6/15.
 */
$(function () {
    var $totalPrice = $(".total-price").children("strong").text();
    if($totalPrice!="" && $totalPrice!="0") {
        $(".total-price").show();
    }else {
        $(".total-price").hide();
    }
});