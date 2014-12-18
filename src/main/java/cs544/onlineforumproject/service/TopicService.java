
package cs544.onlineforumproject.service;

import cs544.onlineforumproject.dao.ITopicDao;
import cs544.onlineforumproject.domain.Topic;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class TopicService implements ITopicService {
    
    private ITopicDao topicDao;

    public void setTopicDao(ITopicDao topicDao) {
        this.topicDao = topicDao;
    }
  
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addTopic(Topic Topic) {
        topicDao.addTopic(Topic);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateTopic(Topic Topic) {
        topicDao.updateTopic(Topic);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteTopic(String title) {
        topicDao.deleteTopic(title);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Topic getTopic(int id) {
        return topicDao.getTopic(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<Topic> getAllTopic() {
        return topicDao.getAllTopic();
    }
    
}
