package JedisTest;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.example.redisdemo.Jedis.Util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class jedistest {
    Jedis jedis;

    @BeforeEach
    void setUp(){
        //jedis=new Jedis("127.0.0.1",6379);
        jedis = JedisConnectionFactory.getJedis();
        //jedis.auth();
        jedis.select(0);
    }

    @Test
    void teststring(){
        String result = jedis.set("username","cpy");
        System.out.println("result = " + result);
        String username = jedis.get("username");
        System.out.println("username = " + username);
    }

    @Test
    void testhash(){
        jedis.hset("user:1","name","cpy");
        jedis.hset("user:1","age","23");

        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println(map);
    }

    @AfterEach
    void tearDown(){
        if(jedis!=null){
            jedis.close();
        }
    }
}
