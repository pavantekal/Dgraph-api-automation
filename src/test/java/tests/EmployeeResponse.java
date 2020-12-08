package tests;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.hasKey;

public class EmployeeResponse extends BaseTest{
    public static ResponseSpecification getAllEmployees() {
        return new ResponseSpecBuilder()
                .expectBody(
                        matchesJsonSchemaInClasspath(
                                "json_schema_response/getAllEmployees.json"))
                .expectBody("$", hasKey("status"))
                .expectBody("$", hasKey("data"))
                .build();
    }

    public static ResponseSpecification createEmployeeRecord() {
        return new ResponseSpecBuilder()
                .expectBody(
                        matchesJsonSchemaInClasspath(
                                "json_schema_response/createEmployeeRecord.json"))
                .expectBody("$", hasKey("status"))
                .expectBody("$", hasKey("data"))
                .build();
    }

    public static ResponseSpecification getEmployeeById() {
        return new ResponseSpecBuilder()
                .expectBody(
                        matchesJsonSchemaInClasspath(
                                "json_schema_response/getEmployeeById.json"))
                .expectBody("$", hasKey("status"))
                .expectBody("$", hasKey("data"))
                .build();
    }

    public static ResponseSpecification getEmployeeByIdNegative() {
        return new ResponseSpecBuilder()
                .expectBody(
                        matchesJsonSchemaInClasspath(
                                "json_schema_response/getEmployeeByIdNegative.json"))
                .expectBody("$", hasKey("status"))
                .expectBody("$", hasKey("data"))
                .build();
    }

    public static ResponseSpecification updateEmployee() {
        return new ResponseSpecBuilder()
                .expectBody(
                        matchesJsonSchemaInClasspath(
                                "json_schema_response/updateEmployee.json"))
                .expectBody("$", hasKey("status"))
                .expectBody("$", hasKey("data"))
                .build();
    }

    public static ResponseSpecification deleteEmployee() {
        return new ResponseSpecBuilder()
                .expectBody(
                        matchesJsonSchemaInClasspath(
                                "json_schema_response/deleteEmployee.json"))
                .expectBody("$", hasKey("status"))
                .expectBody("$", hasKey("data"))
                .build();
    }
}
