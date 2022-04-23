//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        int charIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            currentIndex = closeParen + 1;

            System.out.println("open bracket: " + openBracket);
            int temp = openBracket-1;
            System.out.println("! index: " + temp);
            System.out.println("index 10 is: " + markdown.charAt(10));
            if (openBracket > 0 && markdown.charAt(openBracket - 1) == '!') {
                currentIndex = closeParen;
                continue;
            }

            if (currentIndex <= charIndex) {
                charIndex ++;
            }
            else {
                charIndex = currentIndex;
                System.out.println("Addiding: " + markdown.substring(openParen + 1, closeParen));
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }

            if (charIndex == markdown.length() - 1) {
                return toReturn;
            }

            //toReturn.add(markdown.substring(openParen + 1, closeParen));

            System.out.println(currentIndex);
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
