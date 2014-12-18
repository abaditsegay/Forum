package cs544.onlineforumproject.service;

import cs544.onlineforumproject.dao.IPostDao;
import cs544.onlineforumproject.domain.Post;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class PostService implements IPostService {

    private IPostDao postDao;

    public void setPostDao(IPostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addPost(Post post) {
        postDao.addPost(post);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updatePost(Post post) {
        postDao.updatePost(post);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deletePost(Date postedDate) {
        postDao.deletePost(postedDate);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Post getPost(Date postedDate) {
        return postDao.getPost(postedDate);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<Post> getAllPost() {
        return postDao.getAllPost();
    }

}
