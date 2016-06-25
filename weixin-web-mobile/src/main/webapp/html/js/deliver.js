/**
 * Created by 光灿 on 2016/6/20.
 * http://www.freejs.net/article_tabbiaoqian_29.html
 */
$(function () {
    $('section').hide();
    $(".weui_navbar .weui_navbar_item:first").addClass("tab-red").show();
    $("section:first").show();
    $(".weui_navbar_item").click(function() {
        $(".weui_navbar_item").removeClass("tab-red");
        $(this).addClass("tab-red");
        $("section").hide();
        var activeTab = $(this).find("a").attr("href");
        $(activeTab).fadeIn();
        return false;
    });
});
