package com.example.Project2.demo.project2;
/*
        //import org.junit.Before;
        //import org.junit.Test;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
        import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

        import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
public class SolutionsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Mock data for testing
    private static final String sampleSymptom = "Sunburn";
    private static final String sampleAdvice = "Apply aloe vera or moisturizer.\nStay out of the sun until healed.";

    @Test
    public void testGetAdviceForSymptom() throws Exception {
        // Test retrieving advice for a known symptom
        mockMvc.perform(MockMvcRequestBuilders.get("/solutions" + sampleSymptom))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(sampleAdvice)));
    }

    @Test
    public void testGetAdviceForUnknownSymptom() throws Exception {
        // Test retrieving advice for an unknown symptom
        mockMvc.perform(MockMvcRequestBuilders.get("/solutions/UnknownSymptom"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("No advice found for the provided symptom.")));
    }

    @Test
    public void testPopulateDatabaseWithSampleData() throws Exception {
        // Test the population of the database with sample data
        mockMvc.perform(MockMvcRequestBuilders.get("/solutions/populate"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Solutions Added for the provided symptoms.")));
    }
}
//package com.example.Project2.demo.project2;

//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
public class SolutionsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Mock data for testing
    private static final String sampleSymptom = "Sunburn";
    private static final String sampleAdvice = "Apply aloe vera or moisturizer.\nStay out of the sun until healed.";

    @Test
    public void testGetAdviceForSymptom() throws Exception {
        // Test retrieving advice for a known symptom
        mockMvc.perform(MockMvcRequestBuilders.get("/solutions" + sampleSymptom))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(sampleAdvice)));
    }

    @Test
    public void testGetAdviceForUnknownSymptom() throws Exception {
        // Test retrieving advice for an unknown symptom
        mockMvc.perform(MockMvcRequestBuilders.get("/solutions/UnknownSymptom"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("No advice found for the provided symptom.")));
    }

    @Test
    public void testPopulateDatabaseWithSampleData() throws Exception {
        // Test the population of the database with sample data
        mockMvc.perform(MockMvcRequestBuilders.get("/solutions/populate"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Solutions Added for the provided symptoms.")));
    }
}*/
import com.example.Project2.demo.project2.Solutions;
import com.example.Project2.demo.project2.SolutionsController;
import com.example.Project2.demo.project2.SolutionsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SolutionsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SolutionsRepository solutionsRepository;

    @Test
    public void testGetAdviceForSymptom() throws Exception {
        // Arrange
        String symptom = "Sunburn";
        Solutions mockSolution = new Solutions("Sunburn", "Apply aloe vera");

        Mockito.when(solutionsRepository.findBySymptom(symptom)).thenReturn(mockSolution);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/solutions/populate"))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.post("/solutions/advice")
                        .param("symptom", symptom))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Advice: Apply aloe vera"));
    }
}


