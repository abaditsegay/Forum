package cs544.onlineforumproject.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@NamedQueries(
        {
            @NamedQuery(name = "getAllCategory", query = "from Category"),
            @NamedQuery(name = "getAllTopics", query = "from Topic t where t.category.id=:tid")
        }
)

@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Size(min = 20, max= 255)
    private String description;
    @Size(min = 2, max= 10)
    private String categoryName;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Topic> topics = new ArrayList();

    public Category() {
    }

    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
        topic.setCategory(this);
    }

    public void removeTopic(Topic topic) {
        topics.remove(topic);
        topic.setCategory(null);
    }

}
