package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
@RequestMapping("roll-dice")
public class RollDiceController {

    @GetMapping("")
    public String welcome() {
        return "rolldice";
    }

//    @GetMapping("/{num}")
//    public String rollDice(@PathVariable Integer num) {
//        return "rolldice";
//    }

    @GetMapping("/{num}")
    public String rollDice(@PathVariable Integer num, Model model) {
        if (num >= 1 && num <= 6) {
            Random random = new Random();
            int diceResult = random.nextInt(6) + 1;

            boolean isCorrectGuess = (diceResult == num);

            model.addAttribute("diceResult", diceResult);
            model.addAttribute("isCorrectGuess", isCorrectGuess);
        }

        return "rolldice";
    }

}
