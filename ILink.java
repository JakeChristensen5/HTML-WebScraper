
import java.io.IOException;
import java.util.List;

/**
 * This interface will extend the functionality of the Link class
 * displaying methods that will fetch and parse a browsers HTML target page
 * then extract and manipulate the pages content to return the pages Link/URL as well
 * as any text related to that link.
 *
 */
public interface ILink extends Comparable<Link> {

    /**
     * Method that will iterate and extract an HTML web page and return
     * the pages elements in the form of "Document" and will be able to return the
     * links found on each HTML page.
     * @return
     */
    List<String> getLinks(String filePath) throws IOException;


    /**
     * Method that will iterate and extract an HTML web page and return
     * the pages elements in the form of "Document" and will be able to return the
     * text describing each page (ex. Review, Shop, Tech, ect.) found on each HTML page
     * to help aid Dijkstra's algorithm performance.
     * @return
     */
    List<String> getText(String filePath) throws IOException;

    /**
     * Method that will return the parsed HTML version of a specific URL.
     * @return
     */
    List<String> getHTML(String filePath) throws IOException;

    /**
     * Compares to Link objects lexicographically
     * @param link
     * @return
     */
    public int compareTo(Link link, String filePath) throws IOException;
}
