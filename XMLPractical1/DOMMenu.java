import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * DOM handler to read XML information, to create this, and to print it.
 *
 * @author CSCU9T4, University of Stirling
 * @version 11/03/20
 */
public class DOMMenu {

    /**
     * Document builder
     */
    private static DocumentBuilder builder = null;

    /**
     * XML document
     */
    private static Document document = null;

    /**
     * XPath expression
     */
    private static XPath path = null;

    /**
     * XML Schema for validation
     */
    private static Schema schema = null;

    /*----------------------------- General Methods ----------------------------*/

    /**
     * Main program to call DOM parser.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) throws XPathExpressionException {
        String xml = args[0];
        String xsd = args[1];

        // load XML file into "document"
        loadDocument(xml);

        if (validateDocument(xsd)) {
            // print staff.xml using DOM methods and XPath queries
            printNodes();

            NodeList result = query("menu/item/name | menu/item/price");
            String[][] combo = new String[2][2];
            for (int i = 0; i < result.getLength()-1; i++) {
                Node currentChild = result.item(i);
                Node nextChild = result.item(i+1);
                if (i == 0) {
                    combo[i][0] = currentChild.getTextContent();
                    combo[i][1] = nextChild.getTextContent();
                } else if (i == 1) {
                    combo[i][0] = result.item(2).getTextContent();
                    combo[i][1] = result.item(3).getTextContent();
                }
            }
            System.out.printf("%-12s%-1s%-12s%-25.2f\n",combo[0][0]," + ",combo[1][0],Double.parseDouble(combo[0][1])+Double.parseDouble(combo[1][1]));
            System.out.println("Finished.");
        }
    }

    /**
     * Set global document by reading the given file.
     *
     * @param filename XML file to read
     */
    private static void loadDocument(String filename) {
        try {
            // create a document builder
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builder = builderFactory.newDocumentBuilder();

            // create an XPath expression
            XPathFactory xpathFactory = XPathFactory.newInstance();
            path = xpathFactory.newXPath();

            // parse the document for later searching
            document = builder.parse(new File(filename));
        } catch (Exception exception) {
            System.err.println("could not load document " + exception);
        }
    }

    /*-------------------------- DOM and XPath Methods -------------------------*/

    /**
     * Validate the document given a schema file
     *
     * @param filename XSD file to read
     */
    private static Boolean validateDocument(String filename) {
        try {
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(language);
            schema = factory.newSchema(new File(filename));
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(document));
            return true;
        } catch (SAXException | IOException e) {
            System.err.println(e.getLocalizedMessage());
            return false;
        }
    }

    /**
     * Print nodes using DOM methods and XPath queries.
     */
    private static void printNodes() {
        NodeList menu = document.getElementsByTagName("*");

        String name = menu.item(2).getNodeName();
        String price = menu.item(3).getNodeName();
        String description = menu.item(4).getNodeName();
        System.err.printf("%-25s%-25s%-25s\n",name,price,description);
        for (int i = 0; i < menu.getLength(); i++) {
            Node currentChild = menu.item(i);
            switch (currentChild.getNodeName()) {
                case "name", "price" -> System.out.printf("%-25s", currentChild.getTextContent());
                case "description" -> System.out.printf("%-25s\n", currentChild.getTextContent());
            }
        }
    }

    /**
     * Get result of XPath query.
     *
     * @param query XPath query
     * @return result of query
     */
    private static NodeList query(String query) throws XPathExpressionException {
        NodeList result = null;
        XPathExpression q = path.compile(query);
        try {
            result = (NodeList) q.evaluate(document,XPathConstants.NODESET);
//            System.out.printf("\nQuery %s is valid.\n",query);
        } catch (Exception exception) {
            System.err.println("could not perform query - " + exception);
        }
        return (result);
    }
}
