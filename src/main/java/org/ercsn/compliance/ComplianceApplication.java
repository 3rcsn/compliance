package org.ercsn.compliance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@SpringBootApplication
@EnableMapRepositories
@EnableFeignClients
public class ComplianceApplication {

    static void main(String[] args) {
        SpringApplication.run(ComplianceApplication.class, args);
    }

}
