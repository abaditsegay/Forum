package cs544.onlineforumproject.controller;

import cs544.onlineforumproject.domain.Post;
import cs544.onlineforumproject.domain.Topic;
import cs544.onlineforumproject.domain.User;
import cs544.onlineforumproject.service.ICategoryService;
import cs544.onlineforumproject.service.ITopicService;
import cs544.onlineforumproject.service.IUserService;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TopicController {

    private ICategoryService categoryService;
    private ITopicService topicService;
    private IUserService userService;

    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setTopicService(ITopicService topicService) {
        this.topicService = topicService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/updateTopic", method = RequestMethod.POST)
    public String updateTopic(String title) {
        Topic topic = new Topic();
        topic.setTitle(title);

        topicService.updateTopic(topic);

        return "redirect:/topics";
    }

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public String getTopic(Model model, Integer selectedItem) {
        // System.out.println("Controller"+id);
        model.addAttribute("topics", categoryService.getAllTopics(selectedItem));

        return "topicList";
    }

    @RequestMapping(value = "/editTopic", method = RequestMethod.GET)
    public String editTopic(Integer selectedItem, Model model) {
        Topic topic = (Topic) topicService.getTopic(selectedItem);
        model.addAttribute("topic", topic);

        return "topicEdit";
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public String addTopic(@RequestParam Integer selectedItem, String comment, HttpSession session) {
        Post post = new Post(comment);
        post.setPostedDate(new Date());

       User user=(User)session.getAttribute("user");

        Topic topic = (Topic) topicService.getTopic(selectedItem);
        session.setAttribute("topicId", selectedItem);
        topic.addPost(post, user);
        topicService.addTopic(topic);

        return "redirect:/topic";
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.GET)
    public String addTopic(HttpSession session, Integer selectedItem) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName(); //get logged in username  
         User user = userService.getUser(email);
        if (email != null) {
            //session.setAttribute("email", email);
            session.setAttribute("user", user);
            return "addPost";
        } else {
            return null;
        }

    }

    @RequestMapping(value = "/topic", method = RequestMethod.GET)
    public String getTopicAndPosts(Model model, HttpSession session) {
        model.addAttribute("topic", topicService.getTopic((Integer) session.getAttribute("topicId")));      
        return "topicAndPosts";
    }
}
