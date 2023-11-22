package telran.view.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import telran.view.*;
record Point(int x, int y) {  // на входе строка, на выходе point
	
}
class InputOutputTest {
InputOutput io = new StandardInputOutput();
	@Test
	@Disabled
	void readPointTest() {
		Point point =  io.readObject("enter coordinates of point; usage <x>#<y>", "Wrong coordinates", str -> {
			String [] xy = str.split("#");
			if (xy.length != 2) {
				throw new RuntimeException("incorrect format of input");
			}
			int x = Integer.parseInt(xy[0]);                                  // преобразует строку в число
			int y = Integer.parseInt(xy[1]);   
			return new Point(x, y);
					});
		io.writeLine(point.x() + point.y() );
	}
	
	
   @Test
   void readObjectInteger() {
	   Integer number = 
			   io.readObject("Enter number in range [100-200]", "wrong number", str -> {
				   int num = Integer.parseInt(str);
				   if (num < 100 || num > 200) {
					   throw new RuntimeException("must be in the range [100-200]");
				   }
				   return num;
			   });
	   io.writeLine(number / 2 + "");
   }
	
}
