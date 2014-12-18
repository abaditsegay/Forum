package cs544.onlineforumproject.dao;

import cs544.onlineforumproject.domain.Topic;
import java.util.List;

public interface ITopicDao {

    public void addTopic(Topic Topic);

    public void updateTopic(Topic Topic);

    public void deleteTopic(String title);

    public Topic getTopic(int id);
    
     public List<Topic> getAllTopic();
}
