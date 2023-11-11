package terlan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class homework11_11 {
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
			
				map.merge(strings[i], (long) 1 , (x, y) -> x + y);
			}
			System.out.println(map);
			
			//TODO should be done with complexity O[N]
			//Optionally, additional bonus if you apply the method "merge" of the interface Map
			//try to understand this method https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#merge-K-V-java.util.function.BiFunction- 
			//it uses Functional interface BiFunction
			return map;
		}

	}

