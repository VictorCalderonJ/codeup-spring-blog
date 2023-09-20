package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Post;
import edu.codeup.codeupspringblog.models.User;
import edu.codeup.codeupspringblog.repositories.PostRepository;
import edu.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostRepository postDao;
    private UserRepository userDao;

    public PostController(UserRepository userDao, PostRepository postDao1) {
        this.userDao = userDao;
        this.postDao = postDao1;
    }

    @GetMapping("")
    public String post(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable long id, Model vModel) {
        if(postDao.existsById(id)) {
            Post post = postDao.findById(id).get();
            vModel.addAttribute("blogpost", post);
            return "posts/show";
        }
        return "redirect:/posts";
    }

    @GetMapping("/create")
    public String create(){
        return "posts/create";
    }

    @PostMapping("/create")
    public String createPost(@RequestParam("title") String title, @RequestParam("body") String body){
        //Hard coded user
        User hardCodeUser = userDao.findById(2L).get();

        Post newPost = new Post(title, body, hardCodeUser);
        postDao.save(newPost);
        return "redirect:/posts";
    }




}
