import java.util.Scanner;

public class TimeSheets {
    
	//Zone Functions
	//Zone 1 (100-199) $10 per hour & after 30hrs, 15$
	public static double Zone1(double i){
		if(i>30)
		{
			return 300 + (i-30)*15;
		}
		else
		{
			return i*10;
		}
	}
    
	//Zone 2 (200-299) $7.50 per hour & after 40hrs, 15$
	public static double Zone2(double i){
		if(i>40)
		{
			return 300 + (i-40)*15;
		}
		else
		{
			return i*7.5;
		}
	}
    
	//Zone 3 (300-399) $9.25 per hour & after 20hrs, 10.50$
	public static double Zone3(double i){
		if(i>20)
		{
			return 185 + (i-20)*10.50;
		}
		else
		{
			return i*9.25;
		}
	}
    
	//Zone 4 (400-499) $13.50 Sat and Sun, others $6.75
	public static double Zone4(double i, double sat, double sun){
        
		return i*6.75 + sat*13.5 + sun*13.5;
	}
    
	//Zone 5 (500-599) $8 first 6 hours of day, 12$ rest hours
	public static double Zone5(double i){
        
		return 0;
	}
    
	//Determine Zone # (Take first number of array and test)
	public static int findZone(int i){
        
		if(i>99 && i<200) return 1;
		else if(i>199 && i<300) return 2;
		else if(i>299 && i<400) return 3;
		else if(i>399 && i<500) return 4;
		else return 5;
        
	}
    
	//Find Hours per Day
	public static double findHours(String[] a){
        
		double start=0;
		double end=0;
        
		String s = a[0];
		String e = a[1];
        
		//debug
		//System.out.println("s = " + s + "\n" + "e = " + e);
        
		//possible times
		if(s.equalsIgnoreCase("1")) start = 9.00;
		else if(s.equalsIgnoreCase("2")) start = 9.50;
		else if(s.equalsIgnoreCase("3")) start = 10.00;
		else if(s.equalsIgnoreCase("4")) start = 10.50;
		else if(s.equalsIgnoreCase("5")) start = 11.00;
		else if(s.equalsIgnoreCase("6")) start = 11.50;
		else if(s.equalsIgnoreCase("7")) start = 12.00;
		else if(s.equalsIgnoreCase("8")) start = 12.50;
		else if(s.equalsIgnoreCase("9")) start = 13.00;
		else if(s.equalsIgnoreCase("A")) start = 13.50;
		else if(s.equalsIgnoreCase("B")) start = 14.00;
		else if(s.equalsIgnoreCase("C")) start = 14.50;
		else if(s.equalsIgnoreCase("D")) start = 15.00;
		else if(s.equalsIgnoreCase("E")) start = 15.50;
		else if(s.equalsIgnoreCase("F")) start = 16.00;
		else if(s.equalsIgnoreCase("G")) start = 16.50;
		else if(s.equalsIgnoreCase("H")) start = 17.00;
        
		if(e.equalsIgnoreCase("1")) end = 9.00;
		else if(e.equalsIgnoreCase("2")) end = 9.50;
		else if(e.equalsIgnoreCase("3")) end = 10.00;
		else if(e.equalsIgnoreCase("4")) end = 10.50;
		else if(e.equalsIgnoreCase("5")) end = 11.00;
		else if(e.equalsIgnoreCase("6")) end = 11.50;
		else if(e.equalsIgnoreCase("7")) end = 12.00;
		else if(e.equalsIgnoreCase("8")) end = 12.50;
		else if(e.equalsIgnoreCase("9")) end = 13.00;
		else if(e.equalsIgnoreCase("A")) end = 13.50;
		else if(e.equalsIgnoreCase("B")) end = 14.00;
		else if(e.equalsIgnoreCase("C")) end = 14.50;
		else if(e.equalsIgnoreCase("D")) end = 15.00;
		else if(e.equalsIgnoreCase("E")) end = 15.50;
		else if(e.equalsIgnoreCase("F")) end = 16.00;
		else if(e.equalsIgnoreCase("G")) end = 16.50;
		else if(e.equalsIgnoreCase("H")) end = 17.00;
        
		return (end - start);
	}
    
	//Main
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        
		//variables
		int Zone = 0;
		double totalTime = 0;
		double Sat = 0;
		double Sun = 0;
		double output = 0;
        
		//User Input
		String userInput = input.nextLine();
		//Convert to array
		String [] data = userInput.split(", ");
        
		//find Zone # (input number into findZone after converting String to Int)
		Zone = findZone(Integer.parseInt(data[0]));
        
		//take date values
        for(int i = 1; i < data.length; i++)
        {
            String[] dayData = data[i].split(",");
            
            //debug
            //System.out.println(dayData[0] + " " + dayData[1]);
            
            totalTime = totalTime + findHours(dayData); //total time
        }
        
        if(Zone==1)
        {
            output = Zone1(totalTime);
        }
        
        else if(Zone==2)
        {
            output = Zone2(totalTime);
        }
        
        else if(Zone==3)
        {
            output = Zone3(totalTime);
        }
        
        
        /**
         //debug
         //print data[]
         for(int i=0; i<data.length; i++)
         {
         System.out.print(data[i] + " || ");
         }
         //print Zone
         System.out.println("\n" + Zone);
         //print Time
         System.out.println("\n" + totalTime);
         */
        
        System.out.println(output);
    }
}
