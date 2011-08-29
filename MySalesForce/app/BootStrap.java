import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.Mongo;

import common.repositories.UserRepository;

import models.User;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;



public class BootStrap extends Job{
	@Autowired
	private UserRepository userRepository;
	public void doJob() {
        if(userRepository.count() == 0){
        	User user = new User("admin", "admin");
        	userRepository.save(user);
        }
    }
}
