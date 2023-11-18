package telran.objects;

import java.io.FileInputStream;
import java.io.*;
import java.io.ObjectInputStream;
import java.util.List;
/*
 * List<Point> ponts = ничего не строю
 * восстанавливаем любой сложности объект
 * readObject - 
 * на какой-то сложной апликации строятся сложные объекты, поместили 
 * их в файл эту инфу, а потом в другой аплакции прочитали и восстановили этот сложный объект
 * 
 * 
 * 
 */
public class RestorePointsAppl {
    @SuppressWarnings("unchecked")
	public static void main(String[] args ) throws Exception {
		List<Point> points = null;
		try (ObjectInputStream input = 
				new ObjectInputStream(new FileInputStream("points.data"))) {
			points = (List<Point>) input.readObject();
		}
		System.out.println(points);
	}
}

