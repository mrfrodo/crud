package no.frode.cruddemo;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

@SpringBootApplication
@EnableCaching
public class CrudDemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(CrudDemoApplication.class);

    @Autowired
    Environment env;

    public static void main(String[] args) {
        logger.info("________Starting CrudDemoApplication______");

        SpringApplication app = new SpringApplication(CrudDemoApplication.class);

        String environement = System.getenv("ENVIRONMENT");

        if (environement == null) {
            environement = "dev";
            app.setAdditionalProfiles(environement);
        }


        if (environement != null) {
            app.setAdditionalProfiles(environement.toLowerCase());
        }

        app.run(args);
        //SpringApplication.run(CrudDemoApplication.class, args);
    }

    void checkProfiles() {
        String[] profiles = env.getActiveProfiles();

        for (String s : profiles) {
            logger.info("__profile {}",s);
        }

    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public void checkEnironments() {
        String[] profiles = env.getDefaultProfiles();
        for (String s : profiles) {
            logger.info("__profile {}__", s);
        }
    }
}
