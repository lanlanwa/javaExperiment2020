package seventh.last;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.Socket;

/**
 * 包装用户id和密码
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
     * 用户密码
     */
    private String password;
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

    public User(String uid, String password, Socket socket) {
        this(uid,password,"暂无姓名",socket);
    }

    public User(String uid, String password, String name, Socket socket) {
        this.uid = uid;
        this.password = password;
        this.name = name;
        this.socket = socket;
    }
}
