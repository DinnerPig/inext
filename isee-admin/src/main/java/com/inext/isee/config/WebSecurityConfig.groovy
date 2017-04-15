package com.inext.isee.config

import com.inext.isee.security.CustomUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

/**
 * WebSecurityConfig
 *
 *
 任何应用考虑到安全，绝不能明文的方式保存密码。密码应该通过哈希算法进行加密。有很多标准的算法比如SHA或者MD5，结合salt(盐)是一个不错的选择。 spring Security 提供了BCryptPasswordEncoder类,实现Spring的PasswordEncoder接口使用BCrypt强哈希方法来加密密码。

 BCrypt强哈希方法 每次加密的结果都不一样。

 * @author zhiliao
 * @since 2017-04-06
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)// 控制权限注解
class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    private  CustomUserService customUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 方式一：无加密
         */
        //user Details Service验证
        //auth.userDetailsService(customUserService());

        /**
         * 方式二：加密 md5
         *
         * 用户名密码是用base64 加密 原文为 admin:admin 即 用户名:密码  内容是放在request.getHeader 的 "authorization" 中
         * 使用 md5加密
         */
        /*auth.userDetailsService(customUserService).passwordEncoder(new PasswordEncoder(){
            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String)rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(MD5Util.encode((String)rawPassword));
            }});*/

        /**
         * 方式三：BCrypt强哈希方法来加密密码
         */
        auth.userDetailsService(customUserService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //CSRF默认支持的方法： GET|HEAD|TRACE|OPTIONS，不支持POST。  http://blog.csdn.net/u012373815/article/details/55047285
        http.csrf().disable()//如果不采用csrf，可禁用security的csrf
            .authorizeRequests()
            .anyRequest().authenticated()
            .antMatchers("/users*").authenticated()
            .antMatchers(HttpMethod.POST).authenticated()
            .antMatchers(HttpMethod.PUT).authenticated()
            .antMatchers(HttpMethod.DELETE).authenticated()
            .antMatchers("*").permitAll()
            .and().sessionManagement()
            .and().httpBasic();//实现Spring Security进行http Basic认证

       /* http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll().and()
                .logout().permitAll();*/


        /**

         1.首先当我们要自定义Spring Security的时候我们需要继承自WebSecurityConfigurerAdapter来完成，相关配置重写对应 方法即可。
         2.我们在这里注册CustomUserService的Bean，然后通过重写configure方法添加我们自定义的认证方式。
         3.在configure(HttpSecurity http)方法中，我们设置了登录页面，而且登录页面任何人都可以访问，然后设置了登录失败地址，也设置了注销请求，注销请求也是任何人都可以访问的。
         4.permitAll表示该请求任何人都可以访问，.anyRequest().authenticated(),表示其他的请求都必须要有权限认证。
         5.这里我们可以通过匹配器来匹配路径，比如antMatchers方法，假设我要管理员才可以访问admin文件夹下的内容，我可以这样来写：.antMatchers("/admin/**").hasRole("ROLE_ADMIN")，也可以设置admin文件夹下的文件可以有多个角色来访问，写法如下：.antMatchers("/admin/**").hasAnyRole("ROLE_ADMIN","ROLE_USER")
         6.可以通过hasIpAddress来指定某一个ip可以访问该资源,假设只允许访问ip为210.210.210.210的请求获取admin下的资源，写法如下.antMatchers("/admin/**").hasIpAddress("210.210.210.210")
         7.更多的权限控制方式参看下表：
         这里写图片描述
         8.这里我们还可以做更多的配置，参考如下代码：

         http.authorizeRequests()
         .anyRequest().authenticated()
         .and().formLogin().loginPage("/login")
         //设置默认登录成功跳转页面
         .defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
         .and()
         //开启cookie保存用户数据
         .rememberMe()
         //设置cookie有效期
         .tokenValiditySeconds(60 * 60 * 24 * 7)
         //设置cookie的私钥
         .key("")
         .and()
         .logout()
         //默认注销行为为logout，可以通过下面的方式来修改
         .logoutUrl("/custom-logout")
         //设置注销成功后跳转页面，默认是跳转到登录页面
         .logoutSuccessUrl("")
         .permitAll();
         */
    }
}
