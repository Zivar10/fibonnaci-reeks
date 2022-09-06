import java.util.Scanner; 

/*
 * Klasse om met een gebruiker te communiceren om de dichtstbijzijnde fibonacci-nummer 
 * te vindenen druk vervolgens de volgende 5 nummers af.
 */
public class ClosestFibonacci {

    public static void main(String [] args) {
        // Scanner 
        Scanner keyboard = new Scanner(System.in);
            
        long input;
		String regex1 = "\\d[0123456789]";
		
  

        do {
			
            // Vrag Nr en Nr lezen
            System.out.println("Voer een nummer in om de dichtstbijzijnde Fibonacci te vinden: ");
            input = keyboard.nextLong();

            // vind de positie van het dichtstbijzijnde fibonacci-getal
            long n = findClosestFibonacciNumber(input); 

            // Druk de volgende vijf fibonacci-getallen vanaf offset n
            printNextFive(n); 

            // Vragen als gebruiker het opnieuw wil uitvoeren 
            System.out.println("\n"); 
            System.out.println("Nog een keer proberen? (j/n)");
            String choice = keyboard.next().toLowerCase();

            if(choice.equals("n")) {
                input = -1; 
            }

        } while(input >= 0); 

    }

    /*
	 * Functie om de volgende 5 fibonacci-nummers af te drukken vanaf
     * de positie n
     * 
     * @param n
     */
    private static void printNextFive(long n) {
        System.out.println("\nVolgende 5 Fibonacci-getallen zijn:");

        for(long i=n+1; i<=n+5; i++) {
            System.out.printf("Fibonacci-getal %d is %d%n", i, 
                getNthFibo(i));
        }
    }

    /**
	  * Functie om het dichtstbijzijnde fibonacci-nummer te vinden - return
      * zijn positie in de fibo-reeks.
      *
      * @param n het nummer om naar het dichtstbijzijnde fibonacii-nummer te zoeken
      * @return positie van gevonden nummer
     */
    private static long findClosestFibonacciNumber(long n) {
        
        // Eerste Nr
        if(n == 0) {
            return 0; 
        }

        long first = 0; 
        long second = 0; 
        long num = 1; 
        while((second = getNthFibo(num)) <= n) {
            first = second;
            num++;
        }

        // Vind de dichtstbijzijnde in het paar
        long nearest = (Math.abs(num-first) <= Math.abs(num-second)) ? first : second;
        
        // Print the found fibo number
        System.out.printf("Nearest Fibonacc of %d is %d%n", n, nearest);
        
        // return positie en print de positie van het gevonden fibo nummer
        if(nearest == second) {
            System.out.printf("Dat is %d Fibonacci-getal%n", num);
            return num;
        } else {
            System.out.printf("Dat is %d Fibonacci-getal%n", num-1);
            return num-1;
        }
    }

    /**
	 * Functie om het N-de fibonacci-getal recursief te vinden 
     * 
     * @return n fibonacci Nr 
     */
    private static long getNthFibo(long n) {
        // base case for 0
        if(n == 0 || n == 1) {
            return 0;
        }

        // Base case for 1
        if(n == 2) {
            return 1;
        }

        // recursief stap vind het n-de fibonacci-getal
        return getNthFibo(n-1) + getNthFibo(n-2);
    }
}