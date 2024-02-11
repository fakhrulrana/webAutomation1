package utils;

public class Utils {

    public int generateRndmNumber()
    {
        int min = 1;
        int max = 10;
//Generate random double value from 200 to 400

        int randomNumber = (int) (Math.random()*(max-min+1)+min);

        System.out.println("Random value of type double between "+min+" to "+max+ ":" +randomNumber);
        return randomNumber;
    }
}
