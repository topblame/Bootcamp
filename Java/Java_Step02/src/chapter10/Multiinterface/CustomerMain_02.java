package chapter10.Multiinterface;

public class CustomerMain_02 {
	public static void main(String[] args) {
		Customer customer = new Customer();
		System.out.println("---------Buy----------");
		
		Buy buyer = customer;
		buyer.buy();
		buyer.order();
		
		System.out.println("------------Sell-------------");
		Sell seller = customer;
		seller.sell();
		seller.order(); //최종적으로는 override 된 메서드.
		seller.sellorder();
		
		//seller 부모  customer - 자식 / 이 맞는지. 
		if(seller instanceof Customer) {
			Customer customer2 = (Customer)seller;
			customer2.buy();
			customer2.sell();
			customer.sellorder();
		} //if
	}
}
