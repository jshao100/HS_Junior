import java.util.Scanner;

public class TimeSheets {

	//Zone Functions
	//Zone 1 (100-199) $10 per hour & after 30hrs, 15$
	public static double Zone1(double i){
	

		return 0;
	}

	//Zone 2 (200-299) $7.50 per hour & after 40hrs, 15$
	public static double Zone2(double i){

		return 0;
	}

	//Zone 3 (300-399) $9.25 per hour & after 20hrs, 10.50$
	public static double Zone3(double i){

		return 0;
	}

	//Zone 4 (400-499) $13.50 Sat and Sun, others $6.75
	public static double Zone4(double i){

		return 0;
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
		
		double start = 0;
		double end = 0;
		
		//possible times
		if(a[0] == "1") start = 9.00;
		else if(a[0] == "2") start = 9.50;
		else if(a[0] == "3") start = 10.00;
		else if(a[0] == "4") start = 10.50;
		else if(a[0] == "5") start = 11.00;
		else if(a[0] == "6") start = 11.50;
		else if(a[0] == "7") start = 12.00;
		else if(a[0] == "8") start = 12.50;
		else if(a[0] == "9") start = 13.00;
		else if(a[0] == "A") start = 13.50;
		else if(a[0] == "B") start = 14.00;
		else if(a[0] == "C") start = 14.50;
		else if(a[0] == "D") start = 15.00;
		else if(a[0] == "E") start = 15.50;
		else if(a[0] == "F") start = 16.00;
		else if(a[0] == "G") start = 16.50;
		else if(a[0] == "H") start = 17.00;
		
		if(a[1] == "1") end = 9.00;
		else if(a[1] == "2") end = 9.50;
		else if(a[1] == "3") end = 10.00;
		else if(a[1] == "4") end = 10.50;
		else if(a[1] == "5") end = 11.00;
		else if(a[1] == "6") end = 11.50;
		else if(a[1] == "7") end = 12.00;
		else if(a[1] == "8") end = 12.50;
		else if(a[1] == "9") end = 13.00;
		else if(a[1] == "A") end = 13.50;
		else if(a[1] == "B") end = 14.00;
		else if(a[1] == "C") end = 14.50;
		else if(a[1] == "D") end = 15.00;
		else if(a[1] == "E") end = 15.50;
		else if(a[1] == "F") end = 16.00;
		else if(a[1] == "G") end = 16.50;
		else if(a[1] == "H") end = 17.00;
		
		return end - start;
	}

	//Main
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//variables
		int Zone;
		double totalTime = 0;
		double Sat = 0;
		double Sun = 0;
		double output = 0;
		
		//User Input
		String userInput = input.nextLine();
		//Convert to array
		String [] data = userInput.split(", ");

		//find Zone # (input number into findZone after converting String to Int)
		Zone = findZone(Integer.parseInt(data[1]));
		
		//zone exceptions
		if(Zone == 4); //save Sat + Sun time separately
		{
			String[] Sunday = data[1].split(",");
			Sun = findHours(Sunday);
			
			String [] Saturday = data[7].split(",");
			Sat = findHours(Saturday);
			
			for(int i = 2; i < 7; i++)
			{
				String[] dayData = data[i].split(",");
				totalTime = totalTime + findHours(dayData); //total time
			}
		}
		
		if(Zone == 5) //if time > 6, set answer to 6 and send into Method Zone5, have remainder * 12, add
		{
			for(int i = 1; i < 8; i++)
			{
				double first = 0;
				double second = 0;
				
				String[] dayData = data[i].split(",");
				if(findHours(dayData) > 6)
				{
					first = 6;
					second = findHours(dayData) - 6 + second;
				}
				totalTime = first*8 + second*12 + findHours(dayData) + totalTime;
			}
		}
		
		else //input time into zone of choice
		{
			//take date values
			for(int i = 1; i < 8; i++)
			{
				String[] dayData = data[i].split(",");
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
		}		
	}
}
