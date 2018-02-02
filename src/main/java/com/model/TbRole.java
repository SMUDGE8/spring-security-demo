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

import javax.persistence.*;

/**
 * tableName tb_role
 * 
 * @author lei
 * @date 2018-02-01
 */
@Entity
@Table(name = "tb_role", schema = "security")
public class TbRole implements GrantedAuthority {
    /** 版本号 */
    private static final long serialVersionUID = -6414503302251093606L;
    
    /**  */
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**  */
    @Column(name = "role_name", unique = true, nullable = true, length = 45)
    private String roleName;
    
    /**  */
    @Column(name = "role_description", nullable = true, length = 100)
    private String roleDescription;
    
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
     * 获取
     * 
     * @return 
     */
    public String getRoleName() {
        return this.roleName;
    }
     
    /**
     * 设置
     * 
     * @param roleName
     *          
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getRoleDescription() {
        return this.roleDescription;
    }
     
    /**
     * 设置
     * 
     * @param roleDescription
     *          
     */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getAuthority() {
        return this.roleName;
    }
}