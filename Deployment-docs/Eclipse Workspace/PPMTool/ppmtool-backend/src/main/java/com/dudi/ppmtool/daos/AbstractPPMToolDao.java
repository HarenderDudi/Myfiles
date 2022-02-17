package com.dudi.ppmtool.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

@Configuration
public abstract class AbstractPPMToolDao {

	protected final String PPM_DATABASE;

	protected MongoDatabase db;

	protected MongoClient mongoClient;

	@Value("${spring.mongodb.uri}")
	private String connectionString;

	protected AbstractPPMToolDao(MongoClient mongoClient, String databaseName) {
		this.mongoClient = mongoClient;
		PPM_DATABASE = databaseName;
		this.db = this.mongoClient.getDatabase(PPM_DATABASE);
	}
	
//	public Map<String, Object> getConfiguration() {
//        ConnectionString connString = new ConnectionString(connectionString);
//        Bson command = new Document("connectionStatus", 1);
//        Document connectionStatus = this.mongoClient.getDatabase(PPM_DATABASE).runCommand(command);
//
//        List authUserRoles =
//                ((Document) connectionStatus.get("authInfo")).get("authenticatedUserRoles", List.class);
//
//        Map<String, Object> configuration = new HashMap<>();
//
//        if (!authUserRoles.isEmpty()) {
//            configuration.put("role", ((Document) authUserRoles.get(0)).getString(
//                    "role"));
//            configuration.put("pool_size", connString.getMaxConnectionPoolSize());
//            configuration.put(
//                    "wtimeout",
//                    this.mongoClient
//                            .getDatabase(PPM_DATABASE)
//                            .getWriteConcern()
//                            .getWTimeout(TimeUnit.MILLISECONDS));
//        }
//        return configuration;
//    }

}
