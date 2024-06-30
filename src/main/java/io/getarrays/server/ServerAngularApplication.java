package io.getarrays.server;

import io.getarrays.server.enumeration.Status;
import io.getarrays.server.model.Server;
import io.getarrays.server.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;

@SpringBootApplication
public class ServerAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerAngularApplication.class, args);
    }

    //Cuándo iniciamos el proyecto vamos a almacenar los datos de abajo en la bbdd para poder realizar prácticas
    @Bean
    CommandLineRunner run(ServerRepo serverRepo) {
        return args -> {
            serverRepo.save(new Server(null, "10.31.1.92", "Expoalimentaria", "32 GB", "Expoalimentaria", "http://localhost:8080/server/images/server1.png", Status.SERVER_UP));
            serverRepo.save(new Server(null, "10.31.1.62", "Adex Data Trade", "64 GB", "ADT", "http://localhost:8080/server/images/server2.png", Status.SERVER_UP));
            serverRepo.save(new Server(null, "10.31.1.47", "Intranet", "128 GB", "Intranet", "http://localhost:8080/server/images/server3.png", Status.SERVER_UP));
            serverRepo.save(new Server(null, "10.31.1.138", "Landing Productos", "256 GB", "Landing Productos", "http://localhost:8080/server/images/server4.png", Status.SERVER_UP));
        };
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200")); // <-- you may change "*"
        corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Authorization", "content-type"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "content-type"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
