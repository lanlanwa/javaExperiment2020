package fifth.one;

/**
 * @author ZD
 * @date 2020-09-30 13:54
 */
public class One {
    public static void main(String[] args) {
        EvenNumbersCalculator evenNumbersCalculator = new EvenNumbersCalculator();
        OddNumbersCalculator oddNumbersCalculator = new OddNumbersCalculator();
        Thread evenThread = new Thread(evenNumbersCalculator);
        Thread oddThread = new Thread(oddNumbersCalculator);
        evenThread.start();
        oddThread.start();
    }
}
