package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {



    @GetMapping("/hello/world")
    @ResponseBody
    public String helloWorld(){
        return "Hello, world!";
    }

    //Say hello someone specific.
    // for spaces within names %20.
    @GetMapping("/hello/{name}")
    @ResponseBody
    // PathVar is saying look at the path and getting string that is called name.
    public String helloName(@PathVariable String name){
        return String.format("Hello, %s!", name);
    }

}