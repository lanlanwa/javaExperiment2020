package seventh.last;

import lombok.Getter;

import java.net.Socket;

/**
 * 包装用户信息
 *
 * @author ZD
 * @date 2020-10-08 9:37
 */
@Getter
public class User {
    /**
     * 用户id
     */
    private String uid;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户对应Socket
     */
    private Socket socket;

    public User(String uid, Socket socket) {
        this(uid,"",socket);
    }

    public User(String uid, String name, Socket socket) {
        this.uid = uid;
        this.name = name;
        this.socket = socket;
    }
}
