package com.doctor.RAtests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    //USER
    public static final String accessToken =
            "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJpdl9pdmFub3ZAZ20uY29tIiwiZXhwIjoxNzEyMDkzMTk0LCJyb2xlcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9QQVRJRU5UIn1dLCJuYW1lIjoiaXZfaXZhbm92QGdtLmNvbSIsInN1cm5hbWUiOiJJdmFub3YifQ.iFvnoMQ5jO3FSI_37VhRNDrXymzPji8H_LDLqJxVSPI";

    private static final String accessTokenDoctor =
            "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzbWl0aEBnbS5jb20iLCJleHAiOjE3MTM1MjE4OTN9.aDw3PYGvOknIPpDYV2nvLCLoHofdoHyTfqOiHlAd_ZY";

    public static final String refreshToken =
            "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJpdl9pdmFub3ZAZ20uY29tIiwiZXhwIjoxNzEzMjUyOTE2fQ.CdyU5MRrTAKzlsneR8gP3gNGCUQWNOyODiuBMjCyMBs";

    public static final String AUTH = "Authorization";

    @BeforeMethod
    public void init() {

        RestAssured.baseURI = "http://localhost:8080/";
        RestAssured.basePath = "api";
    }
}
