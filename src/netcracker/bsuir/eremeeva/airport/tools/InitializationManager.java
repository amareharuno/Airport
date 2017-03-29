package netcracker.bsuir.eremeeva.airport.tools;

import org.xml.sax.SAXException;
import netcracker.bsuir.eremeeva.airport.tools.xmltools.Parser;

import java.io.IOException;

public class InitializationManager {

    public static void initialize() {
        try {
            Parser.parseAirlineXml("F:\\NetCracker\\projects\\AirportProject");
        }
        catch (SAXException exception) {
            System.out.println("SAXException");
        } catch (IOException exception) {
            System.out.println("IOException");
        }
    }
}
