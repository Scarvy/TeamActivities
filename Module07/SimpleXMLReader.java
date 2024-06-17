import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class SimpleXMLReader {
    /**
     * Reads xml file
     * @param filePath
     */
    public void read(String filePath) {
        try {
            File inputFile = new File(filePath);                        // create new file path
            SAXParserFactory factory = SAXParserFactory.newInstance();  // create an instance of SAXParserFactory 
            SAXParser saxParser = factory.newSAXParser();               // create a SAXParser object

            List<Person> people = new ArrayList<>();                    // create new ArrayList
            SimpleXMLHandler handler = new SimpleXMLHandler(people);    // create XML handler: handles list of "people"
            saxParser.parse(inputFile, handler);                        // parse information

            System.out.println(people);                                 // print list
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SimpleXMLHandler extends DefaultHandler {              // extent DefaultHandler, also used in line 19
        List<Person> people;
        Map<String, String> current;
        StringBuffer buffer = new StringBuffer();                       // like a String but content and length can be modified

        SimpleXMLHandler(List<Person> people) {
            this.people = people;
        }


        @Override // overriding method from DefaultHandler class
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) {
            buffer.setLength(0);                              // reset the buffer
            if (qName.equalsIgnoreCase("person")) {
                current = new HashMap<>();                              // creates a hashmap of a person and store in "current"
            }
        }

        @Override // overriding method from DefaultHandler class
        public void endElement(String uri, String localName, String qName) {
            // student to add
            if (qName.equalsIgnoreCase("person")) {
                people.add(Person.fromMap(current));                    // add current(name) to people(list) 
                current = null;
            } else {
                if (current != null) {
                    current.put(qName, buffer.toString());              // add the rest of the data to the person
                }
            }

        }

        @Override // overriding method from DefaultHandler class
        public void characters(char[] ch, int start, int length) {      //  add the contents of char[] ch to the buffer
            buffer.append(ch, start, length);
        }

    }

    public static void main(String[] args) {
        SimpleXMLReader reader = new SimpleXMLReader();
        reader.read("simple.xml");
        // output: [Person[name=John Doe, age=29, city=New York], Person[name=Jane Smith, age=32, city=Los Angeles]]
    }
}
