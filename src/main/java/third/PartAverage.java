package third;

import java.util.Arrays;

/**
 * @author ZD
 * @date 2020-09-15 14:37
 */
public class PartAverage implements Average {
    @Override
    public Double getAverage(int[] array) {
        Arrays.sort(array);
        double average = 0;
        for (int i = 1; i < array.length - 1; i++) {
            average += array[i];
        }
        return average / (array.length - 2);
    }
}
