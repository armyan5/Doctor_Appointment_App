package com.doctor.RAtests;

import com.doctor.dto.RegistrationDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RegistrationTests extends TestBase {

    //POSITIVE TEST
    RegistrationDto registration = RegistrationDto.builder()
            .name("Johny")
            .surname("Deep")
            .username("Johny123@gm.com")
            .password("Johny123&")
            .build();


    @Test
    public void registrationSuccessTest() {
        given()
                .contentType("application/json")
                .body(registration)
                .when()
                .post("users/registration")
                .then()
                .assertThat().statusCode(200);
    }


    //NEGATIVE TEST WITH NOT VALID NAME
    RegistrationDto registration1 = RegistrationDto.builder()
            .name("1111") //NOT VALID
            .surname("Deep")
            .username("Johny123@gm.com")
            .password("Johny123&")
            .build();

    @Test
    public void registrationNegativeTest1() {
        given()
                .contentType("application/json")
                .body(registration1)
                .when()
                .post("users/registration")
                .then()
                .assertThat().statusCode(400);
    }

    //NEGATIVE TEST WITH NOT VALID SURNAME
    RegistrationDto registration2 = RegistrationDto.builder()
            .name("Johny")
            .surname("5555") // NOT VALID
            .username("Johny123@gm.com")
            .password("Johny123&")
            .build();

    @Test
    public void registrationNegativeTest2() {
        given()
                .contentType("application/json")
                .body(registration2)
                .when()
                .post("users/registration")
                .then()
                .assertThat().statusCode(400);
    }

    //NEGATIVE TEST WITH NOT VALID USERNAME
    RegistrationDto registration3 = RegistrationDto.builder()
            .name("Johny")
            .surname("Deep")
            .username("Johny123com") //NOT VALID
            .password("Johny123&")
            .build();

    @Test
    public void registrationNegativeTest3() {
        given()
                .contentType("application/json")
                .body(registration3)
                .when()
                .post("users/registration")
                .then()
                .assertThat().statusCode(403);
    }

    //NEGATIVE TEST WITH NOT VALID PASSWORD
    RegistrationDto registration4 = RegistrationDto.builder()
            .name("Johny")
            .surname("Deep")
            .username("Johny123@gm.com")
            .password("Johny")  // NOT VALID
            .build();

    @Test
    public void registrationNegativeTest4() {
        given()
                .contentType("application/json")
                .body(registration4)
                .when()
                .post("users/registration")
                .then()
                .assertThat().statusCode(400);
    }

}

