
package cs544.onlineforumproject.service;

import cs544.onlineforumproject.dao.ICategoryDao;
import cs544.onlineforumproject.domain.Category;
import cs544.onlineforumproject.domain.Topic;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class CategoryService implements ICategoryService{
    private ICategoryDao categoryDao;

    public void setCategoryDao(ICategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
   
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addCategory(Category category) {
        
        categoryDao.addCategory(category);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteCategory(String categoryName) {
        categoryDao.deleteCategory(categoryName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Category getCategory(Integer id) {
        return categoryDao.getCategory(id);
    }

    @Override
   @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Category> getAllCategory() {
       return categoryDao.getAllCategory();
    }

    @Override
     @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Topic> getAllTopics(Integer id) {
        System.out.println("Service"+id);
        return categoryDao.getAllTopics(id);
    }
    
}
