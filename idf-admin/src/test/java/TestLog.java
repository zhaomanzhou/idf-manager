import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.net.URLDecoder;


@Slf4j
public class TestLog
{
    @Test
    public void test1()
    {
        //Logger logger = LoggerFactory.getLogger(getClass());
        System.out.println(URLDecoder.decode("https%3A%2F%2Fraw.githubusercontent.com%2FACL4SSR%2FACL4SSR%2Fmaster%2FClash%2Fconfig%2FACL4SSR_Online.ini"));
        log.info("ddd");
    }
}
