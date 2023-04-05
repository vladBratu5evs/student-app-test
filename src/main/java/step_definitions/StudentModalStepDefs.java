package step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page_objects.AddStudentPage;

public class StudentModalStepDefs {
private final AddStudentPage addStudentPage = new AddStudentPage();
private final Faker faker = new Faker();
    @Given("user enters name in name field")
    public void userEntersNameInNameField() {
        addStudentPage.waitAndSetValueForNameField(faker.name().firstName());
    }
    @Given("user enters email in email field")
    public void userEntersEmailInEmailField() {
        addStudentPage.waitAndSetValueForEmailField(faker.internet().emailAddress());
    }
    @Given("user enters {string} in gender field")
    public void userEntersGenderField(String gender) {
        addStudentPage.waitAndSetGender(gender);
    }
    @When("user clicks on submit button")
    public void userClicksOnSubmitButton() {
        addStudentPage.clickOnSubmitButton();
           }
}
