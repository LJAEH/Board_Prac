package prac.jh.common;

import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Scanner;

public class CreateXMLFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try { 
			Properties prop = new Properties();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("xml 파일 이름:");
			String fileName = sc.nextLine();
			
			FileOutputStream fos = new FileOutputStream(fileName+".xml");
			
			prop.storeToXML(fos,fileName + ".xml file");
			
			System.out.println("파일 생성 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
