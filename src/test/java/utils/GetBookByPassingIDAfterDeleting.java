package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import responseServices.GetBookAfterDeleting;

public class GetBookByPassingIDAfterDeleting {
    public String getBookAfterDeleting(String id) {
        RestAssured.baseURI = "http://216.10.245.166/";
        Response responseGetBook = RestAssured.given().queryParam("ID", id)
                .header("Content-Type", "application/json")
                .when().get("Library/GetBook.php")
                .then().statusCode(404).extract().response();
        System.out.println(responseGetBook.asString());
        GetBookAfterDeleting book =  responseGetBook.as(GetBookAfterDeleting.class);
        //Assert.assertEquals(book.getMsg(),"The book by requested bookid / author name does not exists!");
        return book.getMsg();
    }
}
