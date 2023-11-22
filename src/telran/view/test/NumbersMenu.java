package telran.view.test;
import telran.view.*;
import static telran.view.Item.*;
public class NumbersMenu {
	public static Item getMenu() {
		Menu menu = new Menu(getItems(), "Arithmetic Operations");
		return menu;
	}

	private static Item[] getItems() {
		
		return ArithmeticSimpleCalculatorAppl.getItems();
	}
}