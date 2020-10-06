package seventh;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZD
 * @date 2020-10-06 15:17
 */
public class Server {
    public static List<Channel> users = new ArrayList<>();
    public static String SUCCESS_MSG = "Verifying Server!";
    public static String ILLEGAL_MSG = "Illegal User!";
    public static String PASSWORD_WRONG_MSG = "PassWord Wrong!";
    public static String PASSWORD_SUCCESS_MSG = "Registration Successful!";
    public static int VERIFY_MAX_TIME = 3;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8099);

        while (true) {
            // 监听服务
            Socket socket = serverSocket.accept();
            Channel channel = new Channel(socket);
            users.add(channel);
            new Thread(channel).start();

            int verifyTime = 0;
            while (verifyTime++ < VERIFY_MAX_TIME){
                // TODO 客户端界面输出提示信息 "请输入口令密码:"...
                if (verifyUser(channel, channel.receive())){
//                    server.send(PASSWORD_SUCCESS_MSG);
//                    channel.print(PASSWORD_SUCCESS_MSG);
                    break;
                } else {
                    channel.send(PASSWORD_WRONG_MSG);
                }
            }
            if (verifyTime >= VERIFY_MAX_TIME){
                channel.send(ILLEGAL_MSG);
                channel.close();
                channel.setFlag(false);
                continue;
            }
            sendMsg(channel, SUCCESS_MSG);
        }
    }

    private static boolean verifyUser(Channel channel, String password) {
        if (password.equals(channel.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    private static void sendMsg(Channel channel, String msg) {
        for (Channel user : users) {
            if (user != channel) {
                continue;
            }
            user.send(ILLEGAL_MSG);
        }
    }
}
