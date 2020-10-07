package second;

import lombok.AllArgsConstructor;
import org.joda.time.DateTime;

/**
 * @author ZD
 * @date 2020-10-07 14:12
 */
@AllArgsConstructor
public class OperatingRecord {
    /**
     * 操作信息
     */
    private String msg;

    /**
     * 操作状态码
     */
    private int statusCode;

    /**
     * 余额变动信息
     */
    private String balanceChange;

    /**
     * 操作时间
     */
    private DateTime operatingTime;

    public void display() {
        System.out.print(this.msg + "\t" + this.balanceChange + operatingTime.toString("yyyy-MM-hh HH:mm:ss"));
    }
}
