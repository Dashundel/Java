
// перевод арабских чисел в римские

package hw5;

import java.util.LinkedHashMap;
import java.util.Map;

public class task1
{
    public static LinkedHashMap<Integer, Character> numberMap = new LinkedHashMap<>();

    public static void main(String args[])
    {     
        numberMap.put(1, 'I');
        numberMap.put(5, 'V');
        numberMap.put(10, 'X');
        numberMap.put(50, 'L');
        numberMap.put(100, 'C');
        numberMap.put(500, 'D');
        numberMap.put(1000, 'M');

        System.out.println(getRoman(25));

    }

    public static String getRoman(int initNum)
    {
        Integer lastkey = 0;
        Integer key = 0;
        String value = "";
        String romNum = "";
        String lastvalue = "";

        if(initNum > 1000) return "Число должно быть < 1000";

        while(initNum > 0){
            value = "";
            for(Map.Entry<Integer, Character> entry: numberMap.entrySet()) {

                if(value == ""){
                    key = entry.getKey();

                    if(initNum < key) {
                        if(key - initNum == 1) {
                            value = value + numberMap.get(1) + entry.getValue();
                            initNum = 0;
                        }
                        else value = value + lastvalue;

                        if(lastkey == 1) initNum = initNum - 1;
                        else {
                            initNum = initNum - lastkey;
                        }
                        
                    }
                    else {
                        lastkey = key;
                        lastvalue = entry.getValue().toString();
                    }
                }

            }
            romNum = romNum + value;
        }
       return romNum;
    } 

    
}
