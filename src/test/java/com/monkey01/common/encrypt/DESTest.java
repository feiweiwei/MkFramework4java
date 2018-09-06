package com.monkey01.common.encrypt;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: feiweiwei
 * @description:
 * @created Date: 16:50 18/9/5.
 * @modify by:
 */
@RunWith(SpringRunner.class)
public class DESTest {

	private String key = "6B@5b7a8434";

	@Test
	public void testDes(){
		String content = "{\"sign\":\"23213424234324\",\"data\":{\"id\":\"1\",\"name\":\"monkey01\"}}";
		//6b0c49d4766817df4609b986fd232c0a005cb83004f11fa1ebcf711400d670736417b40279b4bc1f062028642db0a75014435a11dedd748c3c10f40eb512ab6d

		//随机生成密钥
//		byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded();
		String keyStr = key.toString();
		System.out.println("===" + keyStr);

		SymmetricCrypto des = new SymmetricCrypto(SymmetricAlgorithm.DES, keyStr.getBytes());

//		//加密
//		byte[] encrypt = des.encrypt(content);
//		//解密
//		byte[] decrypt = des.decrypt(encrypt);

		//加密为16进制表示
		String encryptHex = des.encryptHex(content);
		System.out.println("===" + encryptHex);
		//解密为字符串
		String decryptStr = des.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);

		System.out.println("===" + decryptStr);
	}
}
