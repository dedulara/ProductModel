import java.util.Scanner;

public class SafeInput
{
    /**
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)                                                //Get a string of nonzero length
    {
        String retString = "";                                                                                           //Sets this to zero length.  Loop runs until it isn't
        do
        {
            System.out.print("\n" + prompt + ": ");                                                                      //Shows prompt
            retString = pipe.nextLine();
        }
        while(retString.length() == 0);
        return retString;
    }

    /**
     * @param pipe - Scanner instance to read the data System.in in most cases
     * @param prompt - input prompt msg should not include range info
     * @return - unconstrained int value
     */
    public static int getInt(Scanner pipe, String prompt)                                                               //Get an integer
    {
        String trash = "";
        int integerNumber = 0;
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextInt())
            {
                integerNumber = pipe.nextInt();
                pipe.nextLine();                                                                                        //Clears the input buffer
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer. " + trash);
            }
        }
        while(!done);
        return integerNumber;
    }

    /**
     * @param pipe - Scanner instance to read the data System.in in most cases
     * @param prompt - input prompt msg should not include range info
     * @param low - low end of inclusive range
     * @param high - high end of inclusive range
     * @return - int value within the inclusive range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)                                      //Get an integer within a specified range
    {
        int rangedInt = 0;
        boolean done = false;
        String trash = "";
        do
        {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if(pipe.hasNextInt())
            {
                rangedInt = pipe.nextInt();
                pipe.nextLine();                                                                                        //Clears the input buffer
                if(rangedInt >= low && rangedInt <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nYou must enter a value in range [" + low + "-" + high + "]: " + rangedInt);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer [" + low + " - " + high + "]" + trash);
            }
        }
        while(!done);
        return rangedInt;
    }

    /**
     * @param pipe - Scanner instance to read the data System.in in most cases
     * @param prompt - input prompt msg should not contain range info
     * @return  - an unconstrained double value
     */
    public static double getDouble(Scanner pipe, String prompt)                                                         //Get a double
    {
        String trash = "";
        double doubleNumber = 0;
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextDouble())
            {
                doubleNumber = pipe.nextDouble();
                pipe.nextLine();                                                                                        //Clears the input buffer
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double. " + trash);
            }
        }
        while(!done);
        return doubleNumber;
    }

    /**
     * @param pipe - Scanner instance to read the data System.in in most cases
     * @param prompt - input prompt msg should not contain range info
     * @param low - low value inclusive
     * @param high - high value inclusive
     * @return  - double value within the specified inclusive range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)                                //Get a double within a specified range
    {
        double rangedDouble = 0;
        boolean done = false;
        String trash = "";
        do
        {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if(pipe.hasNextDouble())
            {
                rangedDouble = pipe.nextDouble();
                pipe.nextLine();
                if(rangedDouble >= low && rangedDouble <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nYou must enter a value in range [" + low + "-" + high + "]: " + rangedDouble);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double [" + low + " - " + high + "]. " + trash);
            }
        }
        while(!done);
        return rangedDouble;
    }

    /**
     * Get a [Y/N] confirmation from the user
     * @param pipe - Scanner instance to read the data System.in in most cases
     * @param prompt -input prompt msg for user does not need [Y/N]
     * @return - true for yes false for no
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)                                                     //Get a yes or no confirmation
    {
        String answerYesNo = "";
        boolean answerTrueFalse = false;
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            answerYesNo = pipe.nextLine();
            if(answerYesNo.equalsIgnoreCase("Y"))
            {
                answerTrueFalse = true;
                done = true;
            }

            if(answerYesNo.equalsIgnoreCase("Y"))
            {
                done = true;
                answerTrueFalse = true;
            }
            else if(answerYesNo.equalsIgnoreCase("N"))
            {
                done = true;
                answerTrueFalse = false;
            }
            else
            {
                System.out.println("You must answer [Y] or [N]: " + answerYesNo );
            }

        }
        while(!done);
        return answerTrueFalse;
    }

    /**
     * @param pipe - Scanner instance to read the data System.in in most cases
     * @param prompt - prompt for user
     * @param regExPattern - java style RegEx pattern to constrain the input
     * @return a String that matches the RegEx pattern supplied
     */

    public static String getRegExString(Scanner pipe, String prompt, String regExPattern)                               //Get a string that matches a RegEx pattern
    {
        String retString = "";
        boolean answerMatch = false;
        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
            if(retString.matches(regExPattern))
            {
                answerMatch = true;
            }
            else
            {
                System.out.println("\n" + retString + " must match the pattern " + regExPattern);
                System.out.println("Try again!");
            }
        }
        while(!answerMatch);
        return retString;
    }
}