package cs544.onlineforumproject.dao;

import cs544.onlineforumproject.domain.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public class UserDao implements IUserDao {

    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
        
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void deleteUser(String userName) {
        User user = (User)sessionFactory.getCurrentSession().load(User.class, userName);
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User getUser(String userName) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("getUser");
        query.setParameter("username", userName);

        return (User) query.uniqueResult();
    }

    @Override
    public List<User> getAllUser() {
       return (List<User>) sessionFactory.getCurrentSession().getNamedQuery("getAllUser").list();
    }

}
