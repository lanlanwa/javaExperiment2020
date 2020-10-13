package fifth.three;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ZD
 * @date 2020-10-03 15:37
 */
@Data
@AllArgsConstructor
public class Wallet {
    private Integer fiveNumbers;
    private Integer tenNumbers;
    private Integer twentyNumbers;
    private Integer totalMoney;
    /**
     * 错误标志
     * true 代表出错
     */
    private boolean misMark;

    public Wallet() {
        this(0, 0, 0, 0, false);
    }

    public Wallet(boolean misMark) {
        this(0, 0, 0, 0, true);
    }

    public Wallet(Integer fiveNumbers, Integer tenNumbers, Integer twentyNumbers) {
        this(fiveNumbers, tenNumbers, twentyNumbers, fiveNumbers * 5 + tenNumbers * 10 + twentyNumbers * 20, false);
    }

    /**
     * @param fiveNumbers:
     * @param tenNumbers:
     * @param twentyNumbers:
     * @return 交易是否成功
     * @author ZD
     * @date 2020-10-03
     */
    public boolean add(int fiveNumbers, int tenNumbers, int twentyNumbers) {
        // 判断能否售票员现有票数是否充足
        if (fiveNumbers < 0 && Math.abs(fiveNumbers) > this.fiveNumbers) {
            return false;
        }
        if (tenNumbers < 0 && Math.abs(tenNumbers) > this.tenNumbers) {
            return false;
        }
        if (twentyNumbers < 0 && Math.abs(twentyNumbers) > this.twentyNumbers) {
            return false;
        }
        this.fiveNumbers += fiveNumbers;
        this.tenNumbers += tenNumbers;
        this.twentyNumbers += twentyNumbers;
        this.totalMoney = this.fiveNumbers * 5 + this.tenNumbers * 10 + this.twentyNumbers * 20;
        return true;
    }

    public void add(Wallet change) {
        this.add(change.getFiveNumbers(), change.getTenNumbers(), change.getTwentyNumbers());
    }
}
