package com.personnelManagement.core;


import com.personnelManagement.DB.CompanyManager;
import com.personnelManagement.account.Manager;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 * 验证账户类
 *
 * @author iwen
 * */
public class Verify {


    //验证状态
    private boolean isVerify = false;

    private  CompanyManager ManagerHandle;


    public void setManagerHandle(CompanyManager companyManager) {
        this.ManagerHandle = companyManager;
    }


    //验证账号密码
    public void verify(String id,String password){
        //查询数据库
        try {
            Manager m = ManagerHandle.queryUser(id);
            if (m.getPassword().equals(password)) this.isVerify = true;
        }catch (EmptyResultDataAccessException e){
            this.isVerify = false;
        }
        //根据数据库返回值设置isVerify
    }

    //返回是否登陆
    public boolean isVerify() {
        return isVerify;
    }

    public void setVerify(boolean verify) {
        isVerify = verify;
    }

}
