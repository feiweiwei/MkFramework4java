package com.monkey01.modules.module1.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.monkey01.modules.module1.domain.dto.UserDO;
import com.monkey01.modules.module1.domain.vo.LoginVO;


public interface UserService extends IService<UserDO> {

	UserDO queryByMobile(String mobile);

	long login(LoginVO loginVO);
}
