package Homework9Proj3.Week12Homework.FinalProject;


/**
 * Write a description of class Helpers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.regex.*;
public class Helpers
{
    public static Partial militaryTime(String s){
            Pattern p = Pattern.compile("([0-9]+)(a|p)-([0-9]+)(a|p)");
            Matcher m = p.matcher(s);
            m.find();
            double first, second;
            if (m.group(1).length() == 4){
                first = Integer.parseInt(m.group(1));
            }else{
                first = Integer.parseInt(m.group(1)) * Math.pow(10, 3 - m.group(1).length());
            }
            if (m.group(3).length() == 4){
                second = Integer.parseInt(m.group(3));
            }else{
                second = Integer.parseInt(m.group(3)) * Math.pow(10, 3 - m.group(3).length());
            }
            
            boolean type;
            if (m.group(2).equals("p")){
                first = (first + 1200);
            }else if (m.group(2).equals("a")){
                first = (first);
            }else{
                System.out.println("Not p or a");
            }
            if (m.group(4).equals("p")){
                second = (second + 1200);
            }else if (m.group(4).equals("a")){
                second = (second);
            }else{
                System.out.println("Not p or a");
            }
            if (first > second){
                if (second - first == 800){
                    type = true;
                }else{
                    type = false;
                }
            }else{
                if (first - second == 800){
                    type = true;
                }else{
                    type = false;
                }
            }
            
            Partial out = new Partial((int)(first), (int)(second), type);
            return out;
    }

    public static Person[] CreateTeam (String[] names, String[] hours){
        int i = 0;
        int size = 0;
        System.out.println(names.length);
        while (names[i] != null){
            size += 1;
            i += 1;
        }
        Person people[] = new Person[size];
        for (i = 0; i < size; i ++){
            Partial part = Helpers.militaryTime(hours[i]);
            people[i] = new Person(names[i], part.start(), part.finish(), part.fullTime());
            //System.out.println(people[i].getName() + " " + people[i].start() + " " + people[i].finish() + " " + people[i].getContract());
        }
        
        return people;
    }
}
