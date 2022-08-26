package com.eidiko.niranjana.controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	//===========================================
			@GetMapping("/readfile")
			public String ReadFile()
			{
				String output=null;
				try {
					Scanner scn = new  Scanner(new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Eidiko\\data.txt"));
					while(scn.hasNextLine())
					{
						 output = scn.nextLine();				
					}
				}
				catch(FileNotFoundException fe)
				{
					fe.printStackTrace();
				}
				return output;
			}
//===============================================================		
//			@PostMapping("/writefile")
//			public void WriteFile( @RequestBody Employee emp)
//			{					
//				try {
//	            FileWriter f1 = new FileWriter("C://Users//Administrator//Downloads//test1.txt");
//	           f1.write(emp.toString());
//	           // f1.write(new ObjectMapper().writeValueAsString(emp));
//	            f1.close();
//				}
//				catch(Exception  fe)
//				{
//					fe.printStackTrace();
//				}
//			}
////===========================================
//			@PostMapping("/excelData")
//			public void DataInsertIntoExcel( @RequestBody Excel xls)
//			{					
//				//here we create empty workbook
//		        XSSFWorkbook workbook = new XSSFWorkbook();     
//		      //Create a blank sheet
//		        XSSFSheet sheet = workbook.createSheet( "Sheet1");
//		        //Create row object
//		        XSSFRow rowhead = sheet.createRow(0);
//		        rowhead.createCell(0).setCellValue("EmpId");
//			    rowhead.createCell(1).setCellValue("EmpName");
//			    rowhead.createCell(2).setCellValue("EmpRole");
//			     rowhead.createCell(3).setCellValue("EmpSalary");
//			     rowhead.createCell(4).setCellValue("EmpCity");
//			     rowhead.createCell(5).setCellValue("EmpContact");
//		       XSSFRow rowhead1 = sheet.createRow(1);
//		       rowhead1.createCell(0).setCellValue(xls.getEmpId());
//		       rowhead1.createCell(1).setCellValue(xls.getEmpName());
//		       rowhead1.createCell(2).setCellValue(xls.getEmpRole());
//		       rowhead1.createCell(3).setCellValue(xls.getEmpSalary());
//		       rowhead1.createCell(4).setCellValue(xls.getEmpCity());
//		       rowhead1.createCell(5).setCellValue(xls.getEmpContact());
//		   
//		       try {
//		       File f1 = new File("C:\\Users\\Administrator\\eclipse-workspace\\Niranjana_WorkSpace\\SpBoot_WebConcept\\src\\main\\java\\com\\eidiko\\SpBoot_WebConcept\\xls\\TestData.xls");
//				FileOutputStream fos = new FileOutputStream(f1);
//			        workbook.write(fos);
//			        fos.close();
//		       }
//		       catch(Exception e)
//		       {
//		    	   e.printStackTrace();
//		       }
//		       System.out.println("ok...Done");
//			}
}
