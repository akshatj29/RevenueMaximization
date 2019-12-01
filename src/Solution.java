import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

	int key;
    int value;
	public Result(int key, int val)
	{
		this.key = key;
		this.value=val;
	}
	@Override
	public String toString() {
		return "Result [key=" + key + ", value=" + value + "]";
	}
  
}

public class Solution {
	public static void main(String[] args) throws IOException {
    	
		List<Result> list = new ArrayList<>();
    	int[][] matrix = {{1,2,3,4},{1,2,3,4},{1,1,1,2}};
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int[] x : matrix)
    	{
    		for(int y: x)
    		{
    			map.put(y, map.get(y)==null ? 1 : map.get(y)+ 1);
    		}
    	}
    	
    	for(Entry<Integer, Integer> entry : map.entrySet())
    	{	
    		Result r = new Result(entry.getKey(), entry.getValue());
    		list.add(r);
    	}
    	
    	Collections.sort(list, new Comparator<Result>() {
    		public int compare(Result i, Result j)
    		{
    			return (i.value > j.value) ? 1 : -1; 
    		}
    	});
    	
    	System.out.println(list);
    	
    }
}
