package com.monkey01.modules.module1.service.impl;


import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monkey01.common.exception.MkException;
import com.monkey01.modules.module1.dao.mapper.UserMapper;
import com.monkey01.modules.module1.domain.dto.UserDO;
import com.monkey01.modules.module1.domain.vo.LoginVO;

import com.monkey01.modules.module1.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
	@Override
	public UserDO queryByMobile(String mobile) {
		UserDO userEntity = new UserDO();
		userEntity.setMobile(mobile);
		QueryWrapper<UserDO> userWrapper = new QueryWrapper<UserDO>(userEntity);
		return baseMapper.selectOne(userWrapper);
	}

	@Override
	public long login(LoginVO form) {
		UserDO user = queryByMobile(form.getMobile());
//		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new MkException("手机号或密码错误");
		}
//
//		if(!user.getPassword().equals(form.getPassword())){
//			throw new MkException("手机号或密码错误");
//		}

		return user.getUserId();
	}
}
