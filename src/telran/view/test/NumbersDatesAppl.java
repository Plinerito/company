package telran.view.test;
import telran.view.*;
public class NumbersDatesAppl {

	public static void main(String[] args) {
		InputOutput io = new StandardInputOutput();
		Menu menu = new Menu(new Item[] {NumbersMenu.getMenu(),
				DatesMenu.getMenu(),
				Item.exit()},
				"Numbers-Dates-Operations");
		menu.perform(io);
		

	}

}