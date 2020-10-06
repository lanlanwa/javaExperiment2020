package seventh;

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

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8099);
        while (true) {
            // 监听服务
            Socket socket = serverSocket.accept();
            Channel channel = new Channel(socket);
            users.add(channel);
            new Thread(channel).start();
        }
    }
}
