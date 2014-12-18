
package cs544.onlineforumproject.App;

import cs544.onlineforumproject.domain.Category;
import cs544.onlineforumproject.service.CategoryService;
import cs544.onlineforumproject.service.ICategoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ForumApp {
   
    
    public static void main(String[] args) {
        
     ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        ICategoryService catService=context.getBean("categoryService",ICategoryService.class);
   
        Category cat=new Category("EA","EA is awesome!");
        catService.addCategory(cat);
    
}
}
