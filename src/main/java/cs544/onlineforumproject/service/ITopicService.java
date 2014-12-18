package cs544.onlineforumproject.service;


import cs544.onlineforumproject.domain.Topic;
import java.util.List;

public interface ITopicService {

    public void addTopic(Topic Topic);

    public void updateTopic(Topic Topic);

    public void deleteTopic(String title);

    public Topic getTopic(int id);
    
    public List<Topic> getAllTopic();

}
