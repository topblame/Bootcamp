package chapter17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyMain_07 {
	public static void main(String[] args) {
		String sourceFile = "IOStream.txt";
		String destFile = "copy.txt";
		
		//BufferedInputStream으로 읽어서 
		
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile)); //가져오기
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile))) // 복사
		{
			byte[] buffer = new byte[1024]; //1KB 버퍼
			//원본파일에서 데이터를 복사파일에 저장
			int bytesRead;
			while((bytesRead=bis.read(buffer))!= -1) {
				//1024kb 씩 0부터 시작해서 내용 복사 파일에 저장
				bos.write(buffer, 0, bytesRead);
			}
			System.out.println("파일이 성공적으로 저장되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("파일 복사중 오류발생 " + e.getMessage());
		}
	}
}
