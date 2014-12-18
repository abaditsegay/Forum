
package cs544.onlineforumproject.dao;

import cs544.onlineforumproject.domain.Topic;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public class TopicDao implements ITopicDao {
    
     private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTopic(Topic Topic) {
        sessionFactory.getCurrentSession().saveOrUpdate(Topic);
    }

    @Override
    public void updateTopic(Topic Topic) {
        sessionFactory.getCurrentSession().saveOrUpdate(Topic);
    }

    @Override
    public void deleteTopic(String title) {
        Topic topic = (Topic)sessionFactory.getCurrentSession().load(Topic.class, title);
        sessionFactory.getCurrentSession().delete(topic);
    }

    @Override
    public Topic getTopic(int id) {
        return (Topic)sessionFactory.getCurrentSession().get(Topic.class, id);
    }

    @Override
    public List<Topic> getAllTopic() {
        return (List<Topic>)sessionFactory.getCurrentSession().getNamedQuery("getAllTopic").list();
    }
    
}
