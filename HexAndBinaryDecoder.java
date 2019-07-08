//This is the code committed to github for Lab 04
import java.util.Scanner;
public class HexAndBinaryDecoder
{
    //Method to decode a hexadecimal string to return its value
    public static long hexStringDecode(String hex)
    {
        char[] hexArray = hex.toCharArray();
        int hexLength = hex.length();
        int hexIndex = hexLength - 1;
        long hexSum = 0;
        /*for loop uses hexIndex - i to give the position of the number in the hex string.
        * The if else block decodes the hex char with the method hexCharDecode and breaks if the char value is 'x'*/
        for (int i = hexIndex; i >= 0; i--)
        {
            if (hexArray[i] == 'x')
            {
                break;
            }
            else
            {
                hexSum += (long) hexCharDecode(hexArray[i]) * (long) Math.pow(16, hexIndex - i);
            }
        }
        return hexSum;
    }
    //Method to decode a single hexadecimal digit and return its value
    public static short hexCharDecode(char digit)
    {
        short hexDigit;
        //If else block checks the string for letters that make up the hex code and returns their numerical value
        if (digit == 'A' || digit == 'a' )
        {
            hexDigit = 10;
        }
        else if (digit == 'B' || digit == 'b')
        {
            hexDigit = 11;
        }
        else if (digit == 'C' || digit == 'c')
        {
            hexDigit = 12;
        }
        else if (digit == 'D' || digit == 'd')
        {
            hexDigit = 13;
        }
        else if (digit == 'E' || digit == 'e')
        {
            hexDigit = 14;
        }
        else if (digit == 'F' || digit == 'f')
        {
            hexDigit = 15;
        }
        else
        {
            hexDigit  = (short) Character.getNumericValue(digit);
        }
        return hexDigit;
    }
    //Method decodes a binary string and returns its value
    public static short binaryStringDecode(String binary)
    {
        char[] binaryArray = binary.toCharArray();
        int binaryLength = binaryArray.length;
        int binaryIndex = binaryLength - 1;
        short binarySum = 0;
        /*for loop starts at the right side of the binaryArray and checks every number.
        * If the number is a 1 then it is multiplied by 2 raised to the number of the index with the furthest right number having an index of 0
        * If the character is a 'b' then the if statement breaks out of the for loop and returns the value of binarySum.*/
        for (int i = binaryIndex; i >= 0; i--)
        {
            if (binaryArray[i] == 'b')
            {
                break;
            }
            else if (binaryArray[i] == '1')
            {
                binarySum += (short) Math.pow(2, binaryIndex - i);
            }
        }
        return binarySum;
    }
    //Method decodes a binary string and re-encodes it as a hexadecimal
    public static String binaryToHex(String binary)
    {
        int value = (int) binaryStringDecode(binary);
        //Using built in method to convert integers to hex
        return Integer.toHexString(value).toUpperCase();
    }
    //Main method displays the menu options and calls on the previous methods based on user input
    public static void main(String[] arg)
    {
        boolean exit = false;
        int menu;
        String numeric;
        Scanner scanner = new Scanner(System.in);
        //while loop runs through the menu going through above methods and terminates if 4 is selected
        while(exit == false)
        {
            //Conversion Menu
            System.out.println("Choose an option:");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit");
            System.out.println();
            //User menu input and numeric string input
            System.out.println("Please enter an option: ");
            menu = scanner.nextInt();
            if (menu == 4)
            {
                exit = true;
                System.out.println("Quitting program.");
                break;
            }
            System.out.println("Please enter the numeric string to convert: ");
            numeric = scanner.next();
            //Reads type of numeric string and converts it to selected format by call on above methods
            switch (menu)
            {
                case 1: System.out.println("Result: " + hexStringDecode(numeric));
                        break;
                case 2: System.out.println("Result: " + binaryStringDecode(numeric));
                        break;
                case 3: System.out.println("Result: " + binaryToHex(numeric));
                        break;
            }
            System.out.println();
        }
    }
}
