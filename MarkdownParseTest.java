import static org.junit.Assert.*;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.*;

public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    //@Test
    public void part4FileTest() throws IOException
    {
        ArrayList<String> test = new ArrayList<String>();
        test.add("https://something.com");
        test.add("some-thing.html");
        test.add("google.com");
        System.out.println("Testing file test");
        Path fileName = Path.of("part4-file.md");
        String content = Files.readString(fileName);

        assertEquals(test, MarkdownParse.getLinks(content));
    }
}