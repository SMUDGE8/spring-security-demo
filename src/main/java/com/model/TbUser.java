/*
 * Welcome to use the TableToBean Tools.
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 * 
 * Author:bianj
 * Email:edinsker@163.com
 * Version:3.6.0
 */

package com.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

/**
 * tableName tb_user
 * 
 * @author lei
 * @date 2018-02-01
 */
@Entity
@Table(name = "tb_user", schema = "security")
public class TbUser implements UserDetails {
    /** 版本号 */
    private static final long serialVersionUID = -6567658662887096722L;
    
    /**  */
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** 用户名 */
    @Column(name = "tb_username", unique = true, nullable = true, length = 45)
    private String tbUsername;
    
    /** 密码 */
    @Column(name = "tb_password", nullable = true, length = 60)
    private String tbPassword;
    
    /**  */
    @Column(name = "enabled", nullable = false, length = 10)
    private Integer enabled;
    
    /**
     * 获取
     * 
     * @return 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     * 
     * @param id
     *          
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户名
     * 
     * @return 用户名
     */
    public String getTbUsername() {
        return this.tbUsername;
    }
     
    /**
     * 设置用户名
     * 
     * @param tbUsername
     *          用户名
     */
    public void setTbUsername(String tbUsername) {
        this.tbUsername = tbUsername;
    }
    
    /**
     * 获取密码
     * 
     * @return 密码
     */
    public String getTbPassword() {
        return this.tbPassword;
    }
     
    /**
     * 设置密码
     * 
     * @param tbPassword
     *          密码
     */
    public void setTbPassword(String tbPassword) {
        this.tbPassword = tbPassword;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public Integer getEnabled() {
        return this.enabled;
    }
     
    /**
     * 设置
     * 
     * @param enabled
     *          
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Transient
    public String getPassword() {
        return this.tbPassword;
    }

    @Transient
    public String getUsername() {
        return this.tbUsername;
    }

    @Transient
    public boolean isAccountNonExpired() {
        return false;
    }

    @Transient
    public boolean isAccountNonLocked() {
        return false;
    }

    @Transient
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Transient
    public boolean isEnabled() {
        return false;
    }

}