package third;

import java.util.Scanner;

/**
 * @author ZD
 * @date 2020-09-15 14:26
 */
public class Two {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String testString = sc.nextLine();
        if ("XYZ".equals(testString)) {
            throw new Exception("This is a XYZ");
        }

    }
}
