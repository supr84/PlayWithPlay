package common.repositories;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	@Autowired MongoTemplate mongoTemplate;
	public User findById(String id){
		return mongoTemplate.findOne(query(where(id).is(id)), User.class);
	}
}
