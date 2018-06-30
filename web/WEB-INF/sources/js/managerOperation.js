window.onload = function () {
    $("#want-to-back").click(
        function () {
            var url = "/back";
            $.ajax(
                url,{
                    type:'GET',
                    success:function () {
                         window.location.href = "/login";
                    },
                     error:function () {
                         alert("退出失败")
                     }
                }
            )
        }
    );

    // 点击首页
    $('.menu-item-index').click(function () {
        select_table('index');
        select_menu(this);
        how_many();
    });
    //点击员工管理
    $('.menu-item-employee').click(function () {
        select_table('employee');
        select_menu(this);
        flash_table();
    });

    //点击关于我们
    $('.menu-item-about').click(function () {
        select_table('about');
        select_menu(this);
        // console.log(flash_table());
    });

    //添加-弹出模态对话框
    $('.add').click(function () {
        clear_model();
        add_model();
        // add_employee();
    });

    $('.cance-btn').click(function () {
        remove_model();
    });

    //发送给服务器
    $('.add-btn').click(function () {
        send_add_data(this);

    });

    //取消提示
    $('#identi-id').change(function () {
        $('.none-none').removeClass('tip_identi');
        $('#identi-id').removeClass('warring');
    });

    //按条件查找
    $('.search-btn').click(function () {
        condit_find();
    });

    $('.search-btn').change(function () {
        $("#search").removeClass('warring');
    });
    
    $('.display-table').click(function () {
        flash_table();
    });


    $('#page-table').on('click','.edit .change-bar',function () {
        if(!$(this).hasClass('save')){
            change_info(this);
        }else{
            $(this).removeClass('save').children('span').text('修改');
            updata(this);
        }
    });

    $('#page-table').on('click','.edit .del-bar',function () {
        var flag =  confirm("是否删除！");
        if(flag){
            del_info(this);
        }
    })
};

//del_info
function del_info(self) {
    var data = $($(self).parent().siblings()[0]).text().trim();
    var d = {};
    d['jodNumber'] = data;
    var url = '/del_obj';

    console.log(d['jodNumber']);
    console.log(data);

    $.ajax(url,{
        type:'POST',
        data:JSON.stringify(data),
        dataType:'json',
        contentType:'application/json',
        success:function(data){
            flash_table();
        },
        error:function () {
            alert('删除失败！')
        }
    })
}


//updata
function updata(self) {
    var infos = {};
    var all = $(self).parent().siblings();

    infos['jodNumber'] = $(all[0]).text().trim();
    infos['id'] = $(all[1]).text().trim();
    infos['name'] = $(all[2]).children('input').val().trim();
    infos['age'] = $(all[3]).children('input').val().trim();
    infos['sex'] = $(all[4]).children('select').val().trim();
    infos['salary'] = $(all[5]).children('input').val().trim();
    infos['department'] = $(all[6]).children('input').val().trim();
    infos['position'] = $(all[7]).children('input').val().trim();
    infos['remark'] = $(all[8]).children('input').val().trim();

    send_serve_data(infos);
}

//修改
function change_info(self) {
    var all = $(self).parent().siblings();
    $(self).addClass('save').children('span').text('保存');
    for (var i = 0;i < all.length; i++){
        if($(all[i]).hasClass('jodnumber') || $(all[i]).hasClass('id')){
            continue;
        }else if($(all[i]).hasClass('sex')){
            var text = $(all[i]).text();
            $(all[i]).html('<select>' +
                '<option value="male">男</option>' +
                '<option value="female">女</option>' +
                '</select>');

            $(all[i]).children().children("option[value='"+text+"']").prop('selected','selected');
        } else {
            var text = $(all[i]).text();
            $(all[i]).html('<input type="text">');
            $(all[i]).children('input').val(text);
        }
    }
}


function condit_find (){
    var condition = $('#search').val().trim();
    if (condition.length != 0){
        condit_query(condition);
    }else {
        $("#search").addClass('warring');
    }
}

function condit_query(data) {
    var d = {};
    d['jodNumber'] = data;
    var url = '/flash_obj';
    $.ajax(url,{
        type:'POST',
        data:JSON.stringify(data),
        dataType:'json',
        contentType:'application/json',
        success:function(data){
            show_emp(data);
        },
        error:function () {
            alert('查询失败！')
        }
    })
}


function clear_model() {
    var all_add_content = $($('#add-employee').children()).children('.add-conten');
    for (var i = 0;i<all_add_content.length;i++){
        var ele = $(all_add_content[i]);
        if(ele.attr('id') == 'sex-id'){
            ele.val('male');
        }else {
            ele.val(' ');
        }
    }

}


//获取add数据
function send_add_data(self) {
    var infos = {};
    var all = $(self).parent().siblings();
    infos['jodNumber'] = $(all[0]).children('#emp-id').val().trim();
    infos['id'] = $(all[1]).children('input').val().trim();
    infos['name'] = $(all[2]).children('#name-id').val().trim();
    infos['age'] = $(all[3]).children('#age-id').val().trim();
    infos['sex'] = $(all[4]).children('#sex-id').val().trim();
    infos['salary'] = $(all[5]).children('input').val().trim();
    infos['department'] = $(all[6]).children('#depart-id').val().trim();
    infos['position'] = $(all[7]).children('#posi-id').val().trim();
    infos['remark'] = $(all[8]).children('#add-remark').val().trim();

    sen_data(infos);
}


function send_serve_data(infos) {
    var url = '/updata_obj';
    $.ajax(url,{
        type:'POST',
        // data:datas,
        data:JSON.stringify(infos),
        dataType:'json',
        contentType:'application/json',
        success:function (data) {

            alert("更新成功！");
            flash_table();
        },
        error:function () {
            alert("更新失败！");
            flash_table();
        }
    });
}

function sen_data(datas) {
    var url = '/add_employee';
    $.ajax(url,{
        type:'POST',
        // data:datas,
        data:JSON.stringify(datas),
        dataType:'json',
        contentType:'application/json',
        success:function (data) {

           alert("添加成功！");
           flash_table();
           remove_model();

        },
        error:function () {
            alert("添加失败！");
            $('.none-none').addClass('tip_identi');
            $('#identi-id').addClass('warring');
        }
    });

}

function flash_table() {
    var url = "/flash_table";
    $.ajax(url,{
        type:'POST',
        dataType:'json',
        success:function (data) {
            // console.log(data)
            show_emp(data);
        },
        error:function () {
            console.log("error")
        }
    })
}


function show_emp(emps){
    $('#page-table .title-dont-del').siblings().remove();
    for (var i = 0;i < emps.length;i++){
        add_employee(emps[i]['jodNumber'],emps[i]['id'],emps[i]['name'],emps[i]['age'],
            emps[i]['sex'],emps[i]['salary'],emps[i]['department'],emps[i]['position'],
            emps[i]['remark']
        )
    }
}


function add_model() {
    $('.model-dialog').addClass('dialog-show');
}

function remove_model() {
    $('.model-dialog').removeClass('dialog-show');
}

//添加用户
function add_employee(jod,id,name,age,sex,salary,depar,posi,remark) {
    var ele = document.createElement('tr');
    var eles = [];
    for (var i = 0; i < 10;i++){
        var el = document.createElement('td');
        eles.push(el);
    }
    $(eles[0]).addClass('jodnumber').text(jod);
    $(eles[1]).addClass('id').text(id);
    $(eles[2]).addClass('name').text(name);
    $(eles[3]).addClass('age').text(age);
    $(eles[4]).addClass('sex').text(sex);
    $(eles[5]).addClass('salary').text(salary);
    $(eles[6]).addClass('departement').text(depar);
    $(eles[7]).addClass('position').text(posi);
    $(eles[8]).addClass('remark').text(remark);
    $(eles[9]).addClass('edit');

    var div1 = document.createElement('div');
    var div2 = document.createElement('div');

    $(div1).addClass('change-bar').html("<i class='fa fa-asterisk'></i>"+"<span class=\"change\">修改</span>");
    $(div2).addClass('del-bar').html("<i class=\"fa fa-shopping-basket\"></i>"+"<span class=\"del\">删除</span>");

    eles[9].append(div1);
    eles[9].append(div2);

    for (var i = 0 ;i < 10; i++){
        $(ele).append(eles[i]);
    }

    $('#page-table tbody').append(ele);

}



//刷新员工数量
function how_many() {
    var url = '/get-amount';
    $.ajax(url,{
        type:'POST',
        success:function (data) {
            $('.employee-section .people').text(data);
        }
    })
}


//选择表格
function select_table(who) {
    $('.table-cell').removeClass('select');
    $('.'+who+'-content').addClass('select');
}

//切换选项
function select_menu(self) {
    $(self).siblings().removeClass('active');
    $(self).addClass('active');
}