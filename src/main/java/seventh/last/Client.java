package seventh.last;

import seventh.CommonConstantEnum;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ZD
 * @date 2020-10-08 9:50
 */
public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String receiveStr;
        DataInputStream dis;
        DataOutputStream dos;

        // 登录业务实现
        // 验证连接
        Socket socket;
        try {
            socket = new Socket("localhost", 9999);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());


            System.out.println(CommonConstantEnum.CONNECT_SUCCESS_MSG.getStrValue());

            System.out.println("请输入您的账号：");
            String uid = sc.nextLine();
            send(dos, uid);

            // 口令密码验证
            int verifyTime = 0;
            while (verifyTime++ < CommonConstantEnum.VERIFY_MAX_TIME.getIntValue()) {
                System.out.println("请输入聊天室口令密码：");
                String password = sc.nextLine();
                send(dos, password);
                // 接受服务器验证信息
                receiveStr = dis.readUTF();
                System.out.println(receiveStr);
                if (CommonConstantEnum.PASSWORD_SUCCESS_MSG.getStrValue().equals(receiveStr)) {
                    break;
                }
//                else {
//                    System.out.println(CommonConstantEnum.PASSWORD_WRONG_MSG.getStrValue());
//                }
            }
            if (verifyTime >= CommonConstantEnum.VERIFY_MAX_TIME.getIntValue()) {
                System.out.println(CommonConstantEnum.ILLEGAL_MSG.getStrValue());
                socket.close();
                return;
            }
//            else {
//                System.out.println(CommonConstantEnum.PASSWORD_SUCCESS_MSG.getStrValue());
//            }

            System.out.println("为您的账号起个名字吧：");
            String name = sc.nextLine();

            send(dos, name);

            // 通过socket发送id和密码
            new Thread(new ClientReader(socket)).start();
            new Thread(new ClientWriter(new User(uid, name, socket))).start();
        } catch (Exception e) {
            System.out.println(CommonConstantEnum.CONNECT_FAIL_MSG.getStrValue());
            return;
        }

    }

    private static void send(DataOutputStream dos, String str) throws IOException {
        dos.writeUTF(str);
        dos.flush();
    }
}
