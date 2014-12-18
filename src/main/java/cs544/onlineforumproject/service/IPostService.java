package cs544.onlineforumproject.service;

import cs544.onlineforumproject.domain.Post;
import java.util.Date;
import java.util.List;

public interface IPostService {

    public void addPost(Post post);

    public void updatePost(Post post);

    public void deletePost(Date postedDate);

    public Post getPost(Date postedDate);
    
    public List<Post> getAllPost();

}
