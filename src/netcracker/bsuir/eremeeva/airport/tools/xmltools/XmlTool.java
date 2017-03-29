package netcracker.bsuir.eremeeva.airport.tools.xmltools;


import netcracker.bsuir.eremeeva.airport.entities.Airline;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class XmlTool {

    public static void addAirlineToXml(String pathToFile, Airline airlineObject)
            throws TransformerException, IOException, ParserConfigurationException, SAXException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        org.w3c.dom.Document document = documentBuilder.parse(pathToFile);

        Node root = document.getDocumentElement();

        Element airline = document.createElement("Airline");

        Element airlineName = document.createElement("Name");
        airlineName.setTextContent(airlineObject.getName());
        Element year = document.createElement("Year");
        year.setTextContent(Integer.toString(airlineObject.getFoundationYear()));
        Element code = document.createElement("Code");
        code.setTextContent(airlineObject.getCodeICAO());
        Element address = document.createElement("Address");
        address.setTextContent(airlineObject.getAddress());

        airline.appendChild(airlineName);
        airline.appendChild(year);
        airline.appendChild(code);
        airline.appendChild(address);

        root.appendChild(airline);

        wrightDocument(document, pathToFile);
    }

    // Сохранение DOM в файл
    public static void  wrightDocument(Document document, String passToFile) throws TransformerException, FileNotFoundException {

        // An instance of this abstract class can transform a source tree into a result tree.
        //A TransformerFactory instance can be used to create Transformer and Templates objects.
        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        //Acts as a holder for a transformation Source tree in the form of a Document Object Model (DOM) tree.
        DOMSource source = new DOMSource(document);

        FileOutputStream fileOutputStream = new FileOutputStream(passToFile);

        // Acts as an holder for a transformation result, which may be XML, plain Text, HTML, or some other form of markup.
        // Construct a StreamResult from a File.
        StreamResult result = new StreamResult(fileOutputStream);

        transformer.transform(source, result);
    }

    public static void loadEntityFromXml(String pathToFile)
            throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(pathToFile);

        Node root = document.getDocumentElement();

        NodeList entityies = root.getChildNodes();

        for (int i = 0; i < entityies.getLength(); i++) {
            Node entity = entityies.item(i);
            if (entity.getNodeType() != Node.TEXT_NODE) {
                NodeList entityProperties = entity.getChildNodes();
                for (int j = 0; j < entityProperties.getLength(); j++) {
                    Node entityProperty = entityProperties.item(j);
                    if (entityProperty.getNodeType() != Node.TEXT_NODE) {
                        System.out.println(entityProperty.getNodeName() + ":" + entityProperty.getChildNodes().item(0).getTextContent());
                    }
                }

            }
        }
    }
}
