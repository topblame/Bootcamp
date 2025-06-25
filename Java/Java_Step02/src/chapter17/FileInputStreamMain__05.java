package chapter17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamMain__05 {

	public static void main(String[] args) {
		String filePath = "outputStream.txt";

		
		try (FileInputStream fis = new FileInputStream(filePath)){
			int byteData;
			
			System.out.println("file 내용: " );
			while((byteData =fis.read())!= -1) {
				System.out.print((char)(byteData));
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("파일쓰던 도중 오류 발생 " + e.getMessage());
		}
	}

}
