package com.iba.dao.dao.service_classes;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class CloudantConfiguration {

    private CloudantClient client;

    private String billsDb;
    private String clientsDb;
    private String foodDb;
    private String menuDb;
    private String orderDb;
    private String waitersDb;


    @Bean
    public CloudantClient createClient()
    {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            String filename = "cloudant.properties";
            input = CloudantConfiguration.class.getClassLoader().getResourceAsStream(filename);
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        client = ClientBuilder.account(prop.getProperty("account"))
                .username(prop.getProperty("user"))
                .password(prop.getProperty("password"))
                .build();

        billsDb = prop.getProperty("cloudant.bills.dbName");
        clientsDb = prop.getProperty("cloudant.clients.dbName");
        foodDb = prop.getProperty("cloudant.food.dbName");
        menuDb = prop.getProperty("cloudant.menus.dbName");
        orderDb = prop.getProperty("cloudant.orders.dbName");
        waitersDb = prop.getProperty("cloudant.waiters.dbName");

        return client;
    }

    @Bean
    @DependsOn("createClient")
    public Database billDatabase()
    {
        return client.database(billsDb, true);
    }

    @Bean
    @DependsOn("createClient")
    public Database clientDatabase()
    {
        return client.database(clientsDb, true);
    }

    @Bean
    @DependsOn("createClient")
    public Database foodDatabase()
    {
        return client.database(foodDb, true);
    }

    @Bean
    @DependsOn("createClient")
    public Database menuDatabase()
    {
        return client.database(menuDb, true);
    }

    @Bean
    @DependsOn("createClient")
    public Database orderDatabase()
    {
        return client.database(orderDb, true);
    }

    @Bean
    @DependsOn("createClient")
    public Database waiterDatabase()
    {
        return client.database(waitersDb, true);
    }


}
