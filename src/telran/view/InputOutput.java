package telran.view;

import java.util.function.Function;

public interface InputOutput {
   String readString(String prompt);
   void write(String str);
   default void writeLine(String str) {         // дефолт говорит, что можно писать метод в интерфейсе. это общая имплементация во всех классах
	   write(str + "\n" );
	   
   }
   default <T>  T readObject(String prompt, String errorPrompt, Function<String, T> mapper ) {          // <T> - параметризация. Из строки получаю объект.
	   boolean running = false;
	   T res = null;
	   do { 
		   running = false;
		   try {
		       String str = readString(prompt);
		       res = mapper.apply(str);    // из строки в объект через apply. функ.интерфейс 
		       
		       
	} catch (Exception e) {
		running = true;  
		writeLine(errorPrompt + ":" + e.getMessage());                                                     // если не зашли в кэтч, то выйдем из цикла
	}
		   
	   } while(running);          // предпологает цикл, 
	   return res;
   }
}
