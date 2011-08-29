package common.repositories;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	private static final String collectionName = "users";
	private Class clazz = User.class;
	@Autowired MongoTemplate mongoTemplate;
	public User findById(String id){
		return mongoTemplate.findOne(query(where(id).is(id)), clazz, collectionName);
	}
	public User findUser(String userName, String passWord){
		return mongoTemplate.findOne(query(where("userName").is(userName).and("password").is(passWord)), clazz, collectionName);
	}
	public void save(User user){
		mongoTemplate.save(user, collectionName);
	}
	public long count(){
		return mongoTemplate.getCollection(collectionName).count();
	}
	public User findSuperAdmin(String userName, String passWord){
		return mongoTemplate.findOne(query(where("userName").is(userName).and("password").is(passWord).and("isSuperAdmin").is(true)), clazz, collectionName);
	}
}
