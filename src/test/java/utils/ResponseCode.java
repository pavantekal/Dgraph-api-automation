package utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

/**
 * This interface defines all the Response Code Constants
 *
 */

public class ResponseCode {

    public static final ResponseSpecification OK = new ResponseSpecBuilder().expectStatusCode(200).build();

    public static final ResponseSpecification CREATED = new ResponseSpecBuilder().expectStatusCode(201).build();

    public static final ResponseSpecification  ACCEPTED = new ResponseSpecBuilder().expectStatusCode(202).build();

    public static final ResponseSpecification  PARTIAL_INFORMATION = new ResponseSpecBuilder().expectStatusCode(203).build();

    public static final ResponseSpecification  NO_RESPONSE = new ResponseSpecBuilder().expectStatusCode(204).build();

    public static final ResponseSpecification  BAD_REQUEST = new ResponseSpecBuilder().expectStatusCode(400).build();

    public static final ResponseSpecification  UNAUTHORIZED = new ResponseSpecBuilder().expectStatusCode(401).build();

    public static final ResponseSpecification  PAYMENT_REQUIRED = new ResponseSpecBuilder().expectStatusCode(402).build();

    public static final ResponseSpecification  FORBIDDEN = new ResponseSpecBuilder().expectStatusCode(403).build();

    public static final ResponseSpecification  NOT_FOUND = new ResponseSpecBuilder().expectStatusCode(404).build();

    public static final ResponseSpecification  METHOD_NOT_ALLOWED = new ResponseSpecBuilder().expectStatusCode(405).build();

    public static final ResponseSpecification  CONFLICT = new ResponseSpecBuilder().expectStatusCode(409).build();

    public static final ResponseSpecification  PRE_CONDITION_FAIL = new ResponseSpecBuilder().expectStatusCode(412).build();

    public static final ResponseSpecification  INTERNAL_ERROR = new ResponseSpecBuilder().expectStatusCode(500).build();

    public static final ResponseSpecification  NOT_IMPLEMENTED = new ResponseSpecBuilder().expectStatusCode(501).build();

    public static final ResponseSpecification  SERVICE_TEMP_OVERLOADED = new ResponseSpecBuilder().expectStatusCode(502).build();

    public static final ResponseSpecification  GATEWAY_TIMEOUT = new ResponseSpecBuilder().expectStatusCode(503).build();

    public static final ResponseSpecification  MOVED = new ResponseSpecBuilder().expectStatusCode(301).build();

    public static final ResponseSpecification  FOUND = new ResponseSpecBuilder().expectStatusCode(302).build();

    public static final ResponseSpecification  METHOD = new ResponseSpecBuilder().expectStatusCode(303).build();

    public static final ResponseSpecification  NOT_MODIFIED = new ResponseSpecBuilder().expectStatusCode(304).build();

    public static final ResponseSpecification  TEMPORARY_REDIRECT = new ResponseSpecBuilder().expectStatusCode(307).build();

}
