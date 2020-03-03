package pl.codeleak.demos.selenium.todomvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.openqa.selenium.chrome.ChromeDriver;

@ExtendWith(SeleniumExtension.class)
public class SeleniumTest {

    @Test
    void projectIsIgnored(ChromeDriver driver) {}

}
