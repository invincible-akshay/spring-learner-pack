package com.adn.learnerpack;

import com.adn.learnerpack.config.AppConfig;
import com.adn.learnerpack.services.ZipAndEncryptService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.adn.learnerpack")
@SpringBootApplication
public class LearnerPackApplication {

    public static void main(String[] args) {
        /*SpringApplication app = new SpringApplication(LearnerPackApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);*/

        /*
        try {
            EncryptTester.testEncrypt();
            EncryptTester.testDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/

        //ApplicationContext applicationContext = SpringApplication.run(LearnerPackApplication.class);
        doZipAndEncrypt();

    }

    public static boolean doZipAndEncrypt() {
        ApplicationContext CONTEXT = new AnnotationConfigApplicationContext(AppConfig.class);

        ZipAndEncryptService zipAndEncryptService =  CONTEXT.getBean(ZipAndEncryptService.class);
        zipAndEncryptService.encrypt();
        return false;
    }
}

