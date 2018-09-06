package com.monkey01.common.exception;


/**
 * 错误码枚举类
 *
 * @author feiweiwei
 * @date 2016年10月27日 下午6:34:22
 */
public enum ResultCode {
    //检查输入项不能为空错误码
    IS_NOT_BLANK_ERROR("apm001", "请检查输入项，不能为空"),
    DUPLICATE_DATA_ERROR("apm002", "数据库中已存在该记录"),
    MOBILE_NUMBER_IS_NULL_ERROR("apm003", "手机号不能为空"),

    PASSWORD_IS_NULL_ERROR("apm004", "密码不能为空"),
    AUTHCATION_FAILED("apm005", "没有权限，请联系管理员授权"),
    TOKEN_IS_NOT_VAILD("apm006", "{0}失效，请重新登录"),
    PASSWORD_ERROR("apm007", "密码错误"),
    PARAM_NULL_OR_EMPTY("apm008", "上送参数为空"),
    SUCCESS("000000", "success"),
    UNKNOW_ERROR("999999","系统未知异常"),
    POST_LOGSTASH_ERROR("apm009", "上送logstash异常");



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String code;
    private String message;

    private ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
