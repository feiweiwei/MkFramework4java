package com.monkey01.modules.module1.controller;


import com.monkey01.common.annotation.Login;
import com.monkey01.common.annotation.interceptor.AuthorizationInterceptor;
import com.monkey01.common.domain.MkResponse;
import com.monkey01.common.utils.JwtUtils;
import com.monkey01.modules.module1.domain.dto.UserDO;
import com.monkey01.modules.module1.domain.vo.LoginVO;
import com.monkey01.modules.module1.domain.vo.RegisterVO;
import com.monkey01.modules.module1.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
public class TestUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 登录
     */
    @PostMapping("login")
    public MkResponse login(@RequestBody LoginVO form){

        //用户登录
        long userId = userService.login(form);

        //生成token
        String token = jwtUtils.generateToken(userId);

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());

        return MkResponse.ok(map);
    }

	@PostMapping("register")
	public MkResponse register(@RequestBody RegisterVO form){
		UserDO user = new UserDO();
		user.setMobile(form.getMobile());
		user.setUsername(form.getMobile());
		user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
		user.setCreateTime(new Date());
		userService.save(user);

		return MkResponse.ok();
	}

	@Login
	@PostMapping("queryUser")
	public MkResponse queryUser(HttpServletRequest request){
		Long userId = (Long)request.getAttribute(AuthorizationInterceptor.USER_KEY);

		UserDO userDO = userService.getById(userId);
		return MkResponse.ok().put("user", userDO);
	}

}
