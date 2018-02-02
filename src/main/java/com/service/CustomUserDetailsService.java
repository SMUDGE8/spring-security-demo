package com.service;

import com.dao.UserDao;
import com.model.TbRole;
import com.model.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lei
 * @since 2018/2/1
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Autowired
    UserDao userDao;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<TbUser> users = userDao.findByUsername(username);
        if (users.size() == 0) {
            throw new UsernameNotFoundException(this.messages.getMessage("JdbcDaoImpl.notFound", new Object[]{username}, "Username {0} not found"));
        } else {
            TbUser user = users.get(0);
            List<String> roles = userDao.findAllByUserName(username);
            Set<GrantedAuthority> authority=new HashSet<GrantedAuthority>();
            for (String role : roles) {
                authority.add(new SimpleGrantedAuthority(role));
            }
            if (authority.size() == 0) {
                throw new UsernameNotFoundException(this.messages.getMessage("CustomUserDetailsService.noAuthority", new Object[]{username}, "User {0} has no GrantedAuthority"));
            } else {
                return new User(username, user.getPassword(),authority);
            }
        }
    }
}
