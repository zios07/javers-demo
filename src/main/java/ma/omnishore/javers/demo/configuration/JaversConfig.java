/**
 * 
 */
package ma.omnishore.javers.demo.configuration;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.repository.mongo.MongoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import ma.omnishore.javers.demo.domain.Brand;
import ma.omnishore.javers.demo.domain.Car;
import ma.omnishore.javers.demo.domain.Option;
import ma.omnishore.javers.demo.domain.Person;

/**
 * @author Zkaoukab
 *
 */

@Configuration
public class JaversConfig {

	@Value("${spring.data.mongodb.database}")
	private String dbName;
	@Value("${spring.data.mongodb.host}")
	private String host;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Bean
	public Javers javers() {
		MongoDatabase mongoDb = mongoClient().getDatabase(dbName);

		MongoRepository mongoRepo = new MongoRepository(mongoDb);
		Javers javers = JaversBuilder.javers()
				.registerEntity(Person.class)
				.registerValueObjects(Car.class, Brand.class, Option.class)
				.registerJaversRepository(mongoRepo).build();
		this.logger.info("JaVers mapping for person class : {}", javers.getTypeMapping(Person.class).prettyPrint());
		this.logger.info("JaVers mapping for car class : {}", javers.getTypeMapping(Car.class).prettyPrint());
		this.logger.info("JaVers mapping for brand class : {}", javers.getTypeMapping(Brand.class).prettyPrint());
		return javers;
	}

	@Bean
	public MongoClient mongoClient() {
		return new MongoClient(host);
	}
}
