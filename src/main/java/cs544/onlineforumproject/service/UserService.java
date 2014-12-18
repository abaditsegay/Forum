package cs544.onlineforumproject.service;

import cs544.onlineforumproject.dao.IUserDao;
import cs544.onlineforumproject.domain.User;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UserService implements IUserService {

    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteUser(String userName) {
        userDao.deleteUser(userName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public User getUser(String userName) {
        return userDao.getUser(userName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

}
