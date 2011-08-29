package controllers;

import models.User;
import common.repositories.UserRepository;

import play.data.validation.Password;
import play.data.validation.Required;
import play.modules.spring.Spring;
import play.mvc.Controller;

public class Admin extends Controller{
	private static UserRepository userRepository = Spring.getBeanOfType(UserRepository.class);
	public static void index() {
        render();
    }
	public static void signIn(@Required String userName, @Required @Password String password) {        
        if(validation.hasErrors()) {
            flash.error("Please provide a valid userName and password…");
            index();
        }
//        User user = new User("admin", "admin");
//        user.setSuperAdmin(true);
        User user = userRepository.findUser(userName, password);
//        userRepository.save(user);
        if(user==null){
        	flash.error("Invalid credentials.");
        	index();
        }
        // Dispatch to the demonstration        
        Application.index();
    }
}
