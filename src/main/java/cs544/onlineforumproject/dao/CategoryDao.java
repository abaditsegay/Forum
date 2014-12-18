package cs544.onlineforumproject.dao;

import cs544.onlineforumproject.domain.Category;
import cs544.onlineforumproject.domain.Topic;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public class CategoryDao implements ICategoryDao {

    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCategory(Category category) {
        sessionFactory.getCurrentSession().saveOrUpdate(category);
    }

    @Override
    public void updateCategory(Category category) {
        sessionFactory.getCurrentSession().saveOrUpdate(category);
    }

    @Override
    public void deleteCategory(String categoryName) {
        Category category = (Category) sessionFactory.getCurrentSession().load(Category.class, categoryName);
        sessionFactory.getCurrentSession().delete(category);
    }

    @Override
    public Category getCategory(Integer id) {
        return (Category) sessionFactory.getCurrentSession().get(Category.class, id);

    }

    @Override
    public List<Category> getAllCategory() {
        return (List<Category>) sessionFactory.getCurrentSession().getNamedQuery("getAllCategory").list();
    }

    @Override
    public List<Topic> getAllTopics(Integer id) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("getAllTopics");
        query.setParameter("tid", id);
        return (List<Topic>)query.list();

    }
}
