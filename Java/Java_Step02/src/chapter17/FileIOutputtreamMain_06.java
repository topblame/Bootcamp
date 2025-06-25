package chapter17;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOutputtreamMain_06 {

	public static void main(String[] args) {
		String filePath = "outputStream.txt";
		String data = "Hello, this is a test of FileOutputStream";
		
		try (FileOutputStream fos = new FileOutputStream(filePath)){
			fos.write(data.getBytes());
			System.out.println("파일이 성공적으로 저장되었습니다.");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("파일쓰던 도중 오류 발생 " + e.getMessage());
		}
	}

}
