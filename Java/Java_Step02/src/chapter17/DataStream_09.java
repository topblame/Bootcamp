package chapter17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream_09 {
	public static void main(String[] args) {
		String filePath = "datastream_output.dat";
		
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
			dos.writeUTF("Hello DataOutputStream");
			dos.writeInt(123);
			dos.writeDouble(455.67);
			System.out.println("데이터가 성공적으로 파일에 저장되었습니다");
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
			String message = dis.readUTF();
			int number = dis.readInt();
			double decimal = dis.readDouble();
			System.out.println("읽은 데이터");
			System.out.println("message " + message);
			System.out.println("number "+ number );
			System.out.println("decimal " + decimal);
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
