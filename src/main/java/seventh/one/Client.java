package seventh.one;

import seventh.CommonConstantEnum;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ZD
 * @date 2020-10-07 14:37
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String password;
        String receiveStr;

        // 验证连接
        Socket socket;
        try {
            socket = new Socket("localhost", 8099);
        } catch (Exception e) {
            System.out.println(CommonConstantEnum.CONNECT_FAIL_MSG.getStrValue());
            return;
        }
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        System.out.println(CommonConstantEnum.CONNECT_SUCCESS_MSG.getStrValue());

        // 口令密码验证
        int verifyTime = 0;
        while (verifyTime++ < CommonConstantEnum.VERIFY_MAX_TIME.getIntValue()) {
            System.out.println("请输入口令密码");
            password = sc.nextLine();
            dos.writeUTF(password);
            receiveStr = dis.readUTF();
            if (CommonConstantEnum.PASSWORD_SUCCESS_MSG.getStrValue().equals(receiveStr)) {
                break;
            } else {
                System.out.println(CommonConstantEnum.PASSWORD_WRONG_MSG.getStrValue());
            }
        }
        if (verifyTime >= CommonConstantEnum.VERIFY_MAX_TIME.getIntValue()) {
            System.out.println(CommonConstantEnum.ILLEGAL_MSG.getStrValue());
            socket.close();
            return;
        } else {
            System.out.println(CommonConstantEnum.PASSWORD_SUCCESS_MSG.getStrValue());
        }

        // 聊天室功能实现
        boolean flag = true;
        while (flag) {
            dos.writeUTF(sc.nextLine());
            receiveStr = dis.readUTF();
            System.out.println(receiveStr);
        }

        socket.close();
    }

}
