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

            sendOther("加入了聊天室！");
            // 聊天室功能实现
            String str;
            while (true) {
                str = dis.readUTF();
                // 转发
                sendOther(str);
            }
        } catch (IOException e) {
            System.out.println(this.user.getName() + "下线了");
        }
    }

    private void sendOther(String str) throws IOException {
        // 服务器回显
        System.out.println(this.user.getUid() + "：" + str);
        for (User user : Server.users.values()) {
            if (user.getSocket() == this.user.getSocket()) {
                continue;
            }
            DataOutputStream dataOutputStream = new DataOutputStream(user.getSocket().getOutputStream());
            dataOutputStream.writeUTF(this.user.getName() + "：" + str);
            dataOutputStream.flush();
        }
    }
}
