package seventh;

import lombok.Data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZD
 * @date 2020-10-06 15:42
 */
@Data
public class Channel implements Runnable {
    private Scanner sc;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String password = "111";
    private boolean flag = true;

    public Channel(Socket socket) {
        try {
            this.sc = new Scanner(System.in);
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
            CloseUtil.closeAll(dis, dos);
            Server.users.remove(this);
        }
    }

    public Channel(Socket socket, String password) {
        this(socket);
        this.password = password;
    }

    public String receive() {
        String res = "";
        try {
            res = dis.readUTF();
        } catch (IOException e) {
            flag = false;
            CloseUtil.closeAll(dis, dos);
            Server.users.remove(this);
        }
        return res;
    }

    public void send(String str) {
        if (str != null && str.length() != 0) {
            try {
                dos.writeUTF(str);
            } catch (IOException e) {
                flag = false;
                CloseUtil.closeAll(dis, dos);
                Server.users.remove(this);
            }
        }
    }

    private void sendOther(String receive) {
        List<Channel> channels = Server.users;
        for (Channel channel : channels) {
            if (channel == this) {
                continue;
            }
            channel.send(receive);
        }
    }

    @Override
    public void run() {
        while (flag) {
            System.out.println("请输入口令密码:");
            this.send(this.receive());
        }
    }

    public void close() {
        CloseUtil.closeAll(dis, dos);
    }
}
