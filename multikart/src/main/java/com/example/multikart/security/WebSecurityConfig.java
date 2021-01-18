package com.example.multikart.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.multikart.service.CustomerDetailsServiceImpl;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @Order(1)
    public static class CustomerSecurityConfig extends WebSecurityConfigurerAdapter{
        @Autowired
        private CustomerDetailsServiceImpl customerDetailsService;
        @Autowired
        private PasswordEncoder encoder;
        @Override
        public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
            authenticationManagerBuilder.userDetailsService(customerDetailsService).passwordEncoder(encoder);
        }
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().authorizeRequests()
                    .antMatchers("/thanh-toan").authenticated()
                    .antMatchers("/*").permitAll()
                    .and()
                    .formLogin()
                    .loginPage("/dang-nhap")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/danh-sach-san-pham")
                    .permitAll();

        }
    }

}
