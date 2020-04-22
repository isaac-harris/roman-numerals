import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.sort;

public class RomanNumeralConverter {

    //converts basic numbers to roman numerals

    public static void main(String[] args){
        System.out.println(convertRomanNumerals(3457));
    }

    public static String convertRomanNumerals(int arabicNumber){
        HashMap<Integer, String> romanNumeralCombinations = generateNumberHashmap();
        String romanNumber = "";

        //create a list that shows all the atomic roman numerals (as standard arabic decimal numbers e.g. 1,20,1050)
        //all the roman numbers less than 3999 (and possibly higher) can be made with a series of characters from romanNumeralCombinations                       <----
        //all roman numbers are made by concatenating the largest of the values, values which (for given our range) are all contained in this from this hash table ^
        //so instead of implementing loads of spaghetti conditions i decided to just make a list of all the values, and write
        List<Integer> subtractableNumbers =  new ArrayList<Integer>();
        subtractableNumbers.addAll(romanNumeralCombinations.keySet());

        //sort descending
        List<Integer> subNums = subtractableNumbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        int index = 0;

        //repeat until arabicNumber is = 0
        while (arabicNumber > 0){

            //subtract the highest possible basicNumberCombination possible, and add the corresponding romanNumeral to the romanNumber variable
            if (arabicNumber - subNums.get(index) >= 0){

                //concatenate the romanNumeral and then subtract that value from arabicNumber
                romanNumber = romanNumber + romanNumeralCombinations.get(subNums.get(index));
                arabicNumber = arabicNumber - subNums.get(index);

            }
            else {
                index += 1;
            }

        }


        return romanNumber;
    }

    //modify this map if you wish to change/add any numerals. this will work for any numbering system that concatenates numerals
    private static HashMap<Integer, String> generateNumberHashmap(){
        //all roman numerals can be made with a series of these
        HashMap<Integer, String> romanNumeralCombinations = new HashMap<>();
        romanNumeralCombinations.put(1, "I");
        romanNumeralCombinations.put(2, "II");
        romanNumeralCombinations.put(3, "III");
        romanNumeralCombinations.put(4, "IV");
        romanNumeralCombinations.put(5, "V");
        romanNumeralCombinations.put(6, "VI");
        romanNumeralCombinations.put(7, "VII");
        romanNumeralCombinations.put(8, "VIII");
        romanNumeralCombinations.put(9, "XI");
        romanNumeralCombinations.put(10, "X");
        romanNumeralCombinations.put(20, "XX");
        romanNumeralCombinations.put(30, "XXX");
        romanNumeralCombinations.put(40, "XL");
        romanNumeralCombinations.put(50, "L");
        romanNumeralCombinations.put(60, "LX");
        romanNumeralCombinations.put(70, "LXX");
        romanNumeralCombinations.put(80, "LXXX");
        romanNumeralCombinations.put(90, "XC");
        romanNumeralCombinations.put(100, "C");
        romanNumeralCombinations.put(200, "CC");
        romanNumeralCombinations.put(300, "CCC");
        romanNumeralCombinations.put(400, "CD");
        romanNumeralCombinations.put(500, "D");
        romanNumeralCombinations.put(600, "DC");
        romanNumeralCombinations.put(700, "DCC");
        romanNumeralCombinations.put(800, "DCCC");
        romanNumeralCombinations.put(900, "CM");
        romanNumeralCombinations.put(1000, "M");

        return romanNumeralCombinations;}

}
