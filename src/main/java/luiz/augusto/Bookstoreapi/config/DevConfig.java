package luiz.augusto.Bookstoreapi.config;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.database.DatabaseInit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
@RequiredArgsConstructor
public class DevConfig {

    private final DatabaseInit databaseInit;

    @Bean
    public void initDatabase(){ databaseInit.createObjectsForTesting(); }
    

}
