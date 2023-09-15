package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String post() {
        return "posts index page";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String post(@PathVariable Integer id) {
        return String.format("Hello, %s!", id);
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreate(){
        return "view the form for creating a post";
    }




}
