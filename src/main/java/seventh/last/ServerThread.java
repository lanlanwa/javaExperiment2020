package seventh.last;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

/**
 * 服务器端充当媒介
 * 1.读取某个客户端的消息
 * 2.转发给聊天室其他的人
 *
 * @author ZD
 * @date 2020-10-09 17:40
 */
public class ServerThread implements Runnable {
    private User user;

    public ServerThread(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(this.user.getSocket().getInputStream());
            String str;
            while (true) {
                str = dis.readUTF();
                System.out.println(this.user.getUid() + "：" + str);
                // 转发
                for (User user : Server.users.values()) {
                    if (user.getSocket() != this.user.getSocket()) {
                        DataOutputStream dataOutputStream = new DataOutputStream(user.getSocket().getOutputStream());
                        dataOutputStream.writeUTF(this.user.getName() + "：" + str);
                        dataOutputStream.flush();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(this.user.getName() + "下线了");
        }
    }
}
