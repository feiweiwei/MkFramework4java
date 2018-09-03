package com.monkey01.common.service.impl;

import com.monkey01.common.domain.SysLogDO;
import com.monkey01.common.service.SysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: feiweiwei
 * @description: 系统日志服务实现类
 * @created Date: 13:55 18/9/3.
 * @modify by:
 */
@Service
public class SysLogServiceImpl implements SysLogService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public void saveSysLog(SysLogDO sysLogDO) {
		logger.info(new Date() + sysLogDO.toString());
	}
}
