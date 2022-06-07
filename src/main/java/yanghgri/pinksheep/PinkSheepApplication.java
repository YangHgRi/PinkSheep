package yanghgri.pinksheep;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("yanghgri.pinksheep.mapper")
public class PinkSheepApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinkSheepApplication.class, args);
    }

}
