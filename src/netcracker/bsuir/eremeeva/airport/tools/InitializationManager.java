package netcracker.bsuir.eremeeva.airport.tools;

import netcracker.bsuir.eremeeva.airport.tools.entitiesTools.ConstantStrings;
import org.xml.sax.SAXException;
import netcracker.bsuir.eremeeva.airport.tools.xmltools.Parser;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import java.io.IOException;

public class InitializationManager {

    public static void initialize() {
        try {
            System.out.println("Иниацилизация сущностей...\n");
            Parser.parseAirlineXml("src\\" +
                    "netcracker\\bsuir\\eremeeva\\airport\\files\\Airlines.xml");
            // System.out.println("Готово!\n");

        } catch (SAXNotRecognizedException e) {
            System.out.println("Идентификатор не распознан"); // в лог
            System.out.println(ConstantStrings.NO_INIT_DATA);
        } catch (SAXNotSupportedException e) {
            System.out.println("Неподдерживаемая операция"); // в лог
            System.out.println(ConstantStrings.NO_INIT_DATA);
        } catch (SAXException exception) {
            //exception.printStackTrace();
            System.out.println("Глобальная SAXException"); // в лог
            System.out.println(ConstantStrings.NO_INIT_DATA);
        } catch (IOException exception) {
            System.out.println("IOException"); // в лог
            //exception.printStackTrace();
            System.out.println(ConstantStrings.NO_INIT_DATA);
        }
    }
}
