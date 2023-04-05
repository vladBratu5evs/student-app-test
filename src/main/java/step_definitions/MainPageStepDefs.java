package step_definitions;

import io.cucumber.java.en.Given;
import page_objects.AllStudentsPage;

public class MainPageStepDefs {

    AllStudentsPage allStudentsPage = new AllStudentsPage();
    @Given("user clicks on add student button")
    public void userClicksOnAddStudentButton() {
allStudentsPage.waitAndClickOnAddStudentButton();
    }
}
