package cs544.onlineforumproject.service;

import cs544.onlineforumproject.domain.User;
import java.util.List;

public interface IUserService {

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(String userName);

    public User getUser(String userName);

    public List<User> getAllUser();

}
