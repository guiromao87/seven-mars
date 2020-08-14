package com.guiromao.sevenmars.config;

import com.guiromao.sevenmars.model.Plateau;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PlateauSingletonProducer {

    @Bean
    @Scope("singleton")
    public Plateau getPlateau() {
        return new Plateau();
    }
}
