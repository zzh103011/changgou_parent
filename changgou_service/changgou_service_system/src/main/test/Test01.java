import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @author zzh
 * @description: TODO
 * @date 2023年07月04日 17:03
 */
public class Test01 {
    @Test
    public void test01() throws Exception{
        BCrypt.checkpw("123456", "");
    }
}
