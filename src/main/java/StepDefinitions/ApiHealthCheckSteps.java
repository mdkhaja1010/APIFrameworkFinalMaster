package StepDefinitions;

import DriverManagers.ConfigFileManager;
import Utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiHealthCheckSteps {
    ScenarioUtils scenarioUtils;
    public ApiHealthCheckSteps(ScenarioUtils scenarioUtils)
    {
        this.scenarioUtils=scenarioUtils;

    }
    @Given("user access to {string} endpoint")
    public void user_access_to_endpoint(String strEndPointType) {
        String strBaseURL,strEndPoint;
        switch(strEndPointType){
            case "NotesEndPoint":
                strBaseURL= ConfigFileManager.getInstance().getReadConfig().getBaseURL();
                strEndPoint=ConfigFileManager.getInstance().getReadConfig().getNotesEndPoint();
                this.scenarioUtils.getScenarioContext().strBaseURL=strBaseURL;
                this.scenarioUtils.getScenarioContext().strEndPoint=strEndPoint;
                break;
            case "UserCreateEndPoint" :
                strBaseURL= ConfigFileManager.getInstance().getReadConfig().getBaseURL();
                strEndPoint=ConfigFileManager.getInstance().getReadConfig().getUserCreateEndPoint();
                this.scenarioUtils.getScenarioContext().strBaseURL=strBaseURL;
                this.scenarioUtils.getScenarioContext().strEndPoint=strEndPoint;
                break;
            case "UserLoginEndPoint":
                strBaseURL= ConfigFileManager.getInstance().getReadConfig().getBaseURL();
                strEndPoint=ConfigFileManager.getInstance().getReadConfig().getLoginEndPoint();
                this.scenarioUtils.getScenarioContext().strBaseURL=strBaseURL;
                this.scenarioUtils.getScenarioContext().strEndPoint=strEndPoint;
                break;
            case "UserEndPoint":
                strBaseURL= ConfigFileManager.getInstance().getReadConfig().getBaseURL();
                strEndPoint=ConfigFileManager.getInstance().getReadConfig().getUserEndPoint();
                this.scenarioUtils.getScenarioContext().strBaseURL=strBaseURL;
                this.scenarioUtils.getScenarioContext().strEndPoint=strEndPoint;
                break;

            default:
                throw new IllegalArgumentException("Unsupported endpoint type: " + strEndPointType);

        }

    }

    @And("build {string} request header and json")
    public void build_request_header_and_json(String strEndPoint) {
        switch (strEndPoint) {
            case "NotesEndPoint":
                this.scenarioUtils.getScenarioContext().headers = RequestHeaderUtils.getBasicHeader();
                break;
            case "UserCreateEndPoint":
                this.scenarioUtils.getScenarioContext().headers = RequestHeaderUtils.getBasicHeader(); // Customize if needed
               // this.scenarioUtils.getScenarioContext().requestBody = RequestBodyUtils.getLoginRequestBody(); // Assuming you have this method
                break;
            case "UserLoginEndPoint":
                this.scenarioUtils.getScenarioContext().headers = RequestHeaderUtils.getBasicHeader(); // Customize if needed
                // this.scenarioUtils.getScenarioContext().requestBody = RequestBodyUtils.getLoginRequestBody(); // Assuming you have this method
                break;
            case "UserEndPoint":
                ReusableMethodUtils.waittime(5000);
                this.scenarioUtils.getScenarioContext().headers = ReusableHeaderUtilsToken.getBasicHeader(); // Customize if needed
                // this.scenarioUtils.getScenarioContext().requestBody = RequestBodyUtils.getLoginRequestBody(); // Assuming you have this method
                break;

        }
    }



    @Then("Validate the response code {string} and type {string}")
    public void validate_the_response_code_and_type(String strResponseCode, String strResponseType) {
        ValidationUtils.validateResponseCode(this.scenarioUtils.getScenarioContext().response,strResponseCode);
        ValidationUtils.validateResponseType(this.scenarioUtils.getScenarioContext().response,strResponseType);

    }
    @When("user make post with user name {string} and mail {string} and password as {string}")
    public void user_make_post_with_user_name_and_mail_and_password_as(String uname, String mail, String pwd) {
        this.scenarioUtils.getScenarioContext().response = ReusableMethodUtils.postMethodforUrlencoded(
                this.scenarioUtils.getScenarioContext().strBaseURL,
                this.scenarioUtils.getScenarioContext().strEndPoint,
                this.scenarioUtils.getScenarioContext().headers,
                uname, mail, pwd
        );
    }
    @When("user make a get request")
    public void user_make_a_get_request() {
        ReusableMethodUtils.waittime(5000);
        this.scenarioUtils.getScenarioContext().response= ReusableMethodUtils.getMethod(this.scenarioUtils.getScenarioContext().strBaseURL,this.scenarioUtils.getScenarioContext().strEndPoint,
                this.scenarioUtils.getScenarioContext().headers);

    }



}
