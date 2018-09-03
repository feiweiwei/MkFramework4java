package com.monkey01.common.annotation;

import java.lang.annotation.*;

/**
 * @author: feiweiwei
 * @description: 日志切面注解
 * @created Date: 13:25 18/9/3.
 * @modify by:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	String value() default "";
}
