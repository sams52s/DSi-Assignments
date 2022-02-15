package com.sams.TeachingHome.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
           StudentModel sams= new StudentModel(
                    "Sams",
                    "8",
                    "Physics",
                    "5000"
           );
            StudentModel toufiq= new StudentModel(
                    "toufiq",
                    "8",
                    "Physics",
                    "3000"
            );

            repository.saveAll(
                    List.of(sams,toufiq)
            );
        };
    }
}
