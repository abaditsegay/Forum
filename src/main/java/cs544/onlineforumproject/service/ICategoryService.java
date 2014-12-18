
package cs544.onlineforumproject.service;

import cs544.onlineforumproject.domain.Category;
import cs544.onlineforumproject.domain.Topic;
import java.util.List;


public interface ICategoryService {
    public void addCategory(Category category);
    public void updateCategory(Category category);
    public void deleteCategory(String categoryName);
    public Category getCategory(Integer id);
    public List<Category> getAllCategory();
    public List<Topic> getAllTopics(Integer id);
}
