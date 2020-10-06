package seventh;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author ZD
 * @date 2020-10-06 15:06
 */
public class CloseUtil {
    public static void closeAll(Closeable... closeables){
        for (Closeable closeable : closeables) {
            if (closeable != null){
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
