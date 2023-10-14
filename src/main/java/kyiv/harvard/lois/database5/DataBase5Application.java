package kyiv.harvard.lois.database5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DataBase5Application {

    public static void main(String[] args) {
        SpringApplication.run(DataBase5Application.class, args);
    }

}
