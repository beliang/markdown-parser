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

            if (openBracket > 0 && markdown.charAt(openBracket - 1) == '!') {
                currentIndex = closeParen;
                continue;
            }

            if (currentIndex <= charIndex) {
                charIndex ++;
            }
            else {
                charIndex = currentIndex;
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }

            if (charIndex == markdown.length() - 1) {
                break;
            }
            //toReturn.add(markdow
            
        }

        int lessThan = 0;
        int greaterThan = 0;

        for(int i = 0; i < markdown.length(); i ++) {
            if (markdown.charAt(i) == '<') {
                lessThan = i;
                boolean there = true;
                while(there) {
                    if (markdown.charAt(i) == '>') {
                        greaterThan = i;
                        there = false;
                    }
                    else {
                        i ++;
                    }
                }
                toReturn.add(markdown.substring(lessThan + 1, greaterThan));
                lessThan = 0;
                greaterThan = 0;
            }
        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);

        System.out.println("lab4");
        System.out.println(MarkdownParse.getLinks("part4-file.md"));
    }
}