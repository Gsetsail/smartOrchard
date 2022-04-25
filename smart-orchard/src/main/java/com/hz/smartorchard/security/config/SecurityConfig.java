package com.hz.smartorchard.security.config;

import com.hz.smartorchard.security.basicfilter.*;
import com.hz.smartorchard.security.entity.SecurityUser;
import com.hz.smartorchard.security.service.CustomUserDetailService;
import io.swagger.models.HttpMethod;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
      Security的核心配置类,用与验证用户,鉴权..
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService customUserDetailService;
    @Autowired
    private DefaultPasswordEncoder defaultPasswordEncoder;
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailureHandler loginFailureHandler;
    @Autowired
    private LogOutHandler logOutHandler;
    @Autowired
    private TokenAuthenticationEntryPoint tokenAuthenticationEntryPoint;
    @Autowired
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;
    @Autowired
    @Lazy
    private JwtTokenAuthenticationLoginFilter jwtTokenAuthenticationLoginFilter;









    /* private JwtTokenAuthenticationLoginFilter jwtTokenAuthenticationLoginFilter
               = new JwtTokenAuthenticationLoginFilter(redisTemplate);*/


    /*

    认证用户 用户名密码是否正确
 */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(defaultPasswordEncoder);
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        //放行所需要用到的静态资源，允许访问 swagger相关
     /*   web.ignoring().antMatchers(
                "/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html/**",
                "/swagger-ui.html",
                "/webjars/**",
                "/swagger-resources/configuration/ui",
                "/*.html", "/css/**","/img/**","/js/**","/*.ico"
                );*/
        web.ignoring().antMatchers(
                "/**/*.js",
                "/lang/*.json",
                "/**/*.css",
                "/**/*.js",
                "/**/*.map",
                "/**/*.html",
                "/**/*.png",
                "/swagger**/**",
                "/webjars/**",
                "/v2/**"
        );
    }



    /*
        用户授权
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭csrf
        http.csrf().disable();
        // 打开Spring Security的跨域
        http.cors();
        // 配置自定义的类.
        http
                .authorizeRequests()
                // 对于登录login 注册register
                .antMatchers("/login","/register").permitAll()
                .anyRequest().authenticated();
                // 登录配置,登录成功和登录失败处理器是哪一个
        http
                .formLogin()
                .loginProcessingUrl("/login") // 登录表单使用的路径action
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)
                .and()
                // 表明登出处理器是哪一个
                .logout()
                .addLogoutHandler(logOutHandler)
                .logoutUrl("/logout") // 登出表单使用的路径 action
                // 禁用session
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 自定义的异常处理类
                .exceptionHandling()
                 .authenticationEntryPoint(tokenAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .and()
                .addFilterBefore(jwtTokenAuthenticationLoginFilter,UsernamePasswordAuthenticationFilter.class)
                .httpBasic();
    }


    /*
        通过security自带的身份验证管理器对象的authenticate()方法,security会自动认证.
     */

        @SneakyThrows
        @Bean
        public AuthenticationManager authenticationManager()   {

                return super.authenticationManager();
        }

}
