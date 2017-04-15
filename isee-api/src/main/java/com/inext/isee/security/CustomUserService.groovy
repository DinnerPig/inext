package com.inext.isee.security

import com.inext.isee.entity.sys.SysRole
import com.inext.isee.entity.sys.SysUser
import com.inext.isee.service.SysUserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * CustomUserService
 * 自定义UserDetailsService 接口
 * @author zhiliao
 * @since 2017-04-06
 */
@Service
class CustomUserService implements UserDetailsService{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomUserService.class);

    @Autowired
    SysUserService sysUserService;

    @Override
    UserDetails loadUserByUsername(String userName) {
        //重写loadUserByUsername 方法获得 userdetails 类型用户
        SysUser user = sysUserService.findByUserName(userName);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for(SysRole role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            logger.info("loadUserByUsername: " + user);
        }

        /*return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), authorities);*/
        user.setGrantedAuthorities(authorities); //用于登录时 @AuthenticationPrincipal 标签取值
        user;
    }
}
