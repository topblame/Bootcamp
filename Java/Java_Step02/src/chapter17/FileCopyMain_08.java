package chapter17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyMain_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sourceFilePath = "source01.txt";
		//버퍼없이 복사할 파일
		String destFilePathWithoutBuffer = "dest_without_buffer.txt";
		String destFilePathWithBuffer = "dest_with_buffer.txt";
		
		//원본 파일 생성코드(10mb의 데이터생성)
		createTestFile(sourceFilePath, 1024*1024*10); // 10MB
		
		//버퍼를 사용하지 않고 파일 복사
		long startTime = System.nanoTime();
		copyWithoutBuffer(sourceFilePath, destFilePathWithoutBuffer);
		long endTime = System.nanoTime();
		long durationWithOutBuffer = endTime - startTime;
		System.out.println("버퍼 사용하지않고 복사시 소요시간 "+ durationWithOutBuffer);
		//버퍼를 사용하여 복사
		startTime = System.nanoTime();
		copyWithBuffer(sourceFilePath, destFilePathWithBuffer);
		endTime = System.nanoTime();
		long durationWithBuffer = endTime - startTime;
		System.out.println("버퍼 사용하고 복사시 소요시간 " + durationWithBuffer);
	}
	
	public static void createTestFile(String filePath, int sizeInByte) {
		try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
			
			byte[] data = new byte[sizeInByte];
			bos.write(data);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("파일생성중 오류발생: " + e.getMessage());
		}
	}
	//buffer 사용하여 복사
	public static void copyWithBuffer(String source, String dest) {
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

				// BufferedInputStream 사용시 용량지정 가능
				byte[] buffer = new byte[1024]; // 1KB 버퍼
				int bytesData;
				// 원본 파일에서 데이터를 읽어 복사 파일에 쓰기
				while ((bytesData = bis.read(buffer)) != -1) {
					bos.write(buffer, 0, bytesData);
				}
				System.out.println("파일이 성공적으로 복사되었습니다.");
			} catch (Exception e) {
				System.err.println("파일 복사 중" + e.getMessage());
			}
			

	}//copyWithBuffer
	public static void copyWithoutBuffer(String source, String dest) {
		try(FileInputStream fis = new FileInputStream(source); 
				FileOutputStream fos = new FileOutputStream(dest)) {
			byte[] buffer = new byte[1024]; // 1KB 버퍼
			int bytesData;
			// 원본 파일에서 데이터를 읽어 복사 파일에 쓰기
			while ((bytesData = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, bytesData);
			}
			System.out.println("파일이 성공적으로 복사되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("파일 복사 중" + e.getMessage());
		}
		
	}//copyWithoutBuffer
		
		
}
