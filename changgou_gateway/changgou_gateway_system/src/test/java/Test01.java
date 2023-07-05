import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @author zzh
 * @description: TODO
 * @date 2023年07月04日 16:25
 */
public class Test01 {
    @Test
    public void test01() throws Exception{
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(hashpw);
        boolean checkpw = BCrypt.checkpw("123", "$2a$10$3yyKX6zBAdf5h75wOiF/DO6bIQGTDe5Pa/hwqsXC1sZ/3JivJ1BzS");
        System.out.println(checkpw);
    }
}
