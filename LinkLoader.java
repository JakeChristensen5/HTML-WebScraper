
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 */
public class LinkLoader implements ILinkLoader {

    public List<String> listOfLinks;

    /**
     * Local constructor that initializes the list of links
     */
    public LinkLoader() {
        this.listOfLinks = new ArrayList<String>();
    }
    /**
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    @Override
    public List<String> loadLinks(String filePath) throws FileNotFoundException {

        //data fields ~
        String url = filePath; //specific url to parse and scrape urls and data from

        //tests to see if the initial filepath user input is null or not
        if (filePath.equals(null)) {
            return null;
        }
        //regex expression to see if the desired filePath is valid or not
        if(!isValidUrl(filePath, "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")){
            return null;
        }

        //try-catch clause ~
        try {
            //data fields~
            Document specificURL = Jsoup.connect(url).get(); //connects to the specific url
            Elements pageElements = specificURL.select("a[href]"); //css selection

            List<String> listOfLinks = new ArrayList<>(); //creates new list for elements to be stored too


            /**
             * Iterates and parses through a specific wikipedia page to extract the text, link, and html data
             * that will be necessary for the user to use. Gives a clear format of data in precise list format.
             */
            for (Element e : pageElements) {
                listOfLinks.add("Text: " + e.text());
                listOfLinks.add("Links: " + e.attr("abs:href").toString());
                listOfLinks.add("HTML: " + e.html());
                listOfLinks.add("");
            }

            /**
             * Displays the Text, Link, and HTML information to the display.
            for (String s : listOfLinks) {
                System.out.println(s);
            }
             */

            return listOfLinks; //return statement

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfLinks;
    }

    /**
     * Regex private helper method ~
     *
     * @param url
     * @param regexPattern
     * @return
     */
    private static boolean isValidUrl(String url, String regexPattern){
        Pattern patt = Pattern.compile(regexPattern);
        Matcher matcher = patt.matcher(url);
        return matcher.matches();
    }
    /**
     * Private placeholder helper method ~
     * @return
    private static String readInput() {
    System.out.println("Enter a URL");
    Scanner scan = new Scanner(System.in);
    return scan.nextLine();
    }
     */
    /**
     * main ~
     * @param args
     */
    public static void main(String[] args) {
        /**
         String input = readInput();
         boolean urlValid = false;
         URL url = null;
         while (!urlValid) {

         try {
         url = new URL(input);
         urlValid = true;
         System.out.println("The url was valid");
         } catch (MalformedURLException e) {
         System.out.println("The url was invalid, please try again");
         input = readInput();
         }
         }

         //continue processing
         System.out.println("The url entered was: " + url.toString());
         */
    }
}

