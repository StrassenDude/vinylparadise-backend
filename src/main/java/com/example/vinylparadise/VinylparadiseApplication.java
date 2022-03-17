package com.example.vinylparadise;

import com.example.vinylparadise.storage.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//enable the ConfigurationProperties
@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class VinylparadiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(VinylparadiseApplication.class, args);
    }

}
