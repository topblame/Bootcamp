package chapter12.string;
class Book{
	String title;
	String author;
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return title + ", " + author;
	}
	
	
	
}
public class ToStringMain_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book = new Book("1984", "조지오웰");
		
		System.out.println(book);
		System.out.println(book.title);
		System.out.println(book.author);
		System.out.println();
		System.out.println(book.toString());
		
		
	}

}
