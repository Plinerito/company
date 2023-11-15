package telran.objects;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class RestorePointsAppl {
    public static void main(String[] args ) throws Exception {
		List<Point> points = null;
		try (ObjectInputStream input = 
				new ObjectInputStream(new FileInputStream("points.data"))) {
			points = (List<Point>) input.readObject();
		}
		System.out.println(points);
	}
}
