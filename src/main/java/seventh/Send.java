package seventh;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ZD
 * @date 2020-10-06 14:55
 */
public class Send implements Runnable {
    /**
     * 键盘读入流
     */
    private Scanner sc;
    /**
     * 数据输出流
     */
    private DataOutputStream dos;

    private boolean flag = true;

    public Send() {
        this.sc = new Scanner(System.in);
    }

    public Send(Socket client) {
        this();
        try {
            this.dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            CloseUtil.closeAll(dos, client);
        }
    }

    public void send(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
            CloseUtil.closeAll(dos);
        }
    }

    @Override
    public void run() {
        while (flag) {
            System.out.println("输入需要发送的数据");
            this.send(sc.next());
        }
    }
}
