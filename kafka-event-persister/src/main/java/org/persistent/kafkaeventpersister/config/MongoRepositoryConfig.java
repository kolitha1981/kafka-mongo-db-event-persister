package org.persistent.kafkaeventpersister.config;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "org.persistent.kafkaeventpersister.repository")
public class MongoRepositoryConfig extends AbstractMongoClientConfiguration {

	@Value("${org.persistent.database.name}")
	private String databaseName;
	@Value("${org.persistent.database.server.name}")
	private String server;
	@Value("${org.persistent.database.server.port}")
	private String serverPort;

	@Override
	protected String getDatabaseName() {
		return databaseName;
	}

	@Override
    public MongoClient mongoClient() {
    	return MongoClients.create(MongoClientSettings.builder()
				.applyConnectionString(new ConnectionString(
						MessageFormat.format("mongodb://{0}:{1}/{2}", 
								new Object[] { server, serverPort, databaseName })))
				.build());
    }

}
