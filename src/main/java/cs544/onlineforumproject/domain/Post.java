
package cs544.onlineforumproject.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQuery(name = "getAllPost", query = "from Post")
@Entity
public class Post implements Serializable {
    @Id @GeneratedValue
    private int id;
    private String postContent;
    @Temporal(TemporalType.DATE)
    private Date postedDate;
    @ManyToOne
    @JoinColumn(name="topicId")
    private Topic topic;
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    public Post() {
    }

    public Post(String postContent) {
        this.postContent = postContent;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
