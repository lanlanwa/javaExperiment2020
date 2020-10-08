package seventh.one;

import seventh.CommonConstantEnum;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ZD
 * @date 2020-10-07 14:37
 */
public class Server {
    private static String password = "111";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8099);
        Socket socket = serverSocket.accept();
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        String receiveStr;

        // 先匹配服务器口令密码
        int verifyTime = 0;
        while (verifyTime++ < CommonConstantEnum.VERIFY_MAX_TIME.getIntValue()) {
            receiveStr = dis.readUTF();
            if (password.equals(receiveStr)) {
                dos.writeUTF(CommonConstantEnum.PASSWORD_SUCCESS_MSG.getStrValue());
                break;
            } else {
                dos.writeUTF(CommonConstantEnum.PASSWORD_WRONG_MSG.getStrValue());
            }
        }
        if (verifyTime >= CommonConstantEnum.VERIFY_MAX_TIME.getIntValue()) {
            socket.close();
            serverSocket.close();
            return;
        }

        // 聊天室功能实现
        boolean flag = true;
        while (flag) {
            dos.writeUTF(sc.nextLine());

            receiveStr = dis.readUTF();
            System.out.println(receiveStr);
        }


        socket.close();
        serverSocket.close();
    }
}
