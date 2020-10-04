package sixth.two;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZD
 * @date 2020-10-04 9:13
 */
public class Main {
    public static void main(String[] args) {
        int count = 1;
        Scanner sc = new Scanner(System.in);

        List<String> snoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.print("请输入第" + (i + 1) + "位学生的学号:");
            snoList.add(sc.next());
        }

        File file1 = new File("./src/main/java/sixth/two/myfile1.txt");
        File file2 = new File("./src/main/java/sixth/two/myfile2.txt");
        try {
            FileWriter fileWriter = new FileWriter(file1);
            for (int i = 0; i < count; i++) {
                fileWriter.write("第" + (i + 1) + "位学生的学号是:" + snoList.get(i) + "\n");
            }
            fileWriter.close();
            char[] readRes = new char[1000];
            FileReader fileReader = new FileReader(file1);
            FileWriter fileWriter2 = new FileWriter(file2);

            int n = -1;
            while ((n = fileReader.read(readRes)) != -1) {
                //out将数组b的前n单元写到文件
                for (int i = 0; i < n; i++) {
                    fileWriter2.write(readRes[i]);
                }
            }
            fileReader.close();
            fileWriter2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
