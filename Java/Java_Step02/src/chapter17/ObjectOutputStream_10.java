package chapter17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//직렬화 네트웤을 통해 바이너리로 형변환
class Person implements Serializable{
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [이름 =" + name + ", 나이 =" + age + "]";
	} 
	
	
	
}
public class ObjectOutputStream_10 {
	public static void main(String[] args) throws ClassNotFoundException {
		String filePath = "person.dat";
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
			Person person = new Person("솔데스크" , 15);
			oos.writeObject(person); //직렬화 필수 
			System.out.println("객체가 성공적으로 저장되었습니다. ");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
			Person person = (Person)ois.readObject();
			System.out.println("객체가 성공적으로 읽었습니다. " + person);
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
