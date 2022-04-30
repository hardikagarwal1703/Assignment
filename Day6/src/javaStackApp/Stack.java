package javaStackApp;
public interface Stack {
	public static final int STACK_SIZE = 5;
	public abstract void push(Customer customer);
	public abstract Customer pop();
	public abstract void showStack();
}