package entites;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities_enum.OrderStatus;

public class Order {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	
	List <OrderItem> orderItem = new ArrayList<>();
	Client client = new Client();
	Product product = new Product();
	
	public Order() {}
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
		
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	
	public void addItem(OrderItem item) {
		orderItem.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderItem.remove(item);
	}
	
	public double total() {
		double total=0;
			for(OrderItem ord : orderItem) {
				total += ord.subTotal();
				}
		return total;
		}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order Moment: "+ sdf.format(getMoment())+"\n");
		sb.append("Order Status: "+getStatus()+"\n");
		sb.append("Client: "+getClient().getName() + " - " + getClient().getEmail()+"\n");
		sb.append("\n");
		sb.append("ORDER ITEMS:"+"\n");
			for(OrderItem ord : orderItem) {
				sb.append(ord+"\n");
			}
		sb.append(String.format("Total price: $ %.2f", total()));
		return sb.toString();
	}
	
	
	
}
