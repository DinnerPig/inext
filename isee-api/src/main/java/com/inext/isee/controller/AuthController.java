package com.inext.isee.controller;

import com.inext.isee.entity.sys.SysUser;
import com.inext.isee.security.JwtAuthenticationRequest;
import com.inext.isee.security.JwtAuthenticationResponse;
import com.inext.isee.service.AuthService;
import com.inext.isee.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    /**
     * 授权
     * @param authenticationRequest
     * @return
     * @throws AuthenticationException
     */
    //@RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException{
        final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    /**
     * token 刷新
     * @param request
     * @return
     * @throws AuthenticationException
     */
    //@RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException{
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if(refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }

    /**
     * 注册 + 授权
     * @param addedUser
     * @return
     * @throws AuthenticationException
     */
    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody SysUser addedUser) throws AuthenticationException{
        String password = addedUser.getPassword();
        String passwordMd5 = MD5Util.encode(password);
        /**
         * 非法请求 rawPassword = md5(password + malt)
         */
        /*if (!passwordMd5.equals(addedUser.getRawPassword())){
            return null;
        }*/
        //注册
        authService.register(addedUser);
        final String token = authService.login(addedUser.getUsername(), addedUser.getPassword());

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }
}
