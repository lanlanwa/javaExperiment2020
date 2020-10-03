package fifth.three;


import lombok.Data;

/**
 * @author ZD
 * @date 2020-09-30 14:21
 */
@Data
public class BookingPeople {
    private String name;
    private Wallet wallet;
    boolean isBought = false;

    public BookingPeople(String name, int fiveNumbers, int tenNumbers, int twentyNumbers) {
        this.name = name;
        this.wallet = new Wallet(fiveNumbers, tenNumbers, twentyNumbers);
    }
}
