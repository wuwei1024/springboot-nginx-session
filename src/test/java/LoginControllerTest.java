import com.test.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author wuwei
 * @date 2018/5/7 18:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LoginControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void login() {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("name", "Jack");
        String result = testRestTemplate.postForObject("/user/login", multiValueMap, String.class);
        System.out.println(result);
    }

    @Test
    public void logout() {
        String result = testRestTemplate.getForObject("/user/logout", String.class);
        System.out.println(result);
    }
}
