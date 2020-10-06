package seventh;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author ZD
 * @date 2020-10-06 15:10
 */
public class Receive implements Runnable {
    private DataInputStream dis;
    private boolean flag;

    public Receive(Socket socket) {
        try {
            this.dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
            CloseUtil.closeAll(dis, socket);
        }
    }

    @Override
    public void run() {
        while (flag){
            try {
                System.out.println(this.dis.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
                flag=false;
                CloseUtil.closeAll(dis);
            }
        }
    }
}
