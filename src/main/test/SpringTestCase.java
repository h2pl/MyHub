/**
 * Created by 周杰伦 on 2018/2/14.
 */
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = { "classpath:spring-data.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTestCase extends AbstractJUnit4SpringContextTests {

}
