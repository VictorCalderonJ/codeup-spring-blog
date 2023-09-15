package edu.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addition(@PathVariable Integer num1, @PathVariable Integer num2 ){
        int add = (num1 + num2);
        return String.format("%s + %s is equal to %s", num1, num2, add);
    }
    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtract(@PathVariable Integer num1, @PathVariable Integer num2 ){
        int sub = (num2 - num1);
        return String.format("%s - %s is equal to %s", num1, num2, sub);
    }
    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable Integer num1, @PathVariable Integer num2 ){
        int multi = (num1 * num2);
        return String.format("%s * %s is equal to %s", num1, num2, multi);
    }
    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable double num1, @PathVariable double num2 ){
        double div = (num1 / num2);
        return String.format("%s / %s is equal to %s", num1, num2, div);
    }


}
