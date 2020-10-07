package second;

import java.math.BigDecimal;

/**
 * @author ZD
 * @date 2020-09-15 12:41
 */
public class Person {
    /**
     * 用户姓名
     */
    protected String name;
    /**
     * 身份证号
     */
    protected String idNumber;

    /**
     * 银行卡实体类，若未开户则为null
     */
    protected BankCard bankCard;

    public Person(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    /**
     * 开户
     */
    public void openAccount() {
        this.bankCard = new BankCard();
    }

    /**
     * 存款
     *
     * @param amount 数额
     */
    public void deposit(BigDecimal amount) {
        this.bankCard.deposit(amount);
    }

    /**
     * 取款
     *
     * @param amount 数额
     */
    public void withdrawal(BigDecimal amount) {
        this.bankCard.withdrawal(amount);
    }

    /**
     * 查询
     */
    public void inquire() {
        System.out.println("账户余额为" + this.bankCard.getBalance());
        System.out.println("以下为账户操作记录:");
        for (OperatingRecord operatingRecord : this.bankCard.getOperatingRecords()) {
            operatingRecord.display();
        }
    }

    /**
     * 销户
     */
    public void closeAccount() {
        this.bankCard = null;
    }

}
