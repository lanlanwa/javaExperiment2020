package first;

/**
 * @author ZD
 * @date 2020-09-15 9:48
 */
public class Five {
    public static void main(String[] args) {
        // XYZ+YZZ=532

        // 直接暴力遍历（嘿嘿嘿
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                for (int z = 0; z < 10; z++) {
                    if (x * 100 + y * 110 + z * 12 == 532) {
                        System.out.println("x,y,z分别为" + x + "," + y + "," + z);
                    }
                }
            }
        }
    }
}
