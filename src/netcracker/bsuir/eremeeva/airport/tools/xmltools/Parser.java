package netcracker.bsuir.eremeeva.airport.tools.xmltools;

import netcracker.bsuir.eremeeva.airport.entities.Airline;
import netcracker.bsuir.eremeeva.airport.tools.entitiesTools.AirlineManagementTool;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    public static void parseAirlineXml(String pathToFile) throws SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        AirlineHandler airlineHandler = new AirlineHandler();
        reader.setContentHandler(airlineHandler);
        reader.parse(pathToFile);

        ArrayList<Airline> airlines = airlineHandler.getAirlines();
        AirlineManagementTool.setAirlines(airlines);
    }
}
