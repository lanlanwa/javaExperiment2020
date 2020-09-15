package enums;

/**
 * @author ZD
 * @date 2020-09-07 18:18
 */
public enum RegexEnum {
    /**
     * 正整数
     */
    POSITIVE_INTEGER("[0-9]*[1-9][0-9]*"),
    /**
     * 整数
     */
    INTEGER("-?\\d+"),
    /**
     * 小数
     */
    DECIMAL("(-?\\d+)(\\.\\d+)?"),
    /**
     * 日期 2020-10-10
     */
    DATETIME("(\\d{4}|\\d{2})-((1[0-2])|(0?[1-9]))-(([12][0-9])|(3[01])|(0?[1-9]))")
    ;

    public String value;

    RegexEnum(String value) {
        this.value = value;
    }
}
