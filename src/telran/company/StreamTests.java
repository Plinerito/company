package telran.company;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.*;
class StreamTests {

	int[] arr = {10,13,8,7,3,5,6} ;
	@Test
	@Disabled
	void arrayStreamTest() {
		// computing sum of the even numbers
		int[] arr = {10,13,8,7,3,5,6} ;
		assertEquals(24,Arrays.stream(arr)
				.filter(n -> n % 2 == 0)
				.sum());
        assertEquals(13, Arrays.stream(arr)
        		.filter(n -> n % 2 != 0)
        		.max().getAsInt());     // create from optional in int. для решения неоднозначности пустого множества
        assertEquals(13, Arrays.stream(arr)
        		.filter(n -> n % 2 != 0)
        		.max().orElse(0));
        assertEquals(0, Arrays.stream(arr)
        		.filter(n -> n % 2 != 0)
        		.max().orElse(0));
	}
	

//	  public static void loopListJava8() {                 ПРИМЕР FOREACH ДЛЯ JAVA8
//
//	      List<String> list = new ArrayList<>();
//	      list.add("A");
//	      list.add("B");
//	      list.add("C");
//	      list.add("D");
//	      list.add("E");
//
//	      // lambda
//	      // list.forEach(x -> System.out.println(x));
//
//	      // method reference
//	      list.forEach(System.out::println);  A,B,C,D,E
//	  }

	
	@Test
	@Disabled
	void displaySportloto() {
		Random gen = new Random();
		gen.ints(1,50)
		.distinct().limit(7)  // distinct - убирает повторяющиеся числа. limit - задаёт ограничение, сколько подаётся на вход
		.forEach(n -> System.out.print(n + " "));
	}
	
	@Test
	@Disabled
	void evenOddGrouping() {                                                 // как из примитива получить объект Integer
		Map<String, List<Integer>> mapOddEven = Arrays.stream(arr).boxed()   // открываем stream, что запустить наш массив arr
				                                                              //в map нельзя работать с примитивыми
		.collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd" ) ); // boxed - обёрточный класс, который работает с int, long, float
         System.out.println(mapOddEven);
	}
	
//	Проще говоря, метод .boxed() помещает каждое значение в потоке в соответствующий класс-обертку.
//
//	IntStream.boxed() – Integer
//	LongStream.boxed() – Long
//	DoubleStream.boxed() – Double
//  Мы не можем построить map из примитивов из-за этого проводим через boxed. Позволяет преобразовать примитив int в Integer
//  collect - это тип конечной операции, который позволяет из потока объекта получить что-то одно	
//  Collectors - который обладает функциональности из много получить что-то одно
//  groipingBy - задаём критерий группировки. представляет некую функцию, преобразующий на входе какой то элемент потока, а на выходе значение
//  n - integer. even/odd - значение. 
//  n % 2 == 0 ? - условный тренарный оператор. внутри if/else если левые части одинаковые, а правые разные
//  то делается условный тренарный оператор, только тогда использовать. 
//	если условие истинное, то возращается значение до двоеточия, если ложь, то после двоеточия
//  Ключ - строка: even или odd. Value - список чисел(Лист), которые подходят в каждую группу. Int не может быть в листе, только Integer
	@Test
    @Disabled
    void displayOccurenceSorted() {
	   String[] strings = {"lpm","y","a", "lpm", "aa", "yy", "yy", "aa", "lpm"};
	   Map<String, Long> occurrencesMap = Arrays.stream(strings)
			   .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
	   occurrencesMap.entrySet().stream()
	   .sorted((e1,e2) -> {
		   int res = Long.compare(e2.getValue(), e1.getValue());
		   if (res == 0) {
			   res = e1.getKey().compareTo(e2.getKey());
		   }
		   return res;
	   })
	   .forEach(e -> System.out.printf("%s => %d\n", e.getKey(), e.getValue()));
	   
	      }
// Должны распечатать кол-во повторений каждой строки в отстортированном порядке. Критерий сортировки такой, сначала печатаются строки 
// с большой частотой повторяемостью, потом с меньшой частотой. Если между двумя строками одна и та же частота повторяемости,
// то печатаются строки в алфавитном порядке
// String [] - массив строк. String - название строки   , Long - сколько раз повторяется.
// stream(Strings) - получаем название строк. 
// делаем группировку по строке 
// groupingBy, которая принимает два параметра(s -> s) : критерий группировки, а второй параметр - коллектор, который делает конкретно одно значение 
// groupingBy create: yy = {yy,yy}, aa = {aa,aa}, a = {a}, lpm = {lpm,lpm,lpm}, y = {y}
// s -> s - строка, и эту строку мы возращаем
// collect(Collectors.groupingBy(s -> s, Collectors.counting())) create: yy = 2, aa = 2, a = 1, lpm = 3, y = 1 
// counting - означает, что он даст число повторений вместо списка
// Map - это не коллеция, она имеет EntrySet - возвращает сет вхождения, ключ и значения. У сета есть метод stream. 
// sorted(e1,e2) - сортирующий компаратор. e1,e2 - это entry, имеющие ключ и значения
// (e2.getValue(), e1.getValue()); = сравниваю сначала(в обратном порядке) по частоте встречаемости
// если результат 0, то та же частота встречаемости, потому что компеир возращает 0,
// если значения равны. если value равны, это значит равны частоты встречаемости, то сортируй в алфавитном порядке строк
// get.Key - это строка
// e1.getKey().compareTo(e2.getKey()); - говорит, что мы сраниваем по строкам 
// output: 
/*
 *  lpm = > 3
 *  aa => 2
 *  yy => 2
 *  a => 1 
 *  y => 1 
 */ 
	
    
	 @Test 
	 
	 void stringStream() {
		 String string = "Hello"; 
		 // output: h,e,l,l,o    1 # способ
		 // string.chars().forEach(c -> System.out.printf("%c,", c));
		 string.chars().mapToObj(c -> "" + (char)c) // conversion to Stream<String>
		 .forEach(s -> System.out.print(s + ","));
		 
		 
// 	chars - он возращает и разбивает слово на числа из таблицы аски IntStream, стрим чисел возращает из таблицы аски. printf и %c преобразуют в буквы	    
//  mapToObj - сделать преобразование из IntStreama в Stream строк. Позволит из стримма примитива преобразовать в Стрим Объектов
//  string.chars() - стринг примитивов. 
//  надо сделать кастинг на (char) c, чтобы не было кода аски, будет строка, которая будет содержать именно символ
	 }
	 @Test
	 void splittingStringArray() {
		 String [] strings = {"Hello", "World"};
		 //output: H,e,l,l,o,W,o,r,l,d
		 Arrays.stream(strings).flatMapToInt(str -> str.chars())
		 .mapToObj(c -> "" + (char)c) // conversion to Stream<String>
		 .forEach(s -> System.out.print(s + ","));
	 }
// flatMapToInt - что-то одно разбивается на много. То есть число разобьётся на одтельные цифры 	
// потому что у нас будет результат не стрим строк, а стрим интежер
// str -> str.chars()) - я получаю одну строку, а на выходе будем стрим
}

