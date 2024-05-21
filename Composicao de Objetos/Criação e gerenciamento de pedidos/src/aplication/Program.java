package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.net.ssl.SSLEngineResult.Status;

import entites.Client;
import entites.Order;
import entites.OrderItem;
import entites.Product;
import entities_enum.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("ENTER CLIENT DATA:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		
		Order order = new Order(new Date(), status, client);
		System.out.println();
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
				System.out.println("Enter #"+(i+1)+" item data: ");
				System.out.print("Product name: ");
				sc.nextLine();
				String productName = sc.nextLine();
				System.out.print("Product price: ");
				double price = sc.nextDouble();
				
				Product product = new Product(productName, price);
				
				System.out.print("Quantity: ");
				int quantity = sc.nextInt();
				System.out.println("");
				OrderItem orderItem = new OrderItem(quantity, price, product);
				order.addItem(orderItem);
	
		}
			
		System.out.println();
		System.out.println(order);
	
	}

}
