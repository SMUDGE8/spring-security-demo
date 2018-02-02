package com.dao;

import com.model.TbRole;
import com.model.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author lei
 * @since 2018/2/1
 */
public interface UserDao extends JpaRepository<TbUser, Long> ,UserDaoPlus{

    @Query(value = "SELECT * FROM tb_user WHERE tb_username = ?1",nativeQuery = true)
    List<TbUser> findByUsername(String username);

    @Query(value = "SELECT r.role_name FROM tb_user_role ur LEFT JOIN tb_user u ON ur.user_id = u.id LEFT JOIN tb_role r ON ur.role_id = r.id WHERE u.tb_username =?1",nativeQuery = true)
    List<String> findAllByUserName(String userName);
}
