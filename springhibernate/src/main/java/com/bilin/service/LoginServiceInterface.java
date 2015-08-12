package com.bilin.service;

import java.util.List;

import com.bilin.dao.entity.MainUser;

/**
 * 登录服务接口
 * @author xinglong
 *
 */
public interface LoginServiceInterface {
	/**
	 * 验证用户名和密码是否存在
	 * @param username
	 * @param password
	 * @param mora
	 * @return
	 */
    public int validate(String username,String password);
    
    /**
     * get mainuser object according to userid
     * @param userid
     * @return
     */
    public MainUser getUser(int userid);
    

    /**
     * regist new user
     * @param newuser
     * @return
     */
    public boolean registUser(MainUser newuser);
    
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public boolean updateUser(MainUser user);
    
}
