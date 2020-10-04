package sixth.one;

import java.io.*;

/**
 * @author 赵龙
 */
public class SecretExample {
    public static void main(String[] arg) {
        File fileone = new File("./src/main/java/sixth/one/hello.txt");
        File filetwo = new File("./src/main/java/sixth/one/hello.secret");
        char[] b = new char[100];
        try {
            //创建指向fileone的字符输入流
            FileReader in = new FileReader(fileone);
            //创建指向fileontwo的字符输出流
            FileWriter out = new FileWriter(filetwo);
            int n = -1;
            while ((n = in.read(b)) != -1) {
                for (int i = 0; i < n; i++) {
                    b[i] = (char) (b[i] ^ 'a');
                }
                //out将数组b的前n单元写到文件
                for (int i = 0; i < n; i++) {
                    out.write(b[i]);
                }
            }
            //out关闭
            out.close();

            //创建指向fileontwo的字符输入流
            in = new FileReader("./src/main/java/sixth/one/hello.secret");
            System.out.println("加密后的文件内容：");
            n = in.read(b);
            while (n != -1) {
                String str = new String(b, 0, n);
                System.out.println("dfjakfjd" + str);
                n = in.read(b);
            }
            in = new FileReader(filetwo);
            System.out.println("解密后的文件内容：");
            while ((n = in.read(b)) != -1) {
                for (int i = 0; i < n; i++) {
                    b[i] = (char) (b[i] ^ 'a');
                }
                String str = new String(b, 0, n);
                System.out.println(str);
            }
            // in关闭
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
