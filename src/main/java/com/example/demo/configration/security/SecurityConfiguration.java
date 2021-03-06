package com.example.demo.configration.security;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启security注解
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.userDetailsService(userDetailsService())
        .passwordEncoder(new MyPasswordEncorder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home","/regist","/ok/**",
                        "/css/**","/js/**","/imgs/**","/assets/**","/static/assets/**", "/uploads/**", "/static/page/**","/static/BOOTSTRAP/**")
                .permitAll()
                .antMatchers("/articleList/**")
                .permitAll()
//                .antMatchers("/user/**")
//                .hasRole("qq")
                // 安卓权限放行
                .antMatchers("/android/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        http
                .sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/login");
    }


    @Bean
    @Override
    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
        MyUserDetailsService myUserDetailsService = new MyUserDetailsService(userService);
//        System.out.println(myUserDetailsService);
//        ExpressionUrlAuthorizationConfigurer.AuthorizedUrl
        return myUserDetailsService;
    }
}
