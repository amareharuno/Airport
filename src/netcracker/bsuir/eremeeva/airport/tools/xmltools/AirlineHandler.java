package netcracker.bsuir.eremeeva.airport.tools.xmltools;

import netcracker.bsuir.eremeeva.airport.entities.Airline;
import netcracker.bsuir.eremeeva.airport.enums.AirlineParamEnum;
import org.xml.sax.*;

import java.util.ArrayList;

public class AirlineHandler implements ContentHandler {

    private ArrayList<Airline> airlines = new ArrayList<>();
    private Airline current = null;
    private AirlineParamEnum currentEnum = null;

    public ArrayList<Airline> getAirlines() {
        return airlines;
    }

    @Override
    public void startDocument() throws SAXException {
        // System.out.println("Parsing started..");
    }

    @Override
    public void endDocument() throws SAXException {
        // System.out.println("Parsing done!\n");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("airline")) {
            current = new Airline();
            // String name, int foundationYear, String codeICAO, String address
            current.setCodeICAO(atts.getValue(0));
            // System.out.println("new airline created");
        }
        if (!"tns:airlines".equals(qName) && !"airline".equals(qName)) {
            currentEnum = AirlineParamEnum.valueOf(qName.toUpperCase());
            // System.out.println("Current enum: " + currentEnum);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("airline")) {
            airlines.add(current);
        }
        currentEnum = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String string = new String(ch, start, length).trim();
        if (currentEnum == null) { return; }
        switch (currentEnum) {
            case NAME:
                current.setName(string);
                break;
            case ADDRESS:
                current.setAddress(string);
                break;
            case YEAR:
                current.setFoundationYear(Integer.parseInt(string.trim()));
                break;
        }
    }

    // -------------------------------------------------------------------

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }
}
