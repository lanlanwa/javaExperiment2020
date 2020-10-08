package seventh.last;

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
    private static Map<String, User> users = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // 服务器Socket创建
        ServerSocket server = new ServerSocket(9999);
        while (true) {
            // 监听客户端连接
            Socket socket = server.accept();
            // 接受客户端传来的uid和密码

            // 登录业务判断

            // 存入集合
//            Server.users.put(uid, new User(uid, password, socket));
        }
    }
}
