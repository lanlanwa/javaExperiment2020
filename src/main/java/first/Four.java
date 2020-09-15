package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZD
 * @date 2020-09-15 9:42
 */
public class Four {
    public static void main(String[] args) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i <= 1000; i++) {
            // 先找到该数的所有因子
            List<Integer> divisors = new ArrayList<Integer>();
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    divisors.add(j);
                }
            }
            // 因子求和并验证
            int sum = 0;
            for (Integer k : divisors) {
                sum += k;
            }
            if (sum == i){
                res.add(i);
            }
        }
        System.out.println(res);
    }
}
