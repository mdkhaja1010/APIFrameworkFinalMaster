package StepDefinitions;

import Pages.UserLoginPojo;
import Utilities.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class UserLoginAPISteps {
    ScenarioUtils scenarioUtils;
    public UserLoginAPISteps(ScenarioUtils scenarioUtils){
        this.scenarioUtils=scenarioUtils;
    }


    @When("user make a post call request with username as {string} and password as {string}")
    public void user_make_a_post_call_request_with_username_as_and_password_as(String username, String password) throws InterruptedException {
        this.scenarioUtils.getScenarioContext().response= ReusableMethodUtils.postMethodforUrlencoded(
                this.scenarioUtils.getScenarioContext().strBaseURL,this.scenarioUtils.getScenarioContext().strEndPoint,
                this.scenarioUtils.getScenarioContext().headers,username,password);
        Thread.sleep(5000);
    }
    @And("Validate the user response required values")
    public void validate_the_user_response_required_values(DataTable dataTable) {
        List<List<String>> data=dataTable.asLists();
        String expectedID=data.get(0).get(0);
        String expectedName=data.get(0).get(1);
        String expectedEmail=data.get(0).get(2);

        UserLoginPojo userloginSteps= ResponseUtils.getResponse(this.scenarioUtils.getScenarioContext().response, UserLoginPojo.class);
        Assert.assertNotNull("the message fiedl should not null",userloginSteps.getMessage());
        Assert.assertNotNull("status code should not be null", userloginSteps.getStatus());
        Assert.assertNotNull("the success message not be null", userloginSteps.isSuccess());
        UserLoginPojo.UserData userData= userloginSteps.getUserData();

        Assert.assertNotNull("The 'data' field should not be null", userData);
        Assert.assertEquals("The 'id' does not match", expectedID, userData.getId());
        Assert.assertEquals("The 'name' does not match", expectedName, userData.getName());
        Assert.assertEquals("The 'email' does not match", expectedEmail, userData.getEmail());
//        Assert.assertNotNull(userloginSteps.isSuccess());
//        Assert.assertNotNull(userloginSteps.isSuccess());
//        Assert.assertNotNull(userloginSteps.isSuccess());
//        Assert.assertNotNull(userloginSteps.isSuccess());
    }

    @And("Validate the {string} schema")
    public void validate_the_schema(String strSchema) {
        ValidationUtils.validateSchema(this.scenarioUtils.getScenarioContext().response,strSchema);
    }
    @And("Validate the {string} response actual")
    public void validate_the_response_actual(String strResponse) {
     String strExpected=null;
     switch(strResponse) {
         case "UserLoginResponse":
          strExpected= ReadJSONUtils.readResponseJSON(strResponse).toString();
          break;
     }
     Assert.assertEquals(this.scenarioUtils.getScenarioContext().response.getBody().asString(),strExpected);
    }
}
