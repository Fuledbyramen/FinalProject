package Homework9Proj3.Week12Homework.FinalProject;


/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    public static void main(String args[]){
        String[] names = {"Manuel", "Brenda", "John", "Ariana", "Jenn", "Jasmine","Mark", "Jeremy", "Kevin", "Michael", "Jakee", null, null, null};
        String[] hours = {"415p-1115p", "5p-1a", "530p-130a", "6p-2a", "4p-12a", "10a-5p", "630p-230a", "530p-1230a", "330p-1130p", "430p-1230a", "330p-1130p", null, null, null};
        
        Person team[] = Helpers.CreateTeam(names, hours);
        for (Person people : team){
            System.out.println(people.getName() + " " + people.start() + " " + people.finish() + " " + people.getContract());
        }
        
        //output 
        /* 
        Manuel 1615 2315 false
        Brenda 1205 5 false
        John 1730 530 false
        Ariana 1206 6 false
        Jenn 1204 4 false
        Jasmine 10 1205 false
        Mark 1830 630 false
        Jeremy 1730 530 false
        Kevin 1530 2330 true
        Michael 1630 430 false
        Jakee 1530 2330 true

         */
    }
}
