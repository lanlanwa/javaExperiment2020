package seventh.last;

import java.io.IOException;
import java.net.Socket;

/**
 * @author ZD
 * @date 2020-10-08 9:50
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",9999);
        // 通过socket发送id和密码
    }
}
