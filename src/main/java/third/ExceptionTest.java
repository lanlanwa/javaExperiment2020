package third;

/**
 * @author ZD
 * @date 2020-09-15 14:21
 */
public class ExceptionTest {
    public static void main(String[] args) {
        int i = 0;
        String greeting[] = {"Hello", "Only", "Test"};
        while (i < 4) {
            try {
                System.out.println(greeting[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("数组越界");
            } finally {
                System.out.println("总会运行");
            }
            i++;
        }
    }
}
