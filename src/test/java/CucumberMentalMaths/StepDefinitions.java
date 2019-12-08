package CucumberMentalMaths;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.List;

import static CucumberMentalMaths.BeforeTest.chromeDriver;
import static CucumberMentalMaths.BeforeTest.prop;

public class StepDefinitions {

    String storeActualQuestion;

    @Given("^I log in as \"([^\"]*)\"$")
    public void iLogInAs(String expectedName) {
        WebElement loginBox = chromeDriver.findElement(By.name(prop.getProperty("loginInput")));
        loginBox.sendKeys(expectedName);
        WebElement loginButton = chromeDriver.findElement(By.cssSelector(prop.getProperty("loginBtn")));
        loginButton.click();
        WebElement actualName = chromeDriver.findElement(By.cssSelector(prop.getProperty("nameDisplayed")));
        Assert.assertTrue("The user name displayed is not as expected ", actualName.getText().contains(expectedName));
    }

    @Then("^I start the test$")
    public void iStartTheTest() {
        WebElement startButton = chromeDriver.findElement(By.cssSelector(prop.getProperty("startBtn")));
        startButton.click();
        WebElement enterButton = chromeDriver.findElement(By.cssSelector(prop.getProperty("enterBtn")));
        Assert.assertTrue("The enter button on the first question screen is not appearing ", enterButton.isDisplayed());
    }

    @Given("^i am on the MM website and at a question$")
    public void i_am_on_the_MM_website_and_at_a_question()  {
        WebElement enterButton = chromeDriver.findElement(By.cssSelector(prop.getProperty("enterBtn")));
        Assert.assertTrue("The enter button on the first question screen is not appearing ", enterButton.isDisplayed());
    }

    @When("^I answer the question \"([^\"]*)\"$")
    public void iAnswerTheQuestion(String expectedAnswer) {
        WebElement actualQuestion = chromeDriver.findElement(By.cssSelector(prop.getProperty("questionDisplay")));
        storeActualQuestion = actualQuestion.getText();
        WebElement answerInput = chromeDriver.findElement(By.cssSelector(prop.getProperty("answerInput")));
        if (expectedAnswer.equalsIgnoreCase("correctly")) {
            int answer = MentalMathsTool.addingTool(actualQuestion.getText());
            answerInput.sendKeys(String.valueOf(answer));
        }
        else {
            answerInput.sendKeys(String.valueOf(100));
        }
        WebElement enterButton = chromeDriver.findElement(By.cssSelector(prop.getProperty("enterBtn")));
        enterButton.click();
    }

    @Then("^I get given a new question$")
    public void i_get_given_a_new_question() {
        WebElement actualQuestion2 = chromeDriver.findElement(By.cssSelector(prop.getProperty("questionDisplay")));
        Assert.assertEquals("",storeActualQuestion.equals(actualQuestion2.getText()));

    }

    @Then("^I get given the same question$")
    public void i_get_given_the_same_question()  {
        System.out.println("5");

    }


    @Then("^I get given \"([^\"]*)\" question$")
    public void iGetGivenQuestion(String questionState) throws Throwable {
        WebElement actualQuestion = chromeDriver.findElement(By.cssSelector(prop.getProperty("questionDisplay")));
        if (questionState.equalsIgnoreCase("a new")) {
            Assert.assertFalse("", storeActualQuestion.equals(actualQuestion.getText()));
        }
        else            {

            Assert.assertTrue("", storeActualQuestion.equals(actualQuestion.getText()));
            }
    }

    @Then("^I do an api get Request$")
    public void iDoAnApiGetRequest() {
        chromeDriver.get("http://127.0.0.1:5000/login");
        List<WebElement> blah = chromeDriver.findElements(By.name("tr"));
        List<WebElement> bluh = chromeDriver.findElements(By.name("nm"));
        Assert.assertTrue("wrong number of elements", blah.size() == 0);
        Assert.assertTrue("wrong number of elements", bluh.size() == 1);



    }


}
