// --== CS400 File Header Information ==--
// Individual Code: Cooler WikiGame Project 3, red group DE team
// Name: Jake Christensen
// Email: jrchristens2@wisc.edu
// Team: DE
// TA: April
// Lecturer: Florian
// Notes to Grader: Changed a couple of things revolving around the interfaces after noticing that there were
//some complications when implementing.
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will represent the link object
 */
public class Link implements ILink {

    private List<String> links;
    private List<String> text;
    private List<String> html;

    /**
     * Constructor
     * @param links
     * @param text
     * @param html
     */
    public Link(String text, List<Link> links, String html) {
        /**
        this.links = links;
        this.text = text;
        this.html = html;
        */
    }

    /**
     * Constructor
     * @param TEXT
     * @param LINKS
     * @param HTML
     */
    public Link(List<String> TEXT, List<String> LINKS, List<String> HTML) {
        this.text = TEXT;
        this.links = LINKS;
        this.html = HTML;
    }

    /**
     * This method will return the link format of each link
     * when the user calls it on a specific filepath or url.
     *
     * @return links
     */
    @Override
    public List<String> getLinks(String filePath) throws IOException {
        try {
            String url = filePath; //specific url to parse and scrape urls and data from
            Document specificURL = Jsoup.connect(url).get(); //connects to the specific url
            Elements pageElements = specificURL.select("a[href]");

            List<String> links = new ArrayList<>();

            for (Element i : pageElements) {
                links.add("Links: " + i.attr("abs:href").toString());
            }

            return links;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return links;
    }

        /**
     * This method will return the text format of each link
     * when the user calls it on a specific filepath or url.
     *
     * @return text
     */
    @Override
    public List<String> getText(String filePath) throws IOException {
        try {
            String url = filePath; //specific url to parse and scrape urls and data from
            Document specificURL = Jsoup.connect(url).get(); //connects to the specific url
            Elements pageElements = specificURL.select("a[href]");

            List<String> text = new ArrayList<>();

            for (Element i : pageElements) {
                text.add("Text: " + i.text());
            }
            return text;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

        /**
     * This method will return the html format of each link
     * when the user calls it on a specific filepath or url.
     *
     * @return html
     */
    @Override
    public List<String> getHTML(String filePath) throws IOException {

        String url = filePath; //specific url to parse and scrape urls and data from
        Document specificURL = Jsoup.connect(url).get(); //connects to the specific url
        Elements pageElements = specificURL.select("a[href]");

        List<String> html = new ArrayList<>();

        for(Element i: pageElements){
            html.add("html: " + i.html().toString());
        }

        return html;
    }

    /**
     * Compare to method that compares the links to each other
     * @param link
     * @return
     */
    @Override
    public int compareTo(Link link, String filePath) throws IOException {
        int compare = link.compareTo((Link) link.getLinks(filePath));
        return compare;
    }

    /**
     * Compare to method
     * @param o
     * @return
     */
    @Override
    public int compareTo(Link o) {
        return 0;
    }
}
