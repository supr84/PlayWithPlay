package common.config;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoException;

@Configuration
public class MongoConfig {
	private static Mongo mongo;
	private static MongoTemplate mongoTemplate;
	private String host = "localhost";
	private String dbName = "salesforce";
	private int port = 27017;
	
	@Bean public Mongo mongo() throws UnknownHostException, MongoException{
		if(null == mongo){
			mongo = new Mongo(host, port);
		}
		return mongo;
	}
	@Bean public MongoTemplate mongoTemplate() throws UnknownHostException, MongoException{
		if(null == mongoTemplate){
			mongoTemplate = new MongoTemplate(mongo(), dbName);
		}
		return mongoTemplate();
	}
}
