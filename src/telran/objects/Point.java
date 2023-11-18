package telran.objects;

import java.io.Serializable;
/*
 *  значительно сокращение кода, если выбрать рекорд, а не класс
 * 
 * 
 * 
 * 
 */


public record Point(int x, int y) implements Serializable {

}
