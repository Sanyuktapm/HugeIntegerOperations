/**
 * Huge Integer Class: Create a class HugeInteger 
 * which uses a 40-element array of digits to store 
 * integers as large as 40-digit long. Provide methods parse, 
 * toString, add and subtract to manipulate objects of HugeInteger. 
 * Method parse should receive a String, extract each digit using 
 * method charAt and place the integer equivalent of each digit into 
 * the integer array and return a HugeInteger object.
 * Sanyukta Praksh Mudknnavar 
 * Period 6
 */
public class HugeInteger_SM2
{
    // instance variables - replace the example below with your own
    private int x;
    private char strInteger1[] ;
    private char strInteger2[] ;
    private int  lengthOfStr1=0;
    private int  lengthOfStr2=0;
    private char userCharNumArray[]; 
    private int userIntNumArray[];
    private int carryOver =0; 
    private int longerStrLength = 0;
    private int numInteger1[]; 
    private int numInteger2[]; 
    private String operSign=" "; 
    private char answerArray[]; 
    /**
     * 
     * Constructor for objects of class HugeInteger_SM
     */
    public HugeInteger_SM2(String userInputInteger1,String userInputInteger2, String charSign)
    {
        longerStrLength = determineLength(userInputInteger1, userInputInteger2);
        char tempAnswerArray[] = new char[longerStrLength+2]; 
        answerArray = tempAnswerArray; 

        lengthOfStr1 = userInputInteger1.length();
        lengthOfStr2 = userInputInteger2.length();

        strInteger1 = includeSign(userInputInteger1);
        strInteger2 = includeSign(userInputInteger2);
        operSign=charSign;

        if (strInteger1.length < longerStrLength) 
            strInteger1 = stuffZero(strInteger1, strInteger1.length);

        if (strInteger2.length < longerStrLength) 
            strInteger2 = stuffZero(strInteger2, strInteger2.length);
    }

    /**
     * This method determines which string is longer and provides the length of the longer string.
     * This would be used when we create the arrays for the two numebers so the 
     * smaller number would have the same array lengths to perform operations 
     *
     */
    public int determineLength (String userInputInteger1,String userInputInteger2)
    {
        if (userInputInteger1.length() >userInputInteger2.length())
        {
            longerStrLength = userInputInteger1.length(); 
        }
        else 
        {
            longerStrLength = userInputInteger2.length(); 
        }
        return longerStrLength; 
    }

    /*
     *  Convert user input string to include sign of the integeer
     *  
     */
    public char [] includeSign(String userInteger)
    {
        int tempLength=0;
        boolean signPresent=true;
        int i = 0;
        int k = 0;

        if (userInteger.charAt(0) != '+' && userInteger.charAt(0) != '-'){
            // sign present 
            signPresent = false;
            tempLength = userInteger.length()+1;
        }
        else
        {
            tempLength = userInteger.length();
        }
        char tempArray[] = new char [tempLength];
        if (signPresent == false)
        {
            tempArray[0] = '+';
            i=0;
            k=1;
        }
        else {
            tempArray[0] = userInteger.charAt(0);
            i=1;
            k=1;
        }

        while (i<= (userInteger.length()-1))
        {
            tempArray[k] = userInteger.charAt(i); 
            // System.out.println("i ="+tempArray[i] + " " + userInteger.charAt(i) );
            i++;
            k++;
        }
        //System.out.println("Include sign" );
        //printCharArray(tempArray);
        return tempArray;
    }

    /**
     * This method converts the string inputed by the user into an integer array 
     */

    public char [] stuffZero(char userInteger[], int lengthOfStr)
    {
        char tempArray[] = new char [longerStrLength];

        for (int i = 0; i<longerStrLength; i++) { 
            tempArray[i] = '0'; 
        }
        tempArray[0] = userInteger[0];

        if (lengthOfStr < longerStrLength){
            int k = longerStrLength-1;
            for (int i = (lengthOfStr-1); i>0; i--) { 
                tempArray[k] = userInteger[i];
                k--;
            }
        }
        //printCharArray(tempArray);
        return tempArray;
    }    

    // /*
     // * Print int array
     // */
    // public void printCharArray(char printArray[])
    // {
        // //System.out.println("\nInteger = :");
        // //System.out.println("\nLongerStrLength = :" + longerStrLength);
        // for (int x =0; x< printArray.length; x++) {
            // System.out.print(printArray[x]);
        // }
    // }

    /**
     * This method performs the addition operation with the number 
     * inputed by the user if the user wishes to do so. 
     * It starts from the last index and adds them indexes together 
     * If the sum of the indexes is greater than 10, it would subtract 10 
     * from the sum and store 1 in a variable for the next index addition 
     * 
     */

    public char [] addition()
    { 
        final int REDIX=10; 
        for (int x = strInteger1.length-1; x > 0 ; x--) {
            int addition =  Character.getNumericValue(strInteger1[x])+ Character.getNumericValue(strInteger2[x]); 
            if (carryOver == 1)
            {
                addition += carryOver; 
            }
            if (addition >=10 )
            {
                carryOver =1; 
                addition -=10; 
            }
            else 
            {   
                carryOver = 0; 
            }

            answerArray[x+1]= Character.forDigit(addition, REDIX);
            //System.out.println("answerArray[x+1] ="+answerArray[x+1]); 
        }
        answerArray[1]= Character.forDigit(carryOver, REDIX);
        return answerArray; 
       }

    /**
     * Performs the intended operation that the user wants 
     */
    public char [] getTotal()
    {
        String subPattern="";
        if (strInteger1[0] == '+')
            subPattern= subPattern+="+";
        else
            subPattern+="-";

        subPattern+=operSign;

        if (strInteger2[0] == '+')
            subPattern+="+";
        else
            subPattern+="-";
        //System.out.println("\n Pattern:"+subPattern); 
        if ((subPattern.equals("+++") || subPattern.equals("+--")))
        {
            addition();
        }

        if (subPattern.equals("++-") || subPattern.equals("+-+"))
            subtraction();

        if (subPattern.equals("-+-")||subPattern.equals("--+")) 
        {
            addition();
            answerArray[0] = '-';
        }

        if (subPattern.equals("-++") ||subPattern.equals("---"))
        {
            subtraction();
            answerArray[0] = '-';
        }
        return answerArray;

    }

    /**
     * Performs subtraction between two numbers. 
     */
    public char [] subtraction() {
        // answerArray =  char [strInteger1.length+2]; 
        boolean strOneGreater = true; 
        final int REDIX=10; 
        String subPattern="";

        char [] tempArray1=strInteger1;
        char [] tempArray2=strInteger2;

        boolean continueLoop=true;
        x = 1;
        while (continueLoop && x <  strInteger1.length ) {
            if (strInteger1[x] > strInteger2[x]) {
                strOneGreater = true;
                continueLoop=false;
            }
            else
            if (strInteger1[x] < strInteger2[x]) {
                strOneGreater = false;
                continueLoop=false;
            }

            else
                x++;
        }

        for (int x = strInteger1.length-1; x > 0 ; x--) {

            int subtraction =0; 

            if (strOneGreater) 
                subtraction =  Character.getNumericValue(strInteger1[x])- Character.getNumericValue(strInteger2[x]);
            else
                subtraction =  Character.getNumericValue(strInteger2[x]) - Character.getNumericValue(strInteger1[x]);

            if (carryOver< 0)
                subtraction += carryOver; 

            if (subtraction <0)
            {
                carryOver -= 1; 
                subtraction +=10; 
            }
            else 
                carryOver = 0; 
            answerArray[x+1]=Character.forDigit(subtraction, REDIX);
        }
        return answerArray;
    }

    public String toString()  {
        String stringInteger =" "; 
        //System.out.println("Length =" + answerArray.length);
        for (int i=0;i<answerArray.length;i++){
            stringInteger += Character.toString(answerArray[i]);
            //System.out.println(answerArray[i]);
        }
        return stringInteger; 
    }
}
