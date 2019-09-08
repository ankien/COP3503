import java.util.Scanner;

/*    COP3503
 *    University of North Florida
 *    09/04/19
 *    N01367753
 *    Andrew Kien
 *    
 *    This program prompts for an integer input from the user from the range 1780 to 2040.
 *    
 *    It displays an error message and repeats the scan if the input isn't in the right range.
 *    
 *    It finds the first day of the year for calculations.
 *    
 *    The program then prints out a list of calendars for each month of the year.
 */

public class MyCalendar {
	
	// Modulo method (for negative numbers)
	// ex: mod(-12.0, 5.0) == 3.0
	public static double mod (double a, double b) {
		double modulo = ((a % b + b) % b);
		return modulo;
	}
	
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);
		
	    System.out.printf("Enter an integer value for your calendar year (in the range 1780-2040): ");
		int year = input.nextInt();	
		
		// Checks if year is in range
		while ((year > 2040) || (year < 1780)) {		
		    System.out.printf("Invalid year. Please input an integer in the range 1780 through 2040.\n");
		    year = input.nextInt();
		}
		
		// Determines the first day of the year
		// Uses the aforementioned "mod()" method
		int firstDayCalc = (int) mod( 28.0 + mod((double)year, 100.0) 
		                 + Math.floor((mod((double)year, 100.0) - 1.0)/4.0) 
		                 + Math.floor((double)year/400.0) 
		                 - (2.0 * Math.floor((double)year/100.0)), 7.0 );
		
		// Prints calendars for each month
		System.out.printf("\n-----------------------------");
		String[] monthNames = {"January", "February", "March", "April",
				               "May", "June", "July", "August", 
				               "September", "October", "November", "December"};
		
		for (int month = 0; month < 12; month++) {
			System.out.printf("\n%15s %d", monthNames[month], year);
			
			int monthDays = month;
			
			switch (monthDays) {
			  case  0: monthDays = 31; break;
			  case  1: if (year % 400 == 0) {
			             monthDays = 29; break;	  
			           }
			           else if ( (year % 4 == 0) && (year % 100 != 0) ) {
			        	 monthDays = 29; break;  
			           }
			           else {
			        	 monthDays = 28; break;  
			           }
			  case  2: monthDays = 31; break;
			  case  3: monthDays = 30; break;
			  case  4: monthDays = 31; break;
			  case  5: monthDays = 30; break;
			  case  6:
			  case  7: monthDays = 31; break;
			  case  8: monthDays = 30; break;
			  case  9: monthDays = 31; break;
			  case 10: monthDays = 30; break;
			  case 11: monthDays = 31; break;
			}
			
			System.out.printf("\n Sun Mon Tue Wed Thu Fri Sat\n");
			
			// Prints blank spaces (at least 2) before the first day of January and subsequent months
			for (int spaces = 0; spaces < 4 * firstDayCalc + 2; spaces++) {
			    System.out.printf(" ");
			}
			
			// Prints the number for the day and either space after, or a new line
			for (int currentDay = 0; currentDay < monthDays; currentDay++) {
				System.out.printf("%2d", currentDay + 1);
				
				if ( (currentDay + firstDayCalc + 1) % 7 != 0) {
					System.out.printf("  ");
				}
				else {
					System.out.printf("\n  ");
				}
			}
			
			// Sets the spacing before the first day for the next month
			firstDayCalc = (firstDayCalc + monthDays) % 7;
		    
		    System.out.printf("\n-----------------------------");
		}
		    
		input.close();
	}

}
