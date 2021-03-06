import java.util.Arrays; 
/**
 * Huge Integer Class: Create a class HugeInteger 
 * which uses a 40-element array of digits to store 
 * integers as large as 40-digit long. Provide methods parse, 
 * toString, add and subtract to manipulate objects of HugeInteger. 
 * Method parse should receive a String, extract each digit using 
 * method charAt and place the integer equivalent of each digit into 
 * the integer array and return a HugeInteger object.
 * Sanyukta PM 
 * Period 6
 */
public class HugeIntegerSM2_Tester
{
    public static void main()
    {
        String firstNumber = "-700"; 
        String secondNumber = "+51"; 
        String operSign = "-";
        
        System.out.println("firstNumber =" +firstNumber );
        System.out.println("secondNumber =" +secondNumber );
        System.out.println("Operation Sign =" +operSign );
        HugeInteger_SM2 numbers = new HugeInteger_SM2(firstNumber,secondNumber,operSign);
        numbers.getTotal();
        System.out.println("The sum of two numbers: " + numbers); 
    }
}
/**
 firstNumber =+700
secondNumber =+51
Operation Sign =-
The sum of two numbers:    549 

firstNumber =+700
secondNumber =-51
Operation Sign =-
The sum of two numbers:   0751 

firstNumber =-700
secondNumber =+51
Operation Sign =-
The sum of two numbers:  -0751 

firstNumber =-700
secondNumber =-51
Operation Sign =-
The sum of two numbers:  - 549 

firstNumber =+700
secondNumber =+51
Operation Sign =+
The sum of two numbers:   0751 

firstNumber =-700
secondNumber =+51
Operation Sign =+
The sum of two numbers:  - 549 

firstNumber =-700
secondNumber =-51
Operation Sign =+
The sum of two numbers:  -0751 

firstNumber =+700
secondNumber =-51
Operation Sign =+
The sum of two numbers:    549 


*/
