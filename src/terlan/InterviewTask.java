package terlan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class InterviewTask {
	/**
	 * 
	 * @param ar array of integer numbers
	 * @param sum integer number
	 * @return true if the given array contains two numbers, the sum of which equals the given sum value
	 */
		public static boolean isSum2(int [] ar, int sum) {
		//TODO  should be done with O[N]
			Set <Integer> hashSet = new HashSet<>();
			for (int num : ar) {
			int complement = sum - num;
			if (hashSet.contains(complement)) 
			{
			return true;
			}
			hashSet.add(num);
			}
			return false;
	}
		
    /*
     *  №1 О[N]
     *      boolean running = true;
     *      HashSet<Integer> setHelper = new HashSet<>();
     *      int i = 0;
     *      while (i < ar.length && running) {        два условия выхода, 
     *      if (setHelper.contains(sum - ar[i])) {
     *      running = false;
     *      } else {
     *        setHelper.add(ar[i]);
     *        i++
     *      }
     *      }
     *      return !running
     *  №2  0[N*N]  
     */
      public static boolean isSum2N2(int [] ar, int sum) {
         int i = 0;
         int j = 0;
         boolean running = true;
         while(i < ar.length && running) {
             j = i - 1; 
             while(j >= 0 ) {
               if(ar[j] + ar[i] == sum) {
               running = false; 
               break;
             }
             j--;
           }
           i++;
        }
        return !running;
     }
           
           
           
      
     
		/**
		 * 
		 * @param ar array of integer numbers
		 * @return maximal positive number having negative number with the same absolute value
		 */
		public static int getMaxPositiveWithNegativeValue (int ar[]) {
			//TODO should be done with O[N]
//			int max = 0;
//	        
//			 for (int value : ar) 
//			    {
//			    	if (value < 0) // && value > max)
//			    	{
//			    		max = Math.abs(value);
//			    	}
//			    return max;
//			    }
//			return -1;
			HashSet<Integer> set = new HashSet<>();
			int l_buff;
			int l_res = -1;
			for (int num : ar) {
				l_buff = num;
				if(set.contains(-1 * l_buff))
				{
					if (Math.abs(l_buff) > l_res) {
						l_res = Math.abs(l_buff);
					}
				} else {
					set.add(l_buff);
				}
			}
			return l_res;
		}
		
		

		/**
		 * 
		 * @param strings - array of strings
		 * @return Map where key - string, value - number of occurrences in the array
		 */
		public static HashMap<String, Long> getMapOccurrences(String[] strings) {
			HashMap<String, Long> map = new HashMap(); 
			//map.merge(null, null, null)
			for (int i=0; i < strings.length; i++ ) 
			{
			
				map.merge(strings[i], 1l , (x, y) -> x + y);
			}
		
			
			//TODO should be done with complexity O[N]
			//Optionally, additional bonus if you apply the method "merge" of the interface Map
			//try to understand this method https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#merge-K-V-java.util.function.BiFunction- 
			//it uses Functional interface BiFunction
			return map;
		}
		public static boolean isAnagram(String string, String anagram) {
	        HashMap <Character,Integer> map = new HashMap();
	        HashMap <Character,Integer> map1 = new HashMap();
	        char [] a = string.toCharArray(); // обеспечивает простой способ преобразования строки в массив символов всего одним вызовом метода.
	        char [] b = anagram.toCharArray();
	        boolean running = false;
	        for (char c : a)
	        {
	            map.merge(c, 1 , (x, y) -> x + y);
	        }
	        for (char c : b)
	        {
	            map1.merge(c, 1 , (x, y) -> x + y);
	        }


	        for (char c : a)
	        {
	            if (map1.get(c) != map.get(c) || string.equals(anagram))
	            {
	                running = false;
	                break;
	            } else {
	                running = true;
	            }

	        }
	        return running;

	    }
		       
		       
	}

//			
//			
//			    if(string.length() != anagram.length() || string.equals(anagram)) {
//			        return false;
//			    }
//			    
//			    HashMap<Character, Integer> countMap = new HashMap<>();
//			    
//			    for(char c : string.toCharArray()) {
//			        countMap.put(c, countMap.getOrDefault(c, 0) + 1);
//			    }
//			    
//			    for(char c : anagram.toCharArray()) {
//			        if(countMap.containsKey(c)) {
//			            countMap.put(c, countMap.get(c) - 1);
//			            if(countMap.get(c) == 0) {
//			                countMap.remove(c);
//			            }
//			        } else {
//			            return false;
//			        }
//			    }
//			    
//			    return countMap.isEmpty();
//			}
// 			
// 			
//		}

//			char [] a = string.toCharArray(); // обеспечивает простой способ преобразования строки в массив символов всего одним вызовом метода. 
//			char [] b = anagram.toCharArray();
//			int id = -1;
//			int lCounter = 0;
//			boolean res = false;
//			for (char c : a) {
//				id = anagram.indexOf(c);
//				if(id != -1) {
//					++lCounter;
//					
//				}
//			}
//			
//			return res;
//		}
		
	

