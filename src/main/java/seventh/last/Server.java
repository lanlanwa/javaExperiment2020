package seventh.last;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZD
 * @date 2020-10-08 9:37
 */
public class Server {
    /**
     * 存储在线用户
     */
    public static Map<String, User> users = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // 服务器Socket创建
        ServerSocket server = new ServerSocket(9999);
        while (true) {
            // 监听客户端连接
            Socket socket = server.accept();
            // 登录业务实现
            // 接受客户端传来的uid和密码
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String uid = dis.readUTF();

            // 用户存入集合
            User user = new User(uid, socket);
            Server.users.put(uid, user);

            // 开启线程服务
//            new Thread(new ServerReader(socket)).start();
//            new Thread(new ServerWriter(socket)).start();
            new Thread(new ServerThread(user)).start();
        }
    }
}
