/*
Список сотрудников некой фирмы хранится в виде, например, такой HashMap
HashMap<Integer, ArrayList<String>> persons = new HashMap<>();
где ключ - серия и номер паспорта сотрудника, а в списке хранятся его параметры
1) Написать метод, возвращающий всех однофамильцев (или тёзок)
2) Написать метод, возвращающий сотрудников, старше (младше) определенного возраста
*/
package hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class task
{
    public static HashMap<Integer, ArrayList<String>> persons = new HashMap<>();

    public static void main(String[] args)
    {       
        persons.put(14752324, new ArrayList<String>(Arrays.asList("Иванов", "Иван", "Иванович", "12-02-1987")));
        persons.put(45752784, new ArrayList<String>(Arrays.asList("Петров", "Петр", "Иванович", "10-02-1989")));
        persons.put(98745224, new ArrayList<String>(Arrays.asList("Смирнов", "Ян", "Петрович", "11-09-1986")));
        persons.put(65987412, new ArrayList<String>(Arrays.asList("Иванов", "Олег", "Петрович", "03-01-1990")));
        persons.put(25469874, new ArrayList<String>(Arrays.asList("Иванова", "Анна", "Олеговна", "08-10-1987")));
        persons.put(32145698, new ArrayList<String>(Arrays.asList("Иващенко", "Ольга", "Иванович", "05-05-1991")));

        System.out.println(checkSirname());
        System.out.println(checkAge(31));
    } 

    public static String checkSirname()
    {
        int[][] arr = new int[persons.size()][2]; 
        StringBuilder sb = new StringBuilder();
        int i = 0;
        String s;
        String s1;
        String s2;

        for (Map.Entry < Integer, ArrayList < String >> entry: persons.entrySet()) {
            Integer key = entry.getKey();
            arr[i][0] = key;
            arr[i][1] = 0;
            i++;
        }    
        for(int j = 0; j < arr.length - 1; j++){    
            for(int k = j + 1; k < arr.length; k++){
                s1 = persons.get(arr[j][0]).get(0) + "а";
                s2 = persons.get(arr[j][0]).get(0);
                s = persons.get(arr[k][0]).get(0);

                if( s.equals(s1) || s.equals(s2) ) {
                    arr[j][1] = 1;
                    arr[k][1] = 1;
                } 
            }
        }

        for(int j = 0; j < arr.length; j++){ 
            if(arr[j][1] == 1) sb.append(arr[j][0] + " : " + persons.get(arr[j][0]) + "\n");     
        }
        return sb.toString();
    } 

    public static String checkAge(int age)
    {
        Integer yearNow = Calendar.getInstance().get(Calendar.YEAR);
        int yearSearch = yearNow - age;
        int year = 0;
        StringBuilder sb = new StringBuilder();

        for (Map.Entry <Integer, ArrayList < String >> entry: persons.entrySet()) {
            Integer key = entry.getKey();
            ArrayList <String > value = entry.getValue();
            
            String aString = value.get(3);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
            LocalDate date = LocalDate.parse(aString, formatter);
            year = date.getYear();
            if(year == yearSearch) sb.append(key.toString() + " : " + value + "\n");
        }
        return sb.toString();
    } 
}
