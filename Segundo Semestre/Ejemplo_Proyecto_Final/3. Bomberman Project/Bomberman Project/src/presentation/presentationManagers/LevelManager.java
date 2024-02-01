package presentation.presentationManagers;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public final class LevelManager {
    public static final String xmlLevels = "resources/config/levels.xml";
    public static String level0, level1, level2, level3;

    static {
        parseLevels();
    }
    private LevelManager() {
    }

    public static void parseLevels() {
        try {
            File xmlInputFile = new File(xmlLevels);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document docL = dBuilder.parse(xmlInputFile);
            docL.getDocumentElement().normalize();
            level0 = docL.getElementsByTagName("level0").item(0).getTextContent();
            level1 = docL.getElementsByTagName("level1").item(0).getTextContent();
            level2 = docL.getElementsByTagName("level2").item(0).getTextContent();
            level3 = docL.getElementsByTagName("level3").item(0).getTextContent();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
