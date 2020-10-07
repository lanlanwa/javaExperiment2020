package seventh;

import lombok.Getter;

@Getter
public enum CommonConstantEnum {
    /**
     * 服务器连接成功信息
     */
    CONNECT_SUCCESS_MSG("Verifying Server!"),
    /**
     * 服务器连接失败信息
     */
    CONNECT_FAIL_MSG("Server Wrong!"),
    /**
     * 口令多次匹配失败信息
     */
    ILLEGAL_MSG("Illegal User!"),
    /**
     * 用户密码错误提示信息
     */
    PASSWORD_WRONG_MSG("PassWord Wrong!"),
    /**
     * 口令匹配成功信息
     */
    PASSWORD_SUCCESS_MSG("Registration Successful!"),
    /**
     * 最大输入次数
     */
    VERIFY_MAX_TIME(3),
    ;

    String strValue;
    Integer intValue;

    CommonConstantEnum(String  value) {
        this.strValue = value;
    }

    CommonConstantEnum(int value) {
        this.intValue = value;
    }
}
