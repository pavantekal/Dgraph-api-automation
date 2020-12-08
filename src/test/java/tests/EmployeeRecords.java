package tests;

import io.restassured.response.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.listener.TestListener;
import utils.ResponseCode;

import java.util.Random;

import static io.restassured.RestAssured.given;

@Listeners(TestListener.class)
public class EmployeeRecords extends BaseTest {

    private static final Logger logger= LoggerFactory.getLogger("CRUD Operations on Employee data");


    private Integer employeeID;


    @DataProvider(name="EidProvider")
    public Object[] getDataFromDataprovider(){
        return new Object[]
                {
                        EmployeeRequests.getValidEid(),
                       EmployeeRequests.getInvalidEid()
                };

    }

    /**
     * This method will fetch and validate the details of Employees
     */

    @Test(priority = 0, description = "Fetching All Employee Records")
    public void getAllEmployeeRecords() throws InterruptedException {

        Response response =  given()
                .when()
                .get(EmployeeRequests.getAllEmployeesUrl())
                .then()
                .assertThat()
                .spec(ResponseCode.OK)
                .and()
                .spec(EmployeeResponse.getAllEmployees())
                .extract()
                .response();
        Thread.sleep(5000);
    }

    @Test(priority = 1, description = "Create a new employee record in the database")
    public void addEmployee() throws InterruptedException {
        Response response =  given()
                .spec(correctContentType())
                .spec(EmployeeRequests.createEmployeeBody())
                .when()
                .post(EmployeeRequests.createEmployeeUrl())
                .then()
                .assertThat()
                .spec(ResponseCode.OK)
                .and()
                .spec(EmployeeResponse.createEmployeeRecord())
                .extract()
                .response();
        employeeID = response.path("data.id");
        Thread.sleep(5000);
    }

    @Test(priority = 2, description = "Get Employee by ID - Positive/Negative Test Case", dataProvider="EidProvider")
    public void getEmployeeById(Integer eid) throws InterruptedException {
        given()
                .spec(correctContentType())
                .when()
                .get(EmployeeRequests.getEmployeeByIdUrl(eid))
                .then()
                .assertThat()
                .spec(ResponseCode.OK)
                .and()
                .spec(EmployeeResponse.getEmployeeById())
                .extract()
                .response();
        Thread.sleep(5000);

    }

    @Test(priority = 3, description = "Update Employee Record")
    public void updateEmployeeRecord() throws InterruptedException {
        given()
                .spec(correctContentType())
                .spec(EmployeeRequests.updateEmployeeBody())
                .when()
                .put(EmployeeRequests.updateEmployeeRecordUrl(employeeID))
                .then()
                .assertThat()
                .spec(ResponseCode.OK)
                .and()
                .spec(EmployeeResponse.updateEmployee())
                .extract()
                .response();
        Thread.sleep(5000);
    }

    @Parameters({"eid"})
    @Test(priority = 4, description = "Delete Employee Record")
    public void deleteEmployeeRecord(Integer eid) {
        given()
                .spec(correctContentType())
                .when()
                .delete(EmployeeRequests.deleteEmployeRecordUrl(eid))
                .then()
                .assertThat()
                .spec(ResponseCode.OK)
                .and()
                .spec(EmployeeResponse.deleteEmployee())
                .extract()
                .response();
    }
}
