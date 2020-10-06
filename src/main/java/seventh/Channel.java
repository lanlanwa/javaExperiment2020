package seventh;

import lombok.Data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
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
    private final String password = "111";

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

    public String receive() {
        String res = "";
        try {
            res = dis.readUTF();
        } catch (IOException e) {
            flag = false;
            CloseUtil.closeAll(dis, dos);
            Server.users.remove(this);
        }
        return res;
    }

    public void send(String str) {
        if (str != null && str.length() != 0) {
            try {
                dos.writeUTF(str);
                dos.flush();
            } catch (IOException e) {
                flag = false;
                CloseUtil.closeAll(dis, dos);
                Server.users.remove(this);
            }
        }
    }

    private void sendOther() {
        String str = this.receive();
        for (Channel channel : Server.users) {
            if (channel == this) {
                continue;
            }
            channel.send(str);
        }
    }

    @Override
    public void run() {
        // 密码验证
        int verifyTime = 0;
        while (verifyTime++ < CommonConstant.VERIFY_MAX_TIME.getIntValue()) {
//            System.out.println("请输入口令密码:");
            String password = sc.nextLine();
            if (verifyPassword(password)) {
                break;
            } else {
                System.out.println(CommonConstant.PASSWORD_WRONG_MSG.getStrValue());
            }
        }
        if (verifyTime >= CommonConstant.VERIFY_MAX_TIME.getIntValue()) {
            System.out.println(CommonConstant.ILLEGAL_MSG.getStrValue());
            this.close();
            this.setFlag(false);
            return;
        }
        System.out.println(CommonConstant.SUCCESS_MSG.getStrValue());
        while (flag) {
            this.sendOther();
        }
    }

    private boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    public void close() {
        CloseUtil.closeAll(dis, dos);
    }
}
