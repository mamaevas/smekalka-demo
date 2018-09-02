package com.mamaevas.smekalka.demo;

//import com.opentable.db.postgres.embedded.EmbeddedPostgres;
//import com.opentable.db.postgres.embedded.PgBinaryResolver;
//import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.io.InputStream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    public DataSource dataSource() throws Exception {
//        return EmbeddedPostgres
//                .builder()
//                .setPgBinaryResolver(new ClasspathBinaryResolver())
//                .start().getTemplateDatabase();
//    }
//
//    class ClasspathBinaryResolver implements PgBinaryResolver {
//        public InputStream getPgBinary(String system, String machineHardware) throws IOException {
//            ClassPathResource resource = new ClassPathResource(String.format("postgresql-%s-%s.txz", system, machineHardware));
//            return resource.getInputStream();
//        }
//    }

}
