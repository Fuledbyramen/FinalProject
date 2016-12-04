package Homework9Proj3.Week12Homework.FinalProject;
/**
 * Write a description of class CreatePerson here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class CreatePerson
{
    public static void main(String args[]){
        String[] names = {"Manuel", "Brenda", "John", "Ariana", "Jenn", "Jasmine","Mark", "Jeremy", "Kevin", "Michael", "Jakee", null, null, null};
        String[] hours = {"415p-1115p", "5p-1a", "530p-130a", "6p-2a", "4p-12a", "10a-5p", "630p-230a", "530p-1230a", "330p-1130p", "430p-1230a", "330p-1130p", null, null, null};
        
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
            System.out.println(people[i].getName() + " " + people[i].start() + " " + people[i].finish() + " " + people[i].getContract());
        }
        
        
        /*
        int size = 7;
        Person people[] = new Person[size];
        String[] names = new String[size];
        names[0] = "jack";
        names[1] = "sally";
        names[2] = "Marvin";
        names[3] = "Harrison";
        
        boolean[] pregnant = new boolean[size];
        String current = names[0];
        int i = 0;
        while (current != null){
            people[i] = new Person(names[i]);
            i += 1;
            current = names[i];
        }
        i = 0;
        while (people[i] != null){
            System.out.println(people[i].getName());
            i += 1;
        }
        */
    }
}