import java.io.BufferedWriter;
import java.io.*;
import java.text.*;
import java.util.*;


public class MainClass {
	
	static double[] queryPrices = {6.0,11.0,12.0,12.5,11.5,11.75,12.0,10.2,10.5,35.0};
	
	public static int getDemand(int demand, int query)
	{
//		if(demand > queryPrices[query]*5)
//			return (int) queryPrices[query]*5;
//		
//		else if(demand < queryPrices[query]/5)
//			return (int) queryPrices[query]/5;
//		
//		else
			return (int)(10.0*(demand*1.0/queryPrices[query]));
		
	}
	
	public static void main(String[] args) throws Exception {
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		
		Map<Integer,Integer> monthlySeasonalComponent = new HashMap<>();
		monthlySeasonalComponent.put(3,60);
		monthlySeasonalComponent.put(4,55);
		monthlySeasonalComponent.put(5,35);
		monthlySeasonalComponent.put(6,38);
		monthlySeasonalComponent.put(7,50);
		monthlySeasonalComponent.put(8,55);
		monthlySeasonalComponent.put(9,58);
		monthlySeasonalComponent.put(10,55);
		monthlySeasonalComponent.put(11,40);
		monthlySeasonalComponent.put(12,32);
		monthlySeasonalComponent.put(1,40);
		monthlySeasonalComponent.put(2,50);
		
		//Query8 has high demand in beginning of the month
		//Query 9 has high demand only end of the year, t is expensive query
		
		String row = date;
		String start = "2019-01-01";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		cal.setTime(sdf.parse("2019-01-01"));
		
		for(int j=1; j<=3650; j++)
		{
			cal.add(Calendar.DAY_OF_YEAR, 1);
	        String nextDate = sdf.format(cal.getTime());
	        System.out.println("nd:"+nextDate);
	        row += "\n"+nextDate;
	        int factor = Integer.parseInt(nextDate.substring(8,10)); //factor is a function of date of month
			int month = Integer.parseInt(nextDate.substring(5,7));
			
		for(int i=0;i<10;i++)
			{
				//generate num between (0 to 2*date)+monthly_component)
				int rand = (int) (Math.random() * (factor * 2)) + monthlySeasonalComponent.get(month); 
				if (i == 8)
					rand = (int) (Math.random() * ((31 - factor) * 2)) + monthlySeasonalComponent.get(month);
				if (i == 9)
					rand = (month == 3) ? (int) (Math.random() * (factor * 2)) : (int) (Math.random() * 3);

				int value = getDemand(rand,i);
				row += "," + value;

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
