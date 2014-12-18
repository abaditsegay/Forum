
package cs544.onlineforumproject.dao;

import cs544.onlineforumproject.domain.Post;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public class PostDao implements IPostDao {
    private SessionFactory sessionfactory;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionfactory(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }
  
    @Override
    public void addPost(Post post) {
        sessionfactory.getCurrentSession().persist(post);
    }

    @Override
    public void updatePost(Post post) {
        sessionfactory.getCurrentSession().saveOrUpdate(post);
    }

    @Override
    public void deletePost(Date postedDate) {
        Post post = (Post)sessionfactory.getCurrentSession().load(Post.class, postedDate);
        sessionfactory.getCurrentSession().delete(post);
            
    }

    @Override
    public Post getPost(Date postedDate) {
        return (Post)sessionfactory.getCurrentSession().get(Post.class, postedDate);
    }

    @Override
    public List<Post> getAllPost() {
        return (List<Post>)sessionfactory.getCurrentSession().getNamedQuery("getAllPost").list();
    }
    
}
