package seventh.two;

import lombok.Data;
import lombok.SneakyThrows;
import seventh.CloseUtil;
import seventh.CommonConstantEnum;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ZD
 * @date 2020-10-06 15:42
 */
@Data
public class Channel implements Runnable {
    private Scanner sc;
    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean flag = true;

    public Channel(Socket socket) {
        try {
            this.sc = new Scanner(System.in);
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
            CloseUtil.closeAll(dis, dos);
            Server.users.remove(this);
        }
    }

    @SneakyThrows
    @Override
    public void run() {
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
        DataInputStream dis = null;
        DataOutputStream dos = null;
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(CommonConstantEnum.CONNECT_SUCCESS_MSG.getStrValue());

        // 口令密码验证
        int verifyTime = 0;
        while (verifyTime++ < CommonConstantEnum.VERIFY_MAX_TIME.getIntValue()) {
            System.out.println("请输入口令密码");
            password = sc.nextLine();
            dos.writeUTF(password);
            dos.flush();
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

        // 客户端聊天室功能实现
        while (true) {
            dos.writeUTF(sc.nextLine());
            dos.flush();

            receiveStr = dis.readUTF();
            System.out.println(receiveStr);
        }

    }
}
