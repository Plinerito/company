package telran.objects;

import java.util.*;
// разница между record и class
import java.io.*;
// чтобы весь список полоэить в файл
public class CreationPointsAppl {

	public static void main(String[] args) throws Exception {
		List<Point> points = new ArrayList<>();
        points.add(new Point(3,4));
        points.add(new Point(5,6));
        points.add(new Point(7,8));
        try(ObjectOutputStream output = 
        		new ObjectOutputStream(new FileOutputStream("points.data"))){
            output.writeObject(points);
	}
        System.out.println(points);
        }
	}
/*
 * список кладём в файл, а потом его восстанавливаем
 * это стрим у которого есть методы сериализации и дисерилизации
 * он серилизует любой сложности объект но только главное чтобы они имплементировались 
 * сериализуются для сохранения
 * дисерилизуются для восстановления
 * ObjectOutputStream(new FileOutputStream("points.data") -
 * Первое связывается с вторым и называют его любым именем с любым расширением
 * в мейне указываем throws exception, чтобы обрабатывать и чтобы они выходили на экран 
 * помещаю в файл writeObjects весь список
 * 
 * 
 * 
 */

