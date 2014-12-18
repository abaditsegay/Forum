package cs544.onlineforumproject.controller;

import cs544.onlineforumproject.domain.Category;
import cs544.onlineforumproject.domain.Topic;
import cs544.onlineforumproject.service.ICategoryService;
import cs544.onlineforumproject.service.ITopicService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class CategoryController{

    private ICategoryService categoryService;
    //private ITopicService topicService;

    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

//    public void setTopicService(ITopicService topicService) {
//        this.topicService = topicService;
//    }
    
    @RequestMapping(value = "/")
    public String index() {
        return "home";
    }
    
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/getCategory", method = RequestMethod.POST)
    public String updateCategory() {
            categoryService.getAllCategory();
            return "redirect:/categories";
        }
    

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String getCategories(Model model) {

        model.addAttribute("categories", categoryService.getAllCategory());

        return "categoryList";
    }

    @RequestMapping(value = "/editCategory", method = RequestMethod.GET)
    public String editCategory(Integer selectedItem, Model model) {
        Category category = (Category) categoryService.getCategory(selectedItem);
        model.addAttribute("category", category);

        return "categoryEdit";
    }

    @RequestMapping(value = "/addTopic", method = RequestMethod.POST)
    public String addTopic(@RequestParam Integer selectedItem, String title,Category category) {
        Topic topic = new Topic(title);
        category = (Category) categoryService.getCategory(selectedItem);
        category.addTopic(topic);
        categoryService.addCategory(category);

        return "redirect:/categories";
    }

    @RequestMapping(value = "/addTopic", method = RequestMethod.GET)
    public String addTopic(Integer selectedItem) {
        ModelMap model = new ModelMap();
        model.addAttribute("categoryId", selectedItem);

        return "addTopic";
    }

   @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addCategory(@Valid Category category, BindingResult result,HttpSession session) {
        String view= "redirect:/addCategory";
        if (!result.hasErrors()) {
            session.setAttribute("cat", category);
            categoryService.addCategory(category);
        } else {
           view = "addCategory";
        }
        return view;

    }

    //we put a new category object in to the spring model, bind the errors with the object properties
    @RequestMapping(value = "/addCategory", method = RequestMethod.GET)
    public void addCategory(Model model) {
        model.addAttribute("category", new Category());
        //return "addCategory";//checking the implicit view name deducing from path

    }
}
