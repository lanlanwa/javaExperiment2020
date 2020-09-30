package fifth.three;

import lombok.AllArgsConstructor;

/**
 * @author ZD
 * @date 2020-09-30 14:21
 */
@AllArgsConstructor
public class Conductor implements Runnable {
    String name;
    Integer fiveNumbers;
    Integer tenNumbers;
    Integer twentyNumbers;

    @Override
    public void run() {

    }

    public void Booking(int moneyAmount, int ticketNumbers) {
        switch (moneyAmount) {
            case 20:
                switch (ticketNumbers){
                    case 2:

                        break;
                    case 1:
                }
            case 10:
                switch (ticketNumbers){
                    case 2:
                    case 1:
                }
            case 5:

        }
    }
}
