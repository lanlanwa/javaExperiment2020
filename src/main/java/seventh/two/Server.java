package seventh.two;

import seventh.CommonConstantEnum;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZD
 * @date 2020-10-06 15:17
 */
public class Server {
    public static List<Channel> users = new ArrayList<>();
    private static String password = "111";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8099);

        while (true) {
            // 监听服务
            Socket socket = serverSocket.accept();
            Channel channel = new Channel(socket);
            users.add(channel);

            new Thread(channel).start();

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

            // 服务器聊天室功能实现
            while (true) {
                dos.writeUTF(sc.nextLine());

                receiveStr = dis.readUTF();
                System.out.println(receiveStr);
            }

        }
    }
}
