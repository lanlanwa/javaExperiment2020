package fifth.three;

import lombok.AllArgsConstructor;

/**
 * @author ZD
 * @date 2020-09-30 14:21
 */
@AllArgsConstructor
public class BookingPeople implements Runnable {
    String name;
    Integer fiveNumbers;
    Integer tenNumbers;
    Integer twentyNumbers;

    @Override
    public void run() {

    }
}
