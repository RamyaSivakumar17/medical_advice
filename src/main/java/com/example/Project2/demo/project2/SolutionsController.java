package com.example.Project2.demo.project2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/solution")
//public class SolutionsController {
//    private final SolutionsRepository solutionsRepository;
//    @Autowired
//    public SolutionsController(SolutionsRepository solutionsRepository) {
//        this.solutionsRepository = solutionsRepository;
//    }




    @RestController
    @RequestMapping("/solutions")
    public class SolutionsController {
        @Autowired
        private SolutionsRepository solutionsRepository;

        @GetMapping
        public String showForm() {
            return "symptom-form"; // Return the HTML form for entering symptoms
        }

        @PostMapping("/advice")
        public String getAdviceForSymptom(@RequestParam String symptom) {
            Solutions solutions = solutionsRepository.findBySymptom(symptom);

            if (solutions != null) {
                return "Advice: " + solutions.getAdvice();
            } else {
                return "No advice found for the provided symptom." + symptom;
            }
        }



    @GetMapping("/populate")
    public String populateDatabaseWithSampleData() {
// Sample data to populate the database
        Solutions solutions1 = new Solutions();
        solutions1.setSymptom ("Sunburn");
        solutions1.setAdvice("Apply aloe vera or moisturizer." +
                        "\nStay out of the sun until healed." +
                        "\nUse sunscreen in the future.");
        solutionsRepository.save(solutions1);
        Solutions solutions2 = new Solutions();
        solutions2.setSymptom ("Insomnia");
        solutions2.setAdvice("Establish a bedtime routine." +
                "\nAvoid caffeine and electronics before bedtime." +
                "\nConsult a healthcare provider for persistent sleep issues.");
        solutionsRepository.save(solutions2);
        Solutions solutions3 = new Solutions();
        solutions3.setSymptom ("Stomach Upset");
        solutions3.setAdvice("Eat smaller meals." +
                "\nAvoid trigger foods (e.g., spicy or fatty foods)." +
                "\nOver-the-counter antacids.");
        solutionsRepository.save(solutions3);
        return "Solutions Added the provided symptoms.";
    }


}
