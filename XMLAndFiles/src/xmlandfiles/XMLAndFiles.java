/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlandfiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * XML, java logging, elements in folder
 *
 *
 * @author davide
 */
public class XMLAndFiles {
    
    private static final MyLogger lw = MyLogger.getInstance();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Document doc = readXML("/home/davide/NetBeansProjects/Java/XMLAndFiles/src/xmlandfiles/Test.xml");
        System.out.println("Info: " + doc.getDocumentURI());
        readParams(doc);
        ArrayList<String> itemsInFolder = getItemsInFolder("/home/davide");
        itemsInFolder.forEach(System.out::println);
        fileOperations();
        lw.getLogger().finest("All fine!");
    }
    
    private static Document readXML(String file) {
        
        Document xmlDocument = null;
        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            
            xmlDocument = docBuilder.parse(new File(file));
            xmlDocument.getDocumentElement().normalize();
            
            return xmlDocument;
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            lw.getLogger().severe("Exception!: " + ex);
        }
        return null;
    }
    
    private static void readParams(Document restrictedParams) {

        // get all the tags called "element"
        NodeList nList = restrictedParams.getElementsByTagName("element");
        // for each node in retrieved
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            // if the node is an element
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                // retrieve all its attributes
                Element el = (Element) node;
                String name = el.getAttribute("attribute");
                System.out.println("Attribute: " + name);
                // if there are child nodes
                if (node.hasChildNodes()) {

                    // now go through the child nodes --- Level 2
                    NodeList nListValues = node.getChildNodes();
                    for (int j = 0; j < nListValues.getLength(); j++) {
                        Node node2 = nListValues.item(j);
                        // if they are an element
                        if (node2.getNodeType() == Node.ELEMENT_NODE) {
                            Element e2 = (Element) node2;
                            // get content
                            String value = node2.getTextContent();
                            System.out.println("Value: " + value);
                        }
                    }
                }
            }
        }
        
    }
    
    private static ArrayList<String> getItemsInFolder(String folderPassed) {
        ArrayList<String> list = new ArrayList<>();
        File folder = new File(folderPassed);
        /*
        create a FilenameFilter, which will accept only names that contain .log
         */
        
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File file, String string) {
                if (string.contains(".log")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        /*
        create an array of File that contain all the file names containing .log
         */
        File[] listOfFiles = folder.listFiles(filter);
        Arrays.stream(listOfFiles).map(x -> x.getName()).map(y -> y.substring(0, y.lastIndexOf("."))).forEach(list::add);
        /*
        // for each one of them, remove the extention and add it to the local ArrayList
        for (File f : listOfFiles) {
            String name = f.getName();
            int pos = name.lastIndexOf(".");
            String nameElab = name.substring(0, pos);
            materials.add(nameElab);
        }
         */
        lw.getLogger().finer("List retrieved");
        return list;
    }
    
    private static void fileOperations() {
        Path path = Paths.get("/home/davide/test_text.txt");
        List<String> data = new ArrayList<>();
        
        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.defaultCharset())) {
            writer.write("Hello Davide!");
        } catch (IOException ex) {
            lw.getLogger().severe("Error while writing to the file! " + ex);
        }
        
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.lines().forEach(System.out::println);
        } catch (IOException ex) {
            lw.getLogger().severe("Exception while reading the file!" + ex);
        }
        
    }
    
}
