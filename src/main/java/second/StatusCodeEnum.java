package second;

import lombok.Getter;

/**
 * @author ZD
 * @date 2020-10-07 14:19
 */
@Getter
public enum StatusCodeEnum {
    /**
     * 状态成功信息
     */
    SUCCESS(100, "成功"),
    /**
     * 状态失败信息
     */
    FAIL(0, "失败"),
    ;

    private int id;
    private String msg;

    StatusCodeEnum(int id, String msg) {
        this.id = id;
        this.msg = msg;
    }
}
