package com.example.crypto_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CryptoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoServerApplication.class, args);
    }

}
