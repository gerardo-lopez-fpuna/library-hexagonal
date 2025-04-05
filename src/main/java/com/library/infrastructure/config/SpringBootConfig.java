package com.library.infrastructure.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@EntityScan(basePackages = {
        "com.library.infrastructure.adapter.output.jpa.entity"
})
@ComponentScan(basePackages = {
        "com.library.application",
        "com.library.infrastructure"
})
@Import({
        JpaConfig.class,
        WebConfig.class
})
public class SpringBootConfig {

    // Configuración centralizada que:
    // 1. Habilita JPA Auditing (@CreatedDate, @LastModifiedDate)
    // 2. Escanea entidades JPA
    // 3. Organiza el escaneo de componentes
    // 4. Importa otras configuraciones
}