import com.itheima.mapper.UserMapper;
import com.itheima.spring.aop.MyTarget;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class Test1 {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        Integer count = userMapper.getCount();
        System.out.println("count:"+count);
    }

}
