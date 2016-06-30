/**
 * Created by cheng on 2016/6/30.
 */
var server_url = 'http://122.9.35.24/moblie/';

//jsonp模式：进入该页，请求数据
//$.ajax({
//    type: 'get',
//    async: false,
//    url: server_url + 'v1/index',
//    contentType: 'application/json',
//    headers: {
//        'Authorization':'Basic xxxxxxxxxxxxx',
//        'X_CSRF_TOKEN':'xxxxxxxxxxxxxxxxxxxx',
//        'Content-Type':'application/json'
//    },
//    dataType: "jsonp",
//    jsonp: "callback",
//    jsonpCallback: "handler",
//    beforeSend: function(xhr, settings) {
//        console.log('beforeSend==> xhr'+xhr + 'settings'+settings);
//    },
//    success: function(xhr, status, data) {
//        console.log('success==> xhr'+xhr + 'status'+status + 'data'+data);
//    },
//    error: function(xhr, errorType, error) {
//        console.log('error==> xhr'+xhr + 'errorType'+errorType + 'error'+error);
//    },
//    complete: function(xhr, status) {
//        console.log('complete==> xhr'+xhr + 'status'+status);
//    }
//})