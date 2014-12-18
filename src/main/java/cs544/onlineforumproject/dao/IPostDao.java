package cs544.onlineforumproject.dao;

import cs544.onlineforumproject.domain.Post;
import java.util.Date;
import java.util.List;

public interface IPostDao {

    public void addPost(Post post);

    public void updatePost(Post post);

    public void deletePost(Date postedDate);

    public Post getPost(Date postedDate);

    public List<Post> getAllPost();

}
