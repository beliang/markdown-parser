import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.Assert.*;

import org.junit.*;

public class MarkdownParseTest {

    // @Test
    // public void addition() {
    //     assertEquals(2, 1 + 1);
    // }

    @Test
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

    @Test
    public void part5FirstFileTest() throws IOException
    {
        ArrayList<String> test = new ArrayList<String>();
        System.out.println("Testing file test");
        Path fileName = Path.of("part5-firstfile.md");
        String content = Files.readString(fileName);

        assertEquals(test, MarkdownParse.getLinks(content));
    }

    @Test
    public void part5SecondFileTest() throws IOException
    {
        ArrayList<String> test = new ArrayList<String>();
        test.add("https://something.com");
        test.add("some-thing.html");
        test.add("google.com");
        test.add("google.com");
        System.out.println("Testing file test");
        Path fileName = Path.of("part5-secondfile.md");
        String content = Files.readString(fileName);

        assertEquals(test, MarkdownParse.getLinks(content));
    }

    @Test
    public void testFile() throws IOException
    {
        ArrayList<String> test = new ArrayList<String>();
        test.add("https://something.com");
        test.add("some-thing.html");
        System.out.println("Testing file test");
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);

        assertEquals(test, MarkdownParse.getLinks(content));
    }

    @Test // error
    public void testFile2() throws IOException
    {
        ArrayList<String> test = new ArrayList<String>();
        test.add("https://something.com");
        test.add("some-page.html");
        System.out.println("Testing file test");
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);

        assertEquals(test, MarkdownParse.getLinks(content));
    }

    @Test
    public void testFile3() throws IOException
    {
        ArrayList<String> test = new ArrayList<String>();
        System.out.println("Testing file test");
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);

        assertEquals(test, MarkdownParse.getLinks(content));
    }

    @Test
    public void testFile4() throws IOException
    {
        ArrayList<String> test = new ArrayList<String>();
        System.out.println("Testing file test");
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);

        assertEquals(test, MarkdownParse.getLinks(content));
    }

    @Test // error
    public void testFile5() throws IOException
    {
        ArrayList<String> test = new ArrayList<String>();
        System.out.println("Testing file test");
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);

        assertEquals(test, MarkdownParse.getLinks(content));
    }

    @Test // error
    public void testFile6() throws IOException
    {
        ArrayList<String> test = new ArrayList<String>();
        System.out.println("Testing file test");
        Path fileName = Path.of("test-file6.md");
        String content = Files.readString(fileName);

        assertEquals(test, MarkdownParse.getLinks(content));
    }

    @Test // error
    public void testFile7() throws IOException
    {
        ArrayList<String> test = new ArrayList<String>();
        System.out.println("Testing file test");
        Path fileName = Path.of("test-file7.md");
        String content = Files.readString(fileName);

        assertEquals(test, MarkdownParse.getLinks(content));
    }

    // @Test // error
    // public void testFile8() throws IOException
    // {
    //     ArrayList<String> test = new ArrayList<String>();
    //     System.out.println("Testing file test");
    //     Path fileName = Path.of("test-file8.md");
    //     String content = Files.readString(fileName);

    //     assertEquals(test, MarkdownParse.getLinks(content));
    // }
}