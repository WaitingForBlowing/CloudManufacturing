package com.lcl.dao;

import com.lcl.bean.Administrator;

public interface AdministratorDao {

    /**
     * Administrator的登陆方法
     * @param account 超级管理员的账号
     * @param password 超级管理员的密码
     * @return 超级管理员对象
     */
    Administrator login(String account,String password);
}
