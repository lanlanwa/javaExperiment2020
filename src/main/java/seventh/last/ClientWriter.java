package seventh.last;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ZD
 * @date 2020-10-09 16:50
 */
public class ClientWriter implements Runnable {
    private User user;

    public ClientWriter(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        try {
            DataOutputStream dos = new DataOutputStream(user.getSocket().getOutputStream());
            Scanner sc = new Scanner(System.in);
            while (true) {
                dos.writeUTF(sc.nextLine());
                dos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
