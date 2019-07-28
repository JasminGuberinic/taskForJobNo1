package com.boot;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        /*Flyway fw = new Flyway();
        fw.setDataSource("jdbc:h2:file:~/products", "sa", "", "");
        fw.clean();*/
        SpringApplication.run(App.class, args);
    }
}
