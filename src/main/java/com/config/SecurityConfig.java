package com.config;

import com.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * @author lei
 * @since 2018/1/30
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //JDBC认证用
    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService customUserDetailsService;

    /**
     * JDBC认证
     * @param auth
     * @throws Exception
     */
    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT tb_username, tb_password, enabled From tb_user WHERE tb_username=?")
                .authoritiesByUsernameQuery("SELECT u.tb_username, r.role_name FROM tb_user_role ur LEFT JOIN tb_user u " +
                        "ON ur.user_id = u.id LEFT JOIN tb_role r ON ur.role_id = r.id WHERE u.tb_username =?");
    }*/


    /**
     * 内存认证
     */
    /*@Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password("$2a$10$9QN8Zz.JN9Ue90VUNi0H8.Gw3XGlJZZIoCs4zDTD4MMA/Nr5UiA4i").roles("USER").build());
        return manager;
    }*/

    /**
     * 自定义UserDetailsService认证
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //将验证过程交给自定义验证工具
        auth.userDetailsService(customUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/hello").access("hasRole('ADMIN')")
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll().and()
                .csrf().disable();
    }
}
