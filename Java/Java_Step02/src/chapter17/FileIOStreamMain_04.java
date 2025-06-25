package chapter17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStreamMain_04 {

	public static void main(String[] args) {
		//FileIOSTREAM : 1byte -> 인코딩("UTF -8")
		//FILEINPUTSREAM(바이트 단위로 읽기), FILEOUTPUTSTREAM(바이트 단위로 쓰기)
		//이미지,오디오,영상등의 파일을 바이너리 코드로 변환하여 입력 또는 출력
		
		String data = "Hello, this is a test of" + "FileInputStream and FileOutputStream";
		String filePath = "IOStream.txt";
		
		//FileOutputStream을 사용하여 파일에 데이터 저장
		try(FileOutputStream fos = new FileOutputStream(filePath)) {
			fos.write(data.getBytes()); //1byte로 쓰므로 인코딩이 필요
			System.out.println("파일에 데이터가 입력되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//------------------
		//FileInputStream을 이용하여 파일에서 데이터 읽기
		try (FileInputStream fis = new FileInputStream(filePath)){
			int content;
			System.out.println("파일 데이터 ");
			while((content = fis.read()) != -1) {
				System.out.print((char)content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
