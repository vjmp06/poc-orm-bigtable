package com.example.demo;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.repository.CadastroClienteRepository;
import com.google.cloud.bigtable.hbase.BigtableConfiguration;

@SpringBootApplication
public class PocOrmBigtableApplication {

	@Value("${bigtable.projectid}")
    private String projectID;

    @Value("${bigtable.instanceid}")
    private String instanceID;
    
    @Autowired
    private static Connection connection;
    
	@Bean
	public Connection getconnection() {
		return BigtableConfiguration.connect(projectID, instanceID);
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(PocOrmBigtableApplication.class, args);
		cadastroClienteRepository.get("#");
	}
	
	private static CadastroClienteRepository cadastroClienteRepository = new CadastroClienteRepository(connection);
	

}
