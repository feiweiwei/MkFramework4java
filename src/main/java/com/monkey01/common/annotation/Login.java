package com.monkey01.common.annotation;

import java.lang.annotation.*;

/**
 * app登录效验
 * @author feiweiwei
 * @email feiweiwei@139.com
 * @date 2017/9/23 14:30
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
