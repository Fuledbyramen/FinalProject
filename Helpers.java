package Homework9Proj3.Week12Homework.FinalProject;


/**
 * Write a description of class Helpers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.regex.*;
import java.util.*;
public class Helpers
{
    public static Partial militaryTime(String s, int day){
            Pattern p = Pattern.compile("([0-9]+)(a|p)-([0-9]+)(a|p)");
            Matcher m = p.matcher(s);
            m.find();
            double first, second;
            if (m.group(1).length() == 4){
                first = Integer.parseInt(m.group(1));
            }else if (m.group(1).length() == 1){
                first = Integer.parseInt(m.group(1)) * Math.pow(10, 3 - m.group(1).length());
            }else if (m.group(1).length() == 2){
                first = Integer.parseInt(m.group(1)) * 100;
            }else{
                first = Integer.parseInt(m.group(1)) * Math.pow(10, 3 - m.group(1).length());
            }
            if (m.group(3).length() == 4){
                second = Integer.parseInt(m.group(3));
            }else if (m.group(3).length() == 1){
                second = Integer.parseInt(m.group(3)) * Math.pow(10, 3 - m.group(3).length());
            }else if (m.group(3).length() == 2){
                second = Integer.parseInt(m.group(3)) * 100;
            }else{
                second = Integer.parseInt(m.group(3)) * Math.pow(10, 3 - m.group(3).length());
            }
            boolean type;
            if (m.group(2).equals("p")){
                first = (first + 1200);
            }else if (m.group(2).equals("a")){
                if ((int)(first/100) == 12){
                    first = first - 1200;
                }else{
                    first = first;
                }
            }else{
                System.out.println("Not p or a");
            }
            if (m.group(4).equals("p")){
                second = (second + 1200);
            }else if (m.group(4).equals("a")){
                if ((int)(second/100) == 12){
                    second = second - 1200;
                }else{
                    second = (second);
                }
            }else{
                System.out.println("Not p or a");
            }
            
            double fullFirst, fullSecond;
            if (first < 1200){
                fullFirst = first + 2400;
            }else{
                fullFirst = first;
            }
            if (second < 1200){
                fullSecond = second + 2400;
            }else{
                fullSecond = second;
            }

            if (fullFirst > fullSecond){
                if (fullFirst - fullSecond == 800){
                    type = true;
                }else{
                    type = false;
                }
            }else{
                if (fullSecond - fullFirst == 800){
                    type = true;
                }else{
                    type = false;
                }
            }
            
            Partial out = new Partial((int)(first), (int)(second), type);
            return out;
    }
    
    public static Person[] CreateTeam (String[] names){
        int i = 0;
        int size = 0;
        System.out.println(names.length);
        while (names[i] != null){
            size += 1;
            i += 1;
        }
        Person people[] = new Person[size];
        for (i = 0; i < size; i ++){
            people[i] = new Person(names[i]);
        }
        return people;
    }
    
    public static void setHours(Person people[], String[] team, String[] hours, int day){
        int i = 0;
        
        Person workingTeam[] = new Person[hours.length];
        
        int iter = 0;
        for (String name : team){
           for (Person person : people){
               if (person.getName().equals(name)){
                   workingTeam[iter] = person;
                   iter += 1;
                }
            }
        }
        
        for (Person person : workingTeam){
            Partial partial = militaryTime(hours[i], day);
            person.setStart(day, partial.start());
            person.setFinish(day, partial.finish());
            person.setType(partial.fullTime());
        }
        i+=1;
    }
        
    public static void AssignSections (String[] team, Person people[], int day){
        int scheduleSize = team.length;        
        String[][] sections = new String[1][1];
        
        if(scheduleSize == 13)
            sections[0] = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Breaker Front", "Breaker Back", "Front Floater", "Back Floater"};
        else if(scheduleSize == 12)
            sections[0] = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Breaker Front", "Breaker Back", "Float All"};
        else if(scheduleSize == 11)
            sections[0] = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Breaker Front", "Breaker Back"};
        else if(scheduleSize == 10)
            sections[0] = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Breaker All"};
        else if(scheduleSize == 9)
            sections[0] = new String[] {"1", "2", "3", "3,6,7", "6,7,3", "4,5", "5,4", "8,9", "9,8"};
        else if(scheduleSize == 8)
            sections[0] = new String[] {"1,2", "2,1", "3,6,7", "6,7,3", "4,5", "5,4", "8,9", "9,8"};
        else if(scheduleSize == 7)
            sections[0] = new String[] {"1,2", "2,3", "4", "5", "6,7", "8", "9"};
        else if(scheduleSize == 6)
            sections[0] = new String[] {"1,2", "2,3", "6,7", "4,5", "8,9", "Breaker All"};
        else if(scheduleSize == 5)
            sections[0] = new String[] {"1,2", "2,3", "6,7", "4,5", "8,9"};
        else if(scheduleSize == 4)
            sections[0] = new String[] {"1,2,3", "6,7", "4,5", "8,9"};
        else if(scheduleSize == 3)
            sections[0] = new String[] {"1,2,3", "6,7,NSA", "4,5,8,9"};
        
        List<String> sectionList = Arrays.asList(sections[0]);
        
        Person workingTeam[] = new Person[scheduleSize];
        
        int iter = 0;
        for (String name : team){
           for (Person person : people){
               if (person.getName().equals(name)){
                   workingTeam[iter] = person;
                   iter += 1;
                }
            }
        }
        
        for (String section : sectionList){
            int[] temp = new int[scheduleSize];
            int i = 0;
            for (Person person : workingTeam){
                temp[i] = person.getHistory()[convertSection(section)[0]] + 1;
                i += 1;
            }
            int personPos = 0;
            int min = temp[0];
            int minPos = 0;
            int k = -1;
            for (int j : temp){
                k += 1;
                if (j <= min && workingTeam[k].getWeek()[day] == null){
                    min = j;
                    minPos = k;
                }
            }
            if (workingTeam[minPos].getWeek()[day] == null){
                workingTeam[minPos].setSection(day, section);
            }
        }
    }
    
    public static int[] convertSection(String section){
        if (section.equals("Back Floater")){
            int[] out = {13};
            return out;
        }else if (section.equals("Front Floater")){
            int[] out = {12};
            return out;
        }else if (section.equals("Breaker Back")){
            int[] out = {11};
            return out;
        }else if (section.equals("Breaker Front")){
            int[] out = {10};
            return out;
        }else if (section.length() == 1){
            int[] out = {(Integer.parseInt(section)) - 1};
            return out;
        }else if (section.equals("6,7,NSA")){
            int[] out = {5, 6};
            return out;
        }else if (section.length() == 3){
            Pattern p = Pattern.compile("([0-9]),([0-9])");
            Matcher m = p.matcher(section);
            m.find();
            int[] out = {((Integer.parseInt(m.group(1))) - 1), ((Integer.parseInt(m.group(2))) - 1)};
            return out;
        }else if (section.length() == 5){
            Pattern p = Pattern.compile("([0-9]),([0-9]),([0-9])");
            Matcher m = p.matcher(section);
            m.find();
            int[] out = {((Integer.parseInt(m.group(1))) - 1), ((Integer.parseInt(m.group(2))) - 1), ((Integer.parseInt(m.group(3))) - 1)};
            return out;
        }else if (section.equals("Breaker All")){
            int[] out = {10,11,12,13};
            return out;
        }else if (section.length() == 7){
            Pattern p = Pattern.compile("([0-9]),([0-9]),([0-9]),([0-9])");
            Matcher m = p.matcher(section);
            m.find();
            int[] out = {((Integer.parseInt(m.group(1))) - 1), ((Integer.parseInt(m.group(2))) - 1), ((Integer.parseInt(m.group(3))) - 1), ((Integer.parseInt(m.group(4))) - 1)};
            return out;
        }else{
            int[] out = {0};
            return out;
        }
    }
    
    public static void setBreaks(Person team[], int day){
        int len = team.length;
        int[] firsts = new int[len];
        int[] seconds = new int[len];
        int j = 0;
        for (Person person : team){
            System.out.println("first " + firsts[0]);
            int first = person.start()[day];
            int second = person.finish()[day];
            int proposedFirst = first + 230;
            int proposedSecond = proposedFirst + 300;
            System.out.println(first + " " + second);
            System.out.println(proposedFirst + " " + proposedSecond);
            
            proposedFirst = refactor(proposedFirst);
            proposedSecond = refactor(proposedSecond);
            
            boolean good = false;
            boolean streak = false;
            int i = 0;
            while (!good){
                if (i == len){
                    i = 0;
                    if (streak == true){
                        good = true;
                    }else{
                        streak = true;
                    }
                }
                if (proposedFirst == firsts[i]){
                    System.out.println("Overlap");
                    streak = false;
                    int contestedStart = team[i].start()[day];
                    int myStart = person.start()[day];
                    if (myStart <= contestedStart){
                        firsts[i] = firsts[i] + 30;
                    }else{
                        proposedFirst += 30;
                    }
                    proposedFirst = refactor(proposedFirst);
                }
                if (proposedSecond == seconds[i]){
                    streak = false;
                    int contestedFinish = team[i].finish()[day];
                    int myFinish = person.finish()[day];
                    if (myFinish <= contestedFinish){
                        seconds[i] = seconds[i] + 30;
                    }else{
                        proposedSecond += 30;
                    }
                    proposedSecond = refactor(proposedSecond);
                }
                i+=1;
            }
            proposedFirst = refactor(proposedFirst);
            proposedSecond = refactor(proposedSecond);
            person.setBreaks(proposedFirst, proposedSecond, day);
            firsts[j] = proposedFirst;
            seconds[j] = proposedSecond;
            j+=1;
        }
    }
    
    public static int refactor(int value){
        if (value >= 2400){
            value -= 2400;
        }
        if ((value - 60) % 100 == 0){
            value = value + 40;
        }
        return value;
    }
    /*
    public static void setBreaks(Person team[], int day){
        int len = team.length;
        int[] firsts = new int[len];
        int[] seconds = new int[len];
        int j = 0;
        for (Person person : team){
            System.out.println("first " + firsts[0]);
            int first = person.start()[day];
            int second = person.finish()[day];
            int proposedFirst = first + 230;
            int proposedSecond = second + 230;
            System.out.println(first + " " + second);
            System.out.println(proposedFirst + " " + proposedSecond);
            
            proposedFirst = refactor(proposedFirst);
            proposedSecond = refactor(proposedSecond);
            
            boolean good = false;
            boolean streak = false;
            int i = 0;
            while (!good){
                if (i == len){
                    i = 0;
                    if (streak == true){
                        good = true;
                    }else{
                        streak = true;
                    }
                }
                if (proposedFirst == firsts[i]){
                    System.out.println("Overlap");
                    streak = false;
                    int contestedStart = team[i].start()[day];
                    int myStart = person.start()[day];
                    if (myStart <= contestedStart){
                        firsts[i] = refactor(firsts[i] + 30);
                        team[i].setFirstBreaks(firsts[i] +30, day);
                    }else{
                        proposedFirst += 30;
                    }
                    proposedFirst = refactor(proposedFirst);
                }
                if (proposedSecond == seconds[i]){
                    streak = false;
                    int contestedFinish = team[i].finish()[day];
                    int myFinish = person.finish()[day];
                    if (myFinish <= contestedFinish){
                        seconds[i] = refactor(seconds[i] + 30);
                        team[i].setFirstBreaks(seconds[i] + 30, day);
                    }else{
                        proposedSecond += 30;
                    }
                    proposedSecond = refactor(proposedSecond);
                }
                i+=1;
            }
            proposedFirst = refactor(proposedFirst);
            proposedSecond = refactor(proposedSecond);
            person.setBreaks(proposedFirst, proposedSecond, day);
            firsts[j] = proposedFirst;
            seconds[j] = proposedSecond;
            j+=1;
        }
    }
    
    public static int refactor(int value){
        if (value >= 2400){
            value -= 2400;
        }
        if ((value - 60) % 100 == 0){
            value = value + 40;
        }
        return value;
    }
    */
}
