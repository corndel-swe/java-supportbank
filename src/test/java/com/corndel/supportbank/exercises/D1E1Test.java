package com.corndel.supportbank.exercises;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class D1E1Test {

  @Test
  public void testPicocliDependency() throws Exception {
    File pomFile = new File("pom.xml");
    assertTrue(pomFile.exists(), "pom.xml file does not exist");

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(pomFile);

    NodeList dependencies = doc.getElementsByTagName("dependency");
    boolean foundPicocli = false;

    for (int i = 0; i < dependencies.getLength(); i++) {
      NodeList childNodes = dependencies.item(i).getChildNodes();
      String groupId = "";
      String artifactId = "";

      for (int j = 0; j < childNodes.getLength(); j++) {
        if ("groupId".equals(childNodes.item(j).getNodeName())) {
          groupId = childNodes.item(j).getTextContent();
        }
        if ("artifactId".equals(childNodes.item(j).getNodeName())) {
          artifactId = childNodes.item(j).getTextContent();
        }
      }

      if ("info.picocli".equals(groupId) && "picocli".equals(artifactId)) {
        foundPicocli = true;
        break;
      }
    }

    assertTrue(foundPicocli, "The picocli dependency is not found in pom.xml");
  }
}
