package seventh.last;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author ZD
 * @date 2020-10-09 16:30
 */
public class ClientReader implements Runnable {

    private Socket socket;

    public ClientReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while (true) {
                System.out.println(dis.readUTF());
            }
        } catch (IOException e) {
            System.out.println("聊天室已关闭");
        }
    }
}
