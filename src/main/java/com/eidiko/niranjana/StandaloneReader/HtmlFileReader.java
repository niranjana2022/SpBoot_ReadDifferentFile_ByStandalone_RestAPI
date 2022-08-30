package com.eidiko.niranjana.StandaloneReader;  //jar: tagsoup-1.2.1.jar, commons-codec-1.15.jar   //working fine

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class HtmlFileReader {
   public static void main(String[] args) throws IOException,SAXException, TikaException {
	   Metadata metadata = new Metadata();
	   
      //detecting the file type
      BodyContentHandler handler = new BodyContentHandler();
      FileInputStream inputstream = new FileInputStream(new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\htmlExample.html"));
      ParseContext pcontext = new ParseContext();

      //Html parser
      HtmlParser htmlparser = new HtmlParser();
      htmlparser.parse(inputstream, handler,metadata,pcontext);
      
      System.out.println("Contents of the html document:");
      System.out.println( handler.toString());
      
      System.out.println("Metadata of the html document:");
      String[] metadataNames = metadata.names();
      for(String name : metadataNames) 
      {
         System.out.println(name + ":   " + metadata.get(name));
      }
      System.out.println("-----------------------");
    //================================Using StrtingBuilder class: (No jar required)==========================================
      StringBuilder sb = new StringBuilder();
      FileReader fr = new FileReader("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\htmlExample2.html");
      try {
    	  BufferedReader br = new BufferedReader(fr);
    	  String val;
    	  while((val=br.readLine())!=null)
    	  {
    		  sb.append(val);
    	  }
    	  br.close();
    	  String result = sb.toString();
    	  System.out.println("Xml content :"+result);
      }
      catch(Exception e)
      {
    	  System.out.println(e.getMessage());
      }
      System.out.println("......................................");
     //================Best approach: using URL class(No jar required)=======================================================================
   		// Try block to check exceptions
   		try {
   			String val;

   			// Constructing the URL connection
   			// by defining the URL constructors
   			URL URL = new URL("file:///C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\htmlExample2.html");

   			// Reading the HTML content from the .HTML File
   			BufferedReader br = new BufferedReader(new InputStreamReader(URL.openStream()));

   			/* Catching the string and if found any null character break the String */
   			while ((val = br.readLine()) != null) {
   				System.out.println(val);
   			}

   			// Closing the file
   			br.close();
   		}

   		// Catch block to handle exceptions
   		catch (Exception ex) {

   			// No file found
   			System.out.println(ex.getMessage());
   		}
   	}
}