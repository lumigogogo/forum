package testUser;

import com.alibaba.fastjson.JSON;
import com.egg.entity.User;
import com.egg.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class TestMyBatis {

    private static Logger logger = Logger.getLogger(TestMyBatis.class.toString());

    @Resource
    private UserService userService;

    @Test
    public void test1(){
        Long userId = 1000L;

        User user = userService.getUserById(userId);

        logger.info(JSON.toJSONString(user));
    }
}
