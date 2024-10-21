package StepDefinitions;

import DriverManagers.ConfigFileManager;
import Pages.UserLoginPojo;
import Utilities.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class PostAPISteps {
    ScenarioUtils scenarioUtils;
    public PostAPISteps(ScenarioUtils scenarioUtils){
        this.scenarioUtils=scenarioUtils;
    }
    @Given("User access to the {string} endpoint")
    public void user_access_to_the_endpoint(String strEndPointType) {
        String strBaseURL,strEndPoint;
        switch(strEndPointType){
            case "PostRequestEndPoint":
                strBaseURL= ConfigFileManager.getInstance().getReadConfig().getBaseURL();
                strEndPoint=ConfigFileManager.getInstance().getReadConfig().getPostRequestEndPoint();
                this.scenarioUtils.getScenarioContext().strBaseURL=strBaseURL;
                this.scenarioUtils.getScenarioContext().strEndPoint=strEndPoint;
                break;
            default:
                throw new IllegalArgumentException("Unsupported end point "+strEndPointType);

        }

    }

    @And("Build the {string} request header and json")
    public void build_the_request_header_and_json(String strEndPoint) {
        switch (strEndPoint) {
            case "PostRequestEndPoint":
                this.scenarioUtils.getScenarioContext().headers = RequestHeaderUtils.getBasicHeader();
                this.scenarioUtils.getScenarioContext().requestBody = ReadJSONUtils.readRequestJSON(strEndPoint);
                break;
        }

    }

    @And("User can make a post call request")
    public void user_can_make_a_post_call_request() {
         this.scenarioUtils.getScenarioContext().response= ReusableMethodUtils.postMethod(this.scenarioUtils.getScenarioContext().strBaseURL,
                 this.scenarioUtils.getScenarioContext().strEndPoint,this.scenarioUtils.getScenarioContext().headers,this.scenarioUtils.getScenarioContext().requestBody
                 );
    }

    @Then("Validate the response code as {string} and header type as {string}")
    public void validate_the_response_code_as_and_header_type_as(String strResponseCode, String strResponseType) {
        ValidationUtils.validateResponseCode(this.scenarioUtils.getScenarioContext().response,strResponseCode);
        ValidationUtils.validateResponseType(this.scenarioUtils.getScenarioContext().response,strResponseType);
    }

    @And("Validate the created response required values")
    public void validate_the_created_response_required_values(DataTable dataTable) {
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

    }

    @And("Validate the post {string} schema")
    public void validate_the_post_schema(String strSchema) {
            ValidationUtils.validateSchema(this.scenarioUtils.getScenarioContext().response,strSchema);
    }

    @And("Validate expected {string} response actual")
    public void validate_expected_response_actual(String strResponse) {
        String strExpected=null;
        switch(strResponse) {
            case "PostRequestResponse":
                strExpected = ReadJSONUtils.readResponseJSON(strResponse).toString();
                break;
        }
        Assert.assertEquals(this.scenarioUtils.getScenarioContext().response.getBody().asString(),strExpected);


    }

}
