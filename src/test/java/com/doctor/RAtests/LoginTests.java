package com.doctor.RAtests;

import com.doctor.dto.LoginRequestDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class LoginTests extends TestBase {


    //POSITIVE
    LoginRequestDto login = LoginRequestDto.builder()
            //   .username("Tati@gm.com") ADMIN
            .username("iv_ivanov@gm.com")  //USER
            .password("123S!fghjk")
            .build();

    @Test
    public void loginSuccessTest() {
        given()
                .contentType("application/json")
                .body(login)
                .when()
                .post("auth/login")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void loginSuccessTest2() {
        String accessToken = given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("auth/login")
                .then()
                .assertThat().statusCode(200)
                .body(containsString("accessToken"))
                .body(containsString("refreshToken"))
                .extract().path("refreshToken", "accessToken");

        System.out.println(accessToken + " ********** " + accessToken);
    }


    //NEGATIVE
    //NOT VALID EMAIL
    LoginRequestDto negativeLogin = LoginRequestDto.builder()
            //   .username("Tati@gm.com")
            .username("iv_ivanov@gm.")
            .password("123S!fghjk")
            .build();


    @Test
    public void negativeLoginTest() {
        given()
                .contentType(ContentType.JSON)
                .body(negativeLogin)
                .when()
                .post("auth/login")
                .then()
                .assertThat().statusCode(403);
    }


    //NOT VALID PASSWORD
    LoginRequestDto negativePassword = LoginRequestDto.builder()
            .username("iv_ivanov@gm.com")
            .password("123")
            .build();

    @Test
    public void negativeLoginTest2() {
        given()
                .contentType(ContentType.JSON)
                .body(negativePassword)
                .when()
                .post("auth/login")
                .then()
                .assertThat().statusCode(400);
    }

}
