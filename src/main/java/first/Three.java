package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZD
 * @date 2020-09-15 9:36
 */
public class Three {
    public static void main(String[] args) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 101; i < 200; i += 2) {
            boolean isPrime = true;
            for (int j = 3; j < Math.sqrt(i); j++) {
                // 如果可以被整除，则不是素数
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                res.add(i);
            }
        }
        System.out.println(res);
    }
}
