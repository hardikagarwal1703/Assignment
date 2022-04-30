package javaStackApp;
public class FixedStack implements Stack{
	protected Customer[] customers;
	protected int top;

	public FixedStack() {
		this.customers = new Customer[Stack.STACK_SIZE];
		this.top = -1;
	}

	@Override
	public void push(Customer customer) {
		if(top == (Stack.STACK_SIZE-1)) {
			System.out.println("Stack Full Leading to Overflow!!");
			return;
		}
		this.customers[++this.top] = customer;	
	}

	@Override
	public Customer pop() {
		if(top == -1) {
			System.out.println("Empty stack!! can't remove");
			return null;
		}
		Customer custReturn = this.customers[this.top];
		this.customers[this.top--] = null;
		return custReturn;
	}

	@Override
	public void showStack() {
		if(top == -1) {
			System.out.println("\n\nStack is currentln empty top = -1\n\n");
			return;
		}
		for(Customer cust: customers) {
			if(cust != null)
				System.out.println(cust);
			else
				continue;
		}
	}
}