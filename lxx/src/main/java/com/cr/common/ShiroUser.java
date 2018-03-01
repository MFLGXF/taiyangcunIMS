/**
 *
 */
package com.cr.common;

import java.io.Serializable;
import java.util.List;

/**
 * @description：自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 * @date：2016/03/16 17:51
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = -1373760761780840081L;
    public String id;
    public String loginName;
    public String name;
    public String usertype;
    public List<String> roleList;

    public ShiroUser(String id, String loginName, String name, String usertype, List<String> roleList) {
        this.id = id;
        this.loginName = loginName;
        this.name = name;
        this.usertype = usertype;
        this.roleList = roleList;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsertype() {
        return usertype;
    }

    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    /**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     */
    @Override
    public String toString() {
        return loginName;
    }
}