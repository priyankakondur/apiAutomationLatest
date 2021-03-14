package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AddBookAPI;
import utils.AddDuplicateBookAPI;

public class AddDuplicateBookAPITest {
    @Test
    public void AddDuplicateBookAPITest(){
        AddDuplicateBookAPI addDuplicateBook = new AddDuplicateBookAPI();
        String failureMessageResponse = addDuplicateBook.addDuplicateBookAPI().getMsg();
        Assert.assertEquals(failureMessageResponse,"Add Book operation failed, looks like the book already exists");
    }
    }

