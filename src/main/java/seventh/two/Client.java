package seventh.two;

import java.io.IOException;
import java.net.Socket;

/**
 * @author ZD
 * @date 2020-10-06 15:15
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 8099);
        Channel channel = new Channel(client);
        new Thread(channel).start();
    }
}
