package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import models.Task;
import models.User;

public class Application extends Controller {

    public static void index() {
        List<Task> tasks = Task.findAll();
        String name = "Sushant";
        render(tasks);
        List<User> users = User.findAll();
        render(users);
    }

    public static void createTask(String title){
        Task task = new Task(title).save();
        User user = new User(title);
        ArrayList<String> friends = new ArrayList<String>();
        friends.add("f1");
        friends.add("f2");
        user.setFriends(friends);
        user.save();

        task.setUser(user);

        renderJSON(task);

    }

    public static void changeStatus(Long id, boolean done){
        Task task = Task.findById(id);
        task.setIsDone(done);
        task.save();
        renderJSON(task);

    }

}