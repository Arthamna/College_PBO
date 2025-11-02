import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SalesItemTest {

    @Test
    public void testConstructorAndGetters() {
        SalesItem item = new SalesItem("Laptop", 1000000);

        assertEquals("Laptop", item.getName());
        assertEquals(1000000, item.getPrice());
        assertEquals(0, item.getNumberOfComments());
    }

    @Test
    public void testAddCommentValid() {
        SalesItem item = new SalesItem("Phone", 200000);

        assertTrue(item.addComment("Syafiq", "Sybau", 1));
        assertEquals(1, item.getNumberOfComments());
    }

    @Test
    public void testAddCommentDuplicateAuthor() {
        SalesItem item = new SalesItem("Tablet", 400000);

        assertTrue(item.addComment("Bombardilo", "Hell nah", 4));
        assertFalse(item.addComment("Bombardilo", "Lemme try again", 3)); // Test Duplicate (not allowed) 
    }

    @Test
    public void testAddCommentInvalidRating() {
        SalesItem item = new SalesItem("Camera", 500000);

        assertFalse(item.addComment("Tungtung", "Bad rating!", -1)); // Test Invalid rating
        assertFalse(item.addComment("LilBahlil", "Too high rating!", 6)); // Test Invalid rating
    }

    @Test
    public void testRemoveComment() {
        SalesItem item = new SalesItem("Monitor", 17000);

        item.addComment("Aldric", "Capek wok!", 5);
        item.addComment("Bo", "Mana ijazahnya wok!", 4);

        assertEquals(2, item.getNumberOfComments());
        item.removeComment(0); // Test Remove first comment
        assertEquals(1, item.getNumberOfComments());
    }

    @Test
    public void testUpvoteDownvoteComment() {
        SalesItem item = new SalesItem("Keyboard", 4999);

        item.addComment("Aldric", "Mehh keyboard!", 5);
        item.addComment("Bo", "hmmmm", 4);

        item.upvoteComment(0);
        item.upvoteComment(0);
        item.downvoteComment(1);

        Comment comment1 = item.findMostHelpfulComment();
        assertEquals("Aldric", comment1.getAuthor());
        assertEquals(2, comment1.getVoteCount());

        Comment comment2 = item.findCommentByAuthor("Bo");
        assertEquals(-1, comment2.getVoteCount());
    }

    @Test
    public void testFindMostHelpfulComment() {
        SalesItem item = new SalesItem("Mouse", 50000);

        item.addComment("Aldric", "Good!", 4);
        item.addComment("Bo", "Better!", 5);
        item.upvoteComment(1);

        Comment mostHelpful = item.findMostHelpfulComment();
        assertEquals("Bo", mostHelpful.getAuthor());
    }

    @Test
    public void testShowInfo() {
        SalesItem item = new SalesItem("Headphones", 2000);

        item.addComment("Aldric", "Excellent sound quality!", 5);
        item.addComment("Bo", "Comfortable to wear.", 4);

        item.showInfo();
    }
}
