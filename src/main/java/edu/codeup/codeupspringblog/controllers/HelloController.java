package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/lecture/hello")
public class HelloController {
//    @GetMapping("/hello/world")
//    @ResponseBody
//    public String helloWorld(){
//        return "Hello, world!";
//    }

    //Say hello someone specific.
    // for spaces within names %20.
//    @GetMapping("/hello/{name}")
//    @ResponseBody
    // PathVar is saying look at the path and getting string that is called name.
//    public String helloName(@PathVariable String name){
//        return String.format("Hello, %s!", name);
//    }


    //Write url have a path var that is going to have a name
    @GetMapping("/hello/{name}")
    // Model pass info back backend to front end
    public String sayHello(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        return "hello";
    }

    // this allows us to get the join form

    //each statements
    @GetMapping("/join")
    public String showJoinForm(Model model){
        List<Item> shoppingCart = new ArrayList<>();
        shoppingCart.add(new Item("Toy"));
        shoppingCart.add(new Item("paper"));
//        shoppingCart.add(new Item("rock"));
//        shoppingCart.add(new Item("hammer"));

        model.addAttribute("shoppingCart", shoppingCart);
        return "join";
    }

    //if statement
    // - remove two shopping cart

    //Create a post mapping
    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }



}