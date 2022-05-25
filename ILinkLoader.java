
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.List;
import java.io.FileNotFoundException;

/**
 * Interface for loading the links
 */
public interface ILinkLoader {
    /**
     * This method loads the list of Links that are involved with the
     * JSOUP
     * @param filepath
     * @return
     * @throws FileNotFoundException
     */
    public List<String> loadLinks(String filepath) throws FileNotFoundException, IOException;
}
