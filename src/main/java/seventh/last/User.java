package seventh.last;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.Socket;

/**
 * @author ZD
 * @date 2020-10-08 9:37
 */
@AllArgsConstructor
@Getter
public class User {
    private String uid;
    private String password;
    private Socket socket;
}
