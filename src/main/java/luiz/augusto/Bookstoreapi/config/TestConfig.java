package luiz.augusto.Bookstoreapi.config;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.database.DatabaseInit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
@RequiredArgsConstructor
public class TestConfig {

    private final DatabaseInit databaseInit;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;
    @Bean
    public void initDatabase(){
        if(ddlAuto.equals("create")) databaseInit.createObjectsForTesting();
    }
}
