package com.eidiko.niranjana.StandaloneReader;  //jar: poi-5.2.2.jar, poi-scratchpad-5.2.2.jar
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hwpf.HWPFDocument;

public class DocFileReader {
	
	public static void main(String args[]) throws IOException {
		FileInputStream fistream = new FileInputStream("C:\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\file-sample_500kB.doc");
		HWPFDocument document = new HWPFDocument(fistream);
		System.out.println("Length of docment is :"+ document.characterLength());
		System.out.println(document.getText());
		System.out.println(document.getDocumentText());
	}
}