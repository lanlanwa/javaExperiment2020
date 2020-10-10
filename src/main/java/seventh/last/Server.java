package seventh.last;

import seventh.CommonConstantEnum;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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

    private static String password = "111";

    public static void main(String[] args) throws IOException {
        // 服务器Socket创建
        ServerSocket server = new ServerSocket(9999);

        while (true) {
            // 监听客户端连接
            Socket socket = server.accept();
            try {
                // 登录业务实现
                // 接受客户端传来的uid
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String uid = dis.readUTF();

                // 匹配聊天室口令密码
                int verifyTime = 0;
                while (verifyTime++ < CommonConstantEnum.VERIFY_MAX_TIME.getIntValue()) {
                    String receiveStr = dis.readUTF();
                    if (password.equals(receiveStr)) {
                        send(dos, CommonConstantEnum.PASSWORD_SUCCESS_MSG.getStrValue());
                        break;
                    } else {
                        send(dos, CommonConstantEnum.PASSWORD_WRONG_MSG.getStrValue());
                    }
                }
                // 密码匹配失败，关闭该用户线程
                if (verifyTime >= CommonConstantEnum.VERIFY_MAX_TIME.getIntValue()) {
                    socket.close();
                    continue;
                }
                // 匹配成功 读入用户姓名
                String name = dis.readUTF();

                // 用户存入集合
                User user = new User(uid, name, socket);
                Server.users.put(uid, user);

                send(dos, "欢迎进入贵族聊天室！");
                // 开启线程服务
                new Thread(new ServerThread(user)).start();
            } catch (IOException e) {
                System.out.println(socket + "断开连接");
            }
        }
    }

    private static void send(DataOutputStream dos, String str) throws IOException {
        dos.writeUTF(str);
        dos.flush();
    }
}
