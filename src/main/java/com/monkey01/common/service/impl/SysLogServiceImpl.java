package com.monkey01.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monkey01.common.dao.SysLogMapper;
import com.monkey01.common.domain.SysLogDO;
import com.monkey01.common.service.SysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @author: feiweiwei
 * @description: 系统日志服务实现类
 * @created Date: 13:55 18/9/3.
 * @modify by:
 */
@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLogDO> implements SysLogService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public void saveSysLog(SysLogDO sysLogDO) {
		this.saveSysLogFile(sysLogDO);
		this.saveSysLogDB(sysLogDO);
	}

	private void saveSysLogFile(SysLogDO sysLogDO){
		logger.info(sysLogDO.toString());
	}

	private boolean saveSysLogDB(SysLogDO sysLogDO) {
		return this.save(sysLogDO);
	}
}
