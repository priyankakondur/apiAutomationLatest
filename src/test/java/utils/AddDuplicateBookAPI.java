package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import requestServices.AddBookRequest;
import responseServices.AddDuplicateBookResponse;

import java.util.Random;

public class AddDuplicateBookAPI {
    public AddDuplicateBookResponse addDuplicateBookAPI() {
        RestAssured.baseURI = "http://216.10.245.166/";
        AddBookRequest addBook = new AddBookRequest();
        addBook.setName("my name is kondur");
        addBook.setAuthor("abcd");
        addBook.setAisle(665);
        addBook.setIsbn("oiu");

        Response responseAddDuplicateBook = RestAssured.given().header("Content-Type", "application/json")
                .body(addBook)
                .log().all()
                .when().post("/Library/Addbook.php")
                .then().log().all()
                .assertThat().statusCode(404).extract().response();
        System.out.println(responseAddDuplicateBook.asString());
        AddDuplicateBookResponse duplicateBookResponse = responseAddDuplicateBook.getBody().as(AddDuplicateBookResponse.class);
        // Assert.assertEquals(duplicateBookResponse.getMsg(),"Add Book operation failed, looks like the book already exists");
        return duplicateBookResponse;
    }
}