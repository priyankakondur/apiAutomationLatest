package tests;

import org.testng.annotations.Test;
import utils.AddBookAPI;
import utils.GetBookByAuthorName;

public class GetBooksByAuthorNameTest {
    @Test
    public void getBookByAuthorName() {
        //add first book
        AddBookAPI addBook = new AddBookAPI();
        String Id = addBook.addBookAPI("jaya").getId();

        //add second book
        AddBookAPI addBook1 = new AddBookAPI();
        String Id1 = addBook1.addBookAPI("sushma").getId();


        //add third book
        AddBookAPI addBook2 = new AddBookAPI();
        String Id2 = addBook2.addBookAPI("vijaya").getId();

        // get all the books that match author name
        GetBookByAuthorName getBooksByAuthorName = new GetBookByAuthorName();
        getBooksByAuthorName.getBookByName("piriyan");


    }
}
