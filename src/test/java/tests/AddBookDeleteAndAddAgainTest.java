package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import responseServices.AddBookResponse;
import utils.AddBookAPI;
import utils.DeleteBookAPI;
import utils.GetBookByPassingIDAfterDeleting;
import utils.GetBookByPassingIDParam;

public class AddBookDeleteAndAddAgainTest {
    @Test
    public void AddBookDeleteAndAddAgain() {
        //Adding book using POST and then do a GET by ID call to verify if it is added
        AddBookAPI addBook = new AddBookAPI();
        String ID = addBook.addBookAPI("gdhfdjdf").getId();
        GetBookByPassingIDParam getBook = new GetBookByPassingIDParam();
        String bookName = getBook.getBookByName(ID);


        // Delete the book recently added and verify if it is deleted using GET by ID
        DeleteBookAPI deleteBook = new DeleteBookAPI();
        String msgAfterDeletingBook = deleteBook.deleteBookAPI(ID);
        Assert.assertEquals(msgAfterDeletingBook, "book is successfully deleted");
        GetBookByPassingIDAfterDeleting getBookAfterDeleting = new GetBookByPassingIDAfterDeleting();
        String msgGetBookAfterDeleting = getBookAfterDeleting.getBookAfterDeleting(ID);
        Assert.assertEquals(msgGetBookAfterDeleting,"The book by requested bookid / author name does not exists!");

        //Adding the same book again
        String newID = addBook.addBookAPI("hgkgkg").getId();
        System.out.println("new ID: "+newID);

    }
}
