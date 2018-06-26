window.onload = function () {
    // 登录选框特效
    var target_id = $('#id');
    target_id.focus(
        function (ev) {
            $(this).parent().css('border','1px solid #A7A4A4');
        }
    );
    target_id.blur(
        function (ev) {
            $(this).parent().css('border','1px solid #DADADA');
        }
    );
    var target_world = $('#password');
    target_world.focus(
        function (ev) {
            $(this).parent().css('border','1px solid #A7A4A4');
        }
    );
    target_world.blur(
        function (ev) {
            $(this).parent().css('border','1px solid #DADADA');
        }
    )
    
    $('#login #submit').click(
        function (e) {
            var Url = '/verify';
            var id = $("#login .id-line input").val();
            var password = $("#login .password-line input").val();
            var upload = {'id':id,'password':password};
            $.ajax({
                    url: Url,
                    data:upload,
                    type:'POST',
                    success:function (data) {
                        if (data == '1'){
                            return_tip("success");
                        }else if (data == '0'){
                            return_tip("fail");
                        }
                    },
                    error:function () {
                        return_tip("error");
                    }
                });






        }
    );

};

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

function tip(show,color) {
    $('#main-container .title').css('background-color',color).children('span').text(show);
    $('#main-container #submit').css('background-color','#63c5ff');
}