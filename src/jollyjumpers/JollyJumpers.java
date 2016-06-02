package jollyjumpers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Slava Ceornea
 * 
 * Problem
 * A sequence of n > 0 integers is called a jolly jumper if the absolute values of the
 * differences between successive elements take on all possible values 1 through n − 1. For
 * instance, 1 4 2 3 is a jolly jumper, because the absolute diﬀerences are 3, 2, and 1, respectively.
 * The deﬁnition implies that any sequence of a single integer is a jolly jumper. Write a program
 * to determine whether each sequence is a jolly jumper.

 * Input
 * A line of input contains n integers representing the sequence.

 * Output
 * For a line of input generate a line of output saying “Jolly” or “Not jolly”.
 * 
 * Sample Input
 * 3 2 4 7
 * Sample Output
 * Jolly
 * 
 * Sample Input
 * 5 1 4 2 -3 6
 * 
 * Sample Output
 * Not jolly
 * 
 * Code comment
 * Method IsJollyJumpers in this class returns true when the absolute values of the differences
 * between successive elements in the input number sequence take all possible ranks 1 through n-1.
 * 
 * The algorithm used in this method will perform linearly depending on a growing
 * input n. The method will have to execute a maximum of n - 1 iterations to return the result.
 * The upper limit for execution in big O notation is O(n) - 1 which is linear.
 * The space needed to perform the computation is approximately (n * 32) + n - 1 bits 
 * where n is the number of integers in the input sequence given 32 bits is the size of an integer
 * value in the language used.
 */

public class JollyJumpers {
    public static void main(String args[] ) throws Exception {
            Scanner scanner = new Scanner( System.in );
            Pattern delimiters = Pattern.compile(System.getProperty("line.separator")+"|\\s");
            scanner.useDelimiter(delimiters); 

            ArrayList<Integer> numberSequence = new ArrayList<>();

            while (scanner.hasNextInt()){
                numberSequence.add(scanner.nextInt());
            }

            JollyJumpers solution = new JollyJumpers();
            if(solution.IsJollyJumpers(numberSequence))
                System.out.println("Jolly");
            else
                System.out.println("Not Jolly");
    }
    
    public boolean IsJollyJumpers(ArrayList<Integer> numberSequence)
    {
        if(numberSequence.size() < 2)
            return false;
        
        boolean[] absoluteValuesFlags = new boolean[numberSequence.size() - 1];
        
        for(int i = 0; i < numberSequence.size() - 1; i++) {
            int absoluteValue = Math.abs(numberSequence.get(i + 1) - numberSequence.get(i));
            if(absoluteValue - 1 >= absoluteValuesFlags.length || absoluteValue < 1 || absoluteValuesFlags[absoluteValue - 1])
                return false;
            
            absoluteValuesFlags[absoluteValue - 1] = true;
        }
        
        return true;
    }
}
