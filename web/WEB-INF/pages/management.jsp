<%@page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>绿叶-我就是</title>
    <link rel="icon" href="/sources/imgs/web.ico" type="image/x-icon">
    <link rel="stylesheet" href="/sources/css/bossView.css" type="text/css">
    <link rel="stylesheet" href="/sources/css/css/font-awesome.min.css">
</head>
<body>
    <div id="main-frame">
        <div class="menu-col">
            <div class="menu-items">
                <div class="menu-item-logo"></div>
                <div class="menu-item-index item active">
                    <span class="fa fa-home"></span>
                    首页
                    <i class="fa fa-chevron-right"></i>
                </div>
                <div class="menu-item-employee item">
                    <span class="fa fa-user-circle-o"></span>
                    员工管理
                    <i class="fa fa-chevron-right"></i>
                </div>
                <div class="menu-item-about item">
                    <span class="fa fa-commenting-o"></span>
                    关于我们
                    <i class="fa fa-chevron-right"></i>
                </div>
                <div class="menu-item-back item" id="want-to-back">
                    <span class="fa fa-window-close-o"></span>
                    退出登录
                </div>
            </div>
        </div>
        <div class="content-col">
            <%--index-section--%>
            <div class="index-content no-select select table-cell">
                <div class="logo-row">
                    <div class="display-who">
                        <span class="user">欢迎：${ianwho} 大老板</span>
                    </div>
                    <div class="logo-container">
                        <div class="slogan">哪里有阳光，哪里就有我们</div>
                        <div class="logo"></div>
                    </div>
                </div>
                <div class="company-info">
                    <div class="info-section">
                        <div class="company-finance">

                            <span class="info-title">财务状况</span>
                            <div class="finance-all">
                                <span class="finance-title">总资产：</span>
                                <div class="show-finance">
                                    <span>￥</span>
                                    21331231.12
                                </div>
                            </div>
                        </div>
                        <div class="company-employee">
                            <span class="employee-title">员工状况</span>
                            <div class="employee-section">
                                <span class="people">${employee_amount}</span>
                                <i class="fa fa-child"></i>
                            </div>
                        </div>
                        <div class="company-open" style="margin-top: 7px;">
                            <span class="open-title">营业情况</span>
                            <div class="open-section" style="background-color: #7f83ff;">
                                <span class="judge">良好</span>
                                <i class="fa fa-smile-o"></i>
                            </div>
                        </div>
                        <div class="company-befor" style="margin-top: 7px;">
                            <span class="befor-title">发展前景</span>
                            <div class="befor-section" style="background-color: #ff8e8e;">
                                <span class="befor">良好</span>
                                <i class="fa fa-sun-o"></i>
                            </div>
                        </div>
                        <div class="company-know" style="margin-top: 7px;">
                            <span class="know-title">知名度</span>
                            <div class="know-section" style="background-color: #ffb715;">
                                <span class="know">良好</span>
                                <i class="fa fa-star-half-full"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
          <%--index-section--%>
            <div class="employee-content no-select table-cell">

                <div class="logo-row">
                    <div class="display-who">
                        <span class="user">欢迎：${ianwho} 大老板</span>
                    </div>

                    <div class="logo-container">
                        <div class="slogan">哪里有阳光，哪里就有我们</div>
                        <div class="logo"></div>
                    </div>

                </div>
                <div class="table-show">
                    <%--begin 工具栏 查询，增加--%>
                    <div class="func-bar" >
                        <div class="bar-container">
                            <div class="find-container">
                                <input type="text" id="search" placeholder="输入：工号查询">
                                <div class="search-btn">
                                    <i class="fa fa-search"></i>
                                </div>
                            </div>
                            <div class="add">增加</div>
                            <div class="display-table">刷新</div>
                        </div>
                    </div>
                   <%--end 工具栏 查询，增加--%>
                    <div class="page-row">
                        <table border="1" cellspacing="0" id="page-table">
                            <tr class="title-dont-del">
                                <th>工号</th>
                                <th>身份证</th>
                                <th>姓名</th>
                                <th>年龄</th>
                                <th>性别</th>
                                <th>工资</th>
                                <th>部门</th>
                                <th>职位</th>
                                <th>备注</th>
                                <th>编辑</th>
                            </tr>
                        </table>
                    </div>

                </div>
            </div>
            <div class="about-content no-select table-cell">

                <div class="logo-content">
                    <div class="logo-top">
                        <span class="fa fa-eercast"></span>
                    </div>
                    <div class="logo-bott">
                        <span>哪里有阳光，哪里就有我们</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="model-dialog">
        <div class="add-dialog">
            <div class="add-title">
                <span>增加职员</span>
            </div>
            <form id="add-employee">
                <div class="emp-cla add-row">
                    <lable for="emp-id">工号</lable>
                    <input type="text" id="emp-id" class="add-conten">
                </div>
                <div class="identi-cla add-row">
                    <lable for="identi-id">身份证号码</lable>
                    <input type="text" id="identi-id" class="add-conten">
                    <span class="none-none"></span>
                </div>
                <div class="name-cla add-row">
                    <lable for="name-id">姓名</lable>
                    <input type="text" id="name-id" class="add-conten">
                </div>
                <div class="age-cla add-row">
                    <lable for="age-id">年龄</lable>
                    <input type="text" id="age-id" class="add-conten">
                </div>
                <div class="sex-cla add-row">
                    <lable for="sex-id">性别</lable>
                    <select  id="sex-id" class="add-conten">
                        <option value="male" check>男</option>
                        <option value="female">女</option>
                    </select>
                </div>
                <div class="salary-cla add-row">
                    <lable for="salary-id">工资</lable>
                    <input type="text" id="salary-id" class="add-conten">
                </div>
                <div class="depart-cla add-row">
                    <lable for="depart-id">部门</lable>
                    <input type="text" id="depart-id" class="add-conten">
                </div>
                <div class="posi-cla add-row">
                    <lable for="posi-id">职位</lable>
                    <input type="text" id="posi-id" class="add-conten">
                </div>
                <div class="remark-cla">
                    <lable for="add-remark">描述</lable>
                    <textarea  id="add-remark" cols="30" rows="10" class="add-conten"></textarea>
                </div>
                <div class="submit-add">
                    <div class="add-btn">增加</div>
                </div>
                <div class="cance-add">
                    <div class="cance-btn">取消</div>
                </div>
            </form>
        </div>
    </div>
    <script src="/sources/js/jquery.min.js" type="text/javascript"></script>
    <script src="/sources/js/managerOperation.js"></script>
</body>
</html>