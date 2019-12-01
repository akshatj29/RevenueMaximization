import java.io.BufferedWriter;
import java.io.*;
import java.text.*;
import java.util.*;


public class MainClass {
	
	public static void main(String[] args) throws Exception {
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		Map<Integer,Integer> map = new HashMap<>();
		map.put(3,60);
		map.put(4,55);
		map.put(5,35);
		map.put(6,38);
		map.put(7,50);
		map.put(8,55);
		map.put(9,58);
		map.put(10,55);
		map.put(11,40);
		map.put(12,32);
		map.put(1,40);
		map.put(2,50);
		
		String row = date;
		
		String start = "2019-01-01";
		
		for(int j=1; j<=365; j++)
		{
			
			Calendar today = Calendar.getInstance();
	        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date dd = format.parse(date);
	        today.add(Calendar.DAY_OF_YEAR, j+31);
	        String nextDate = format.format(today.getTime());
	        System.out.println("nd:"+nextDate);
	        row += "\n"+nextDate;
	        int factor = Integer.parseInt(nextDate.substring(8,10));
			int month = Integer.parseInt(nextDate.substring(5,7));
			
		for(int i=0;i<10;i++)
		{
			int rand = (int) (Math.random()*(factor*2))+map.get(month);
			if(i==8)
				rand = (int) (Math.random()*((30-factor)*2))+map.get(month);
			if(i==9)
				rand = (month == 3) ? (int)(Math.random()*(factor*2)) :  (int) (Math.random()*3);
				
			row += ","+ rand;
			
		}
		
		}
		
		System.out.println("row:"+row);
		String fileContent = row;
	    BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/akshatjain/Documents/datetime.csv"));
	    writer.write(fileContent);
	    writer.close();
	    
		
	   // System.out.println("hi");
	}
	
	
}
