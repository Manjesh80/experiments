import com.manjesh.experiments.guavademo.Book;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/14/2016.
 */

public class testCompareTo {

    @Test
    public void testOrder() throws Exception {
        Book book1 = new Book();
        book1.setTitle("MCom");

        Book book2 = new Book();
        book2.setTitle("ECom");

        int order = book1.compareTo(book2);
        assertTrue(order > 0);
    }
}
