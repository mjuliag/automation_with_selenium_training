package com.company.cucumberdemo.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

//This is the annotation of junit that tells junit which test should be run using the Cucumber class
@RunWith(Cucumber.class)
//It tells with what options we need to run. We need to provide the feature file.
@CucumberOptions(
        //the name of the folder with the feature file
        features = "C:\\Users\\JuliaGirona\\IdeaProjects\\SeleniumWebDriverSetupTest\\src\\com\\company" +
                "\\cucumberdemo\\feature",
        glue = {"com.company.cucumberdemo.stepdefinition"}
)
public class TestRun {
}
