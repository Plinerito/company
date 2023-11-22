package telran.view.test;

import telran.view.InputOutput;
import telran.view.Item;

public class AddNumbers implements Item {

	@Override
	public String displayName() {
		
		return "Add numbers";
	}

	@Override
	public void perform(InputOutput io) {
		double number1 = io.readDouble("Enter first number", "Wrong number");
		double number2 = io.readDouble("Enter second number", "Wrong number");
		io.writeLine(number1 + number2);
	}

	@Override
	public boolean isExit() {
		return false;
	}

}