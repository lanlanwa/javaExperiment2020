package fifth.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZD
 * @date 2020-09-30 13:56
 */
public class OddNumbersCalculator implements Runnable {
    @Override
    public void run() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            if (0 != i % 2) {
                numbers.add(i);
                System.out.println("奇数计算器运行，其一奇数为" + i);
            }
        }
    }
}
