package javaStackApp;
public class GrowableStack extends FixedStack{
	@Override
	public void push(Customer customer) {
		if(this.top == (customers.length-1)) {
			Customer[] temp = new Customer[customers.length * 2];
			for(int i=0;i<customers.length;i++) {
				temp[i] = customers[i];
			}
			customers = temp;
		}
		this.customers[++this.top] = customer;
	}
}