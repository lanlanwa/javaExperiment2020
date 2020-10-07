package second;

import lombok.Getter;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author ZD
 * @date 2020-10-07 14:03
 */
@Getter
public class BankCard {
    /**
     * 银行卡号
     */
    private String cardId;

    /**
     * 账户余额，默认为0
     */
    private BigDecimal balance = BigDecimal.valueOf(0);

    private List<OperatingRecord> operatingRecords;

    public BankCard() {
        // 生成uuid
        this.cardId = "bank-" + UUID.randomUUID();
        this.operatingRecords = new ArrayList<>();
    }

    public boolean deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        operatingRecords.add(new OperatingRecord("存款", StatusCodeEnum.SUCCESS.getId(), "+" + amount, new DateTime()));
        return true;
    }

    public boolean withdrawal(BigDecimal amount) {
        if (this.balance.compareTo(amount) == -1) {
            operatingRecords.add(new OperatingRecord("取款失败，余额不足", StatusCodeEnum.FAIL.getId(), "0", new DateTime()));
            System.out.println("账户余额不足");
            return false;
        }
        this.balance = this.balance.subtract(amount);
        operatingRecords.add(new OperatingRecord("取款", StatusCodeEnum.SUCCESS.getId(), "-" + amount, new DateTime()));
        return true;
    }
}
