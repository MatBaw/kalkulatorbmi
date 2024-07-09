package com.example.trzecia;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BMIController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("bmiForm", new BMIForm());
        return "bmiForm";
    }

    @PostMapping("/calculate")
    public String calculateBMI(@ModelAttribute BMIForm bmiForm, Model model) {
        double wzrost = bmiForm.getWzrost();
        double waga = bmiForm.getWaga();
        double bmi = waga / (wzrost * wzrost);
        String result;

        if (bmi < 18.5) {
            result = "Niedowaga";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            result = "Waga w normie";
        } else if (bmi >= 25 && bmi < 29.9) {
            result = "Nadwaga";
        } else {
            result = "Otyłość";
        }

        model.addAttribute("bmi", bmi);
        model.addAttribute("result", result);
        return "bmiResult";
    }
}
