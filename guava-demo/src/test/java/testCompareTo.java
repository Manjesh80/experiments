import com.manjesh.experiments.common.Book;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/14/2016.
 */

public class testCompareTo {

    @Test
    public void testOrder() throws Exception {
        Book book1 = new Book("Author 1", "MCom","PacktPub","ISBN-1",10);
        Book book2 = new Book("Author 1", "ECom","PacktPub","ISBN-1",10);
        int order = book1.compareTo(book2);
        assertTrue(order > 0);
    }
}
