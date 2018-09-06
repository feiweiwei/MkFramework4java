package com.monkey01.common.domain;

import java.io.Serializable;
import java.util.Map;

/**
 * @author: feiweiwei
 * @description:
 * @created Date: 17:37 18/9/5.
 * @modify by:
 */
public class MkRequest implements Serializable {
	private String sign;
	private Map data;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Map getData() {
		return data;
	}

	public void setData(Map data) {
		this.data = data;
	}
}
