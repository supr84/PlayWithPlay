package common.repositories;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import models.Tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TenantRepository {
	@Autowired private MongoTemplate mongoTemplate;
	public Tenant  findById(String id){
		return mongoTemplate.findOne(query(where(id).is(id)), Tenant.class);
	}
}
