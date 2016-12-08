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
        String[] mondayTeam = {"Manuel", "Brenda", "John", "Ariana", "Jenn", "Jasmine", "Jeremy", "Kevin", "Michael"};
        String[] tuesdayTeam = {"Manuel", "John", "Jenn", "Ariana", "Jenn", "Jasmine", "Mark", "Kevin", "Michael"};
        
        //Create classes for the whole team
        Person team[] = Helpers.CreateTeam(names);
        //Assign hours to each team member
        Helpers.setHours(team, hours, 0);
        
        Helpers.AssignSections(mondayTeam, team, 0);
        Helpers.AssignSections(mondayTeam, team, 1);
        Helpers.AssignSections(mondayTeam, team, 2);
        Helpers.AssignSections(mondayTeam, team, 3);
        Helpers.AssignSections(mondayTeam, team, 4);
        Helpers.AssignSections(mondayTeam, team, 5);
        Helpers.AssignSections(mondayTeam, team, 6);
        
        Helpers.setBreaks(team, 0);
        
        /*
        for (Person people : team){
            System.out.println(people.getName() + " " + people.getHistory()[0] + " " + people.getHistory()[1]+ " " + people.getHistory()[2]+ " " + people.getHistory()[3]
            + " " + people.getHistory()[4] + " " + people.getHistory()[5]+ " " + people.getHistory()[6]+ " " + people.getHistory()[7] + " " + people.getHistory()[8] + " " + people.getHistory()[9]+ " " + people.getHistory()[10]+ " " + people.getHistory()[11]
            + " " + people.getHistory()[12]);
        }
        */
        for (Person people : team){
            System.out.print(people.getName() + " ");
            for (String s : people.getWeek()){
                System.out.print(s + " ");
            }
            System.out.print("\n");
        }
        for (Person person : team){
            System.out.println(person.getName() + " " + person.start()[0] + " - " + person.finish()[0]);
            System.out.println(person.firstBreaks()[0] + " " + person.secondBreaks()[0]);
        }

        
        //output 
        /* 
        Manuel 1615 - 2315
        Brenda 1700 - 100
        John 1730 - 130
        Ariana 1800 - 200
        Jenn 1600 - 0
        Jasmine 1000 - 1700
        Mark 1830 - 230
        Jeremy 1730 - 30
        Kevin 1530 - 2330
        Michael 1630 - 30
        Jakee 1530 - 2330

         */
    }
}
