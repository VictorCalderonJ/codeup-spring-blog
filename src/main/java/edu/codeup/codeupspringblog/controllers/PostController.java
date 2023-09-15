package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("")
    @ResponseBody
    public String post() {
        return "posts index page";
    }
    @GetMapping("/{id}")
    @ResponseBody
    public String view(@PathVariable long id) {
        return String.format("Hello, %s!", id);
    }
    @GetMapping("/create")
    @ResponseBody
    public String create(){
        return "view the form for creating a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPost(){
        return "create a new post";
    }




}
