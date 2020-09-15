package first;

import com.alibaba.druid.support.json.JSONUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZD
 * @date 2020-09-15 8:48
 */
public class Two {
    public static void main(String[] args) {
        int[] array = {12, 34, 9, -23, 45, 6, 90, 123, 19, 45, 34};
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入想要查询的数");
        int value = sc.nextInt();
        if (bisearch(value, array)) {
            System.out.println("数组中存在该数");
        } else {
            System.out.println("数组中不存在该数");
        }
    }

    /**
     * 折半查找调用
     *
     * @param value 数值
     * @param array 数组
     * @return 数值是否在数组中
     */
    public static boolean bisearch(int value, int[] array) {
        // 深拷贝，避免对原数组进行操作
        int[] arrayUse = Arrays.copyOf(array, array.length);
        // 数组有序化
        Arrays.sort(arrayUse);
        return bisearch(value, 0, array.length - 1, arrayUse);
    }

    /**
     * 折半查找实现细节
     *
     * @param value 数值
     * @param begin 查找开始位置
     * @param end   查找结束位置
     * @param array 数组
     * @return 数值是否在数组中
     */
    private static boolean bisearch(int value, int begin, int end, int[] array) {
        // 结束标志
        if (begin == end && value != array[begin]) {
            return false;
        }
        if ((end - begin) == 1) {
            if (array[begin] == value || array[end] == value){
                return true;
            } else{
                return false;
            }
        }
        // 折半查找
        if (array[begin + (end - begin) / 2] > value) {
            return bisearch(value, begin, begin + (end - begin) / 2, array);
        } else if (array[begin + (end - begin) / 2] < value) {
            return bisearch(value,  begin + (end - begin) / 2, end, array);
        } else {
            return true;
        }
    }
}
