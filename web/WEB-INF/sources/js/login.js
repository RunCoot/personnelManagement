window.onload = function () {
    // begin 登录选框特效
    var target_id = $('#id');
    target_id.focus(
        function () {
            $(this).parent().css('border','1px solid #FF5A3F');
        }
    );
    target_id.blur(
        function () {
            $(this).parent().css('border','1px solid #DADADA');
        }
    );
    var target_world = $('#password');
    target_world.focus(
        function () {
            $(this).parent().css('border','1px solid #FF5A3F');
        }
    );
    target_world.blur(
        function () {
            $(this).parent().css('border','1px solid #DADADA');
        }
    );
    //// end 登录选框特效

    //提交点击事件
    $('#submit').click(function () {
        avlid();
    });


    //按下回车事件
    $("#password").keydown(function (e) {
        if(13 == e.keyCode ){
            avlid();
        }
    });


};

//校验输入，必须为不为空
function avlid() {
    var id = $("#login .id-line input").val();
    var password = $("#login .password-line input").val();
    if (id.trim().length != 0){
        if ( password.trim().length != 0){
            from_up();
        }else {
            $("#login .password-line input").focus();
        }
    }else {
        $("#login .id-line input").focus();
    }
}

//验证方法
function from_up() {
    var Url = '/verify';
    var id = $("#login .id-line input").val();
    var password = $("#login .password-line input").val();
    var upload = {'id':id,'password':password};
    $.ajax({
        url: Url,
        data:upload,
        type:'POST',
        success:function(data) {
            if (data == '1'){
                window.location.href ="/employee/manager";
                return_tip("success");
            }else if (data == '0'){
                return_tip("fail");
            }else if(data == '2'){
                window.location.href ="/employee/manager";
            }
        },
        error:function () {
            return_tip("error");
        }
    });
}

//根据状态决定颜色
function return_tip(status) {
    switch (status){
        case "success":
            tip("登录成功",'#23f146');
            break;
        case "fail":
            tip("登录失败",'#ff4141');
            break;
        case "error":
            tip("网络未连接",'#807171');
            $('#main-container #submit').css('background-color','#807171');
            break;
        default:
                break
    }
}

//根据状态改变标题
function tip(show,color) {
    $('#main-container .title').css('background-color',color).children('span').text(show);
    $('#main-container #submit').css('background-color','#63c5ff');
}