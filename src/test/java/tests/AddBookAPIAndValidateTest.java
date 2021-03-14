package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AddBookAPI;

public class AddBookAPIAndValidateTest {
    @Test
    public void addBookAPIAndValidate(){
        AddBookAPI addBook = new AddBookAPI();
        String successMessageResponse = addBook.addBookAPI("abc").getMsg();
        Assert.assertEquals(successMessageResponse,"successfully added");
    }
}
