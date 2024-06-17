
import java.io.InputStream;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class BGGeekXMLReader {

    public static Set<SimpleBoardGame> read(InputStream in) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            Set<SimpleBoardGame> games = new HashSet<>();
            BGGeekXMLHandler handler = new BGGeekXMLHandler(games);
            saxParser.parse(in, handler);

            return games;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Set.of();// return the empty set
    }

    public static SimpleBoardGame buildRecordFromMap(Map<String, String> map) {
        String name = map.getOrDefault("name", "Unknown"); // returns a default value
        String thumbnail = map.getOrDefault("thumbnail", "");
        String description = map.getOrDefault("description", "");
        int yearPublished = Integer.parseInt(map.getOrDefault("yearPublished", "0"));
        return new SimpleBoardGame(name, thumbnail, description, yearPublished);
    }

    static class BGGeekXMLHandler extends DefaultHandler {
        Set<SimpleBoardGame> games;
        Map<String, String> current;
        StringBuffer buffer = new StringBuffer();

        BGGeekXMLHandler(Set<SimpleBoardGame> games) {
            this.games = games;
        }

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) {
            buffer.setLength(0); // reset the buffer
            if (qName.equalsIgnoreCase("item")) {
                String type = attributes.getValue("type"); // since the xml is focused on attributes
                if (type.equals("boardgame")) {
                    current = new HashMap<>();
                }
            } else if (qName.equalsIgnoreCase("name")) {
                    String isPrimary = attributes.getValue("type");
                    if (isPrimary != null && isPrimary.equals("primary")) {
                        String name = attributes.getValue("value");
                        current.put("name", name);
                    }
            } else if (qName.equalsIgnoreCase("yearPublished")) { // add yearPublished
                String isPrimary = attributes.getValue("type");
                if (isPrimary == null) {
                    String yearPublished = "0";
                } else if (isPrimary.equals("primary")) {
                    String yearPublished = attributes.getValue("value");
                    current.put("yearPublished", yearPublished);
                }
            }
            // } else if (qName.equalsIgnoreCase("description")) { // add description
            //     String isPrimary = attributes.getValue("type");
            //     if (isPrimary.equals("primary")) {
            //         String description = attributes.getValue("value");
            //         current.put("description", description);
            //     }
            // } else if (qName.equalsIgnoreCase("thumbnail")) { // add thumbnail
            //     String isPrimary = attributes.getValue("type");
            //     if (isPrimary.equals("primary")) {
            //         String thumbnail = attributes.getValue("value");
            //         current.put("thumbnail", thumbnail);
            //     }
            // }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equalsIgnoreCase("item")) {
                games.add(buildRecordFromMap(current));
                current = null;
            // add an else that handles description and thumbnail
            } else {
                if (current != null) {
                    current.put(qName, buffer.toString()); //add the rest of the data of the game
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            buffer.append(ch, start, length);
        }

    }

}
