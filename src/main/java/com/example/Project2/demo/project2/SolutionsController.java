package com.example.Project2.demo.project2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solution")
public class SolutionsController {
    private final SolutionsRepository solutionsRepository;
    @Autowired
    public SolutionsController(SolutionsRepository solutionsRepository) {
        this.solutionsRepository = solutionsRepository;
    }




    @GetMapping("/project2/{symptom}")
    public String getAdviceForSymptom(@PathVariable String symptom) {
        long count = 0;
        count = solutionsRepository.count();

       // String symptom_str;
        //symptom_str = symptom .toString();
        Solutions solutions = solutionsRepository.findBySymptom(symptom);

        if (solutions != null) {
            return "\nAdvice: " + solutions.getAdvice();
        } else {
            return "No advice found for the provided symptom." + count;
        }
    }
    @GetMapping("/populate")
    public String populateDatabaseWithSampleData() {
// Sample data to populate the database
        Solutions solutions1 = new Solutions();
        solutions1.setSymptom ("Sunburn");
        solutions1.setAdvice("Apply aloe vera or moisturizer.\n" +
                        "Stay out of the sun until healed.\n" + 
                        "Use sunscreen in the future.");
        solutionsRepository.save(solutions1);
        Solutions solutions2 = new Solutions();
        solutions2.setSymptom ("Insomnia");
        solutions2.setAdvice("Establish a bedtime routine.\n" + 
                "Avoid caffeine and electronics before bedtime.\n" + 
                "Consult a healthcare provider for persistent sleep issues.");
        solutionsRepository.save(solutions2);
        Solutions solutions3 = new Solutions();
        solutions3.setSymptom ("Stomach Upset");
        solutions3.setAdvice("Eat smaller meals.\n" +
                "Avoid trigger foods (e.g., spicy or fatty foods).\n" +
                "Over-the-counter antacids.");
        solutionsRepository.save(solutions3);
        return "Solutions Added the provided symptoms.";
    }


}