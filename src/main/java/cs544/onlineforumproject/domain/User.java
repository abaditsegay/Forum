
package cs544.onlineforumproject.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries(
        {
            @NamedQuery(name = "getAllUser", query = "from User"),
            @NamedQuery(name = "getUser", query = "from User where userName=:username")
        }
)
@Entity
public class User implements Serializable{
    @Id @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String userRole;
    
    @OneToMany(mappedBy = "user")
    private List<Post> posts=new ArrayList();

    public User() {
    }
    
    public void setThisUser(User user){
        this.id=user.id;
        this.firstName=user.firstName;
        this.lastName=user.lastName;
        this.username=user.username;
        this.password=user.password;
        this.userRole=user.userRole;
    }

    public User(String firstName, String lastName, String username, String password, String userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.userRole=userRole;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    
    
    
}
