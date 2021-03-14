package tests;

import org.testng.annotations.Test;
import utils.AddBookAPI;
import utils.DeleteBookAPI;
import utils.GetBookByAuthorName;

public class GetBooksByAuthorNameAndDeleteOneTest {
    @Test
    public void getBooksByAuthorNameAndDeleteOne() {
        //add first book
        AddBookAPI addBook = new AddBookAPI();
        String Id = addBook.addBookAPI("anji").getId();

        //add second book
        AddBookAPI addBook1 = new AddBookAPI();
        String Id1 = addBook1.addBookAPI("ranji").getId();


        //add third book with
        AddBookAPI addBook2 = new AddBookAPI();
        String Id2 = addBook2.addBookAPI("tanji").getId();

        // get all the books that match author name
        GetBookByAuthorName getBooksByAuthorName = new GetBookByAuthorName();
        getBooksByAuthorName.getBookByName("piriyan");

        //delete one book
        DeleteBookAPI deleteBook = new DeleteBookAPI();
        deleteBook.deleteBookAPI(Id2);

        // get all the books that match author name
        getBooksByAuthorName.getBookByName("piriyan");
    }
}