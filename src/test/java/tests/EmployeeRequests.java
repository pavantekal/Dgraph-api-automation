package tests;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Random;

public class EmployeeRequests extends BaseTest{
    public static String getAllEmployeesUrl() {
        return BASE_URL + data.get("allEmployees");
    }

    public static String createEmployeeUrl() {
        return BASE_URL + data.get("createEmployee");
    }

    public static String getEmployeeByIdUrl(Integer id) {
        return BASE_URL + data.get("Employee") + "/" + id;
    }

    public static String updateEmployeeRecordUrl(Integer id) {
        return BASE_URL + data.get("Update") + "/" + id;
    }

    public static String deleteEmployeRecordUrl(Integer id) {
        return BASE_URL + data.get("Delete") + "/" + id;
    }

    public static int getValidEid() {
        Random r = new Random();
        int low = 10;
        int high = 20;
        int result = r.nextInt(high-low) + low;
        return result;
    }

    public static int getInvalidEid(){
       return getValidEid()*-1;
    }

    public static RequestSpecification createEmployeeBody() {
        JSONObject createEmployee = new JSONObject();
        createEmployee.put("name","ExampleUser");
        createEmployee.put("salary","50,000");
        createEmployee.put("age","23");
        return new RequestSpecBuilder().setBody(createEmployee.toString()).build();
    }

    public static RequestSpecification updateEmployeeBody() {
        JSONObject updateEmployee = new JSONObject();
        updateEmployee.put("name","User2");
        return new RequestSpecBuilder().setBody(updateEmployee.toString()).build();
    }
}
