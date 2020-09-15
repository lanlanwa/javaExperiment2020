package third;


/**
 * @author ZD
 * @date 2020-09-15 14:32
 */
public class AllAverage implements Average {
    @Override
    public Double getAverage(int[] array) {
        double average = 0;
        for (int i : array) {
            average += i;
        }
        return average / array.length;
    }
}
