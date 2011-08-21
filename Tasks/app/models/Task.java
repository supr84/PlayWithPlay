/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import play.data.validation.Required;
import play.db.jpa.Model;

/**
 *
 * @author sush
 */
@javax.persistence.Entity
public class Task extends Model{
    @Required
    private String title;
    private boolean  isDone;
    private User user;

    public Task(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public boolean isIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    

}
