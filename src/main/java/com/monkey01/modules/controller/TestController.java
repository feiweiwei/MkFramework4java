package com.monkey01.modules.controller;

import com.monkey01.common.annotation.MkParams;
import com.monkey01.common.annotation.SysLog;
import com.monkey01.common.domain.MkRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: feiweiwei
 * @description:
 * @created Date: 14:54 18/9/3.
 * @modify by:
 */
@RestController
public class TestController {

	@SysLog("测试")
	@PostMapping("/test")
	public String testController(@RequestBody Map req){
		return "hello";
	}

	@PostMapping("/des")
	public String testDesController(@MkParams MkRequest data){

		return data.getSign() + data.getData().get("name");
	}
}
