package first;

/**
 * @author ZD
 * @date 2020-09-15 9:48
 */
public class Five {
    public static void main(String[] args) {
        // XYZ+YZZ=532

        // 直接暴力遍历（嘿嘿嘿
        for (int x = 0; x < 532; x++) {
            for (int y = 0; y < 532; y++) {
                for (int z = 0; z < 532; z++) {
                    if (x * y * z + y * z * z == 532) {
                        System.out.println("x,y,z分别为" + x + "," + y + "," + z);
                    }
                }
            }
        }
    }
}
