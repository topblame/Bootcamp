package kr.soldesk;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class DownloadBroker implements Runnable{
	private String address;
	private String fileName;
	
	public DownloadBroker(String address, String fileName) {
		this.address = address;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			URL url = new URL(address);
			InputStream is = url.openStream();
			BufferedInputStream input = new BufferedInputStream(is);
			
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int data;
			while((data = input.read())!= -1) {
				bos.write(data);
			}
			bos.close();
			input.close();
			
			System.out.println("download complete");
			System.out.println(fileName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
}
