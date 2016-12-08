package Homework9Proj3.Week12Homework.FinalProject;


import java.util.regex.*;
public class Person
{
    private String name;
    private boolean pregnant = false;
    private boolean fullTime;
    private int[] starts = new int[7];
    private int[] finishes = new int[7];
    private String[] week = new String[7];
    private int[] history = {0,0,0,0,0,0,0,0,0,0,0,0,0};
    private int[] firstBreaks = new int[7];
    private int[] secondBreaks = new int[7];
    //holds an array of their past sections
    //weekday is associated by index ie - 
    //0 == monday, 1 == tuesday etc
    //breaker front = 12, breaker back = 13, float all = 14
    
    public Person(String localName){
        name = localName;
    }
    public String getName(){
        return name;
    }
    public void setPregnancy(){
        pregnant = true;
    }
    public boolean getPregnancy(){
        return pregnant;
    }
    public boolean getContract(){
        return fullTime;
    }
    public void setStart(int day, int start){
        starts[day] = start;
    }
    public void setFinish(int day, int finish){
        finishes[day] = finish;
    }
    public void setShift(int day, int start, int finish){
        starts[day] = start;
        finishes[day] = finish;
    }
    public void setType(boolean type){
        fullTime = type;
    }
    public int[] start(){
        return starts;
    }
    public int[] finish(){
        return finishes;
    }
    //called by saying the weekday ie 3 for thursday
    public void setSection(int day, String section){
        week[day] = section;
        int[] sections = Helpers.convertSection(section);
        for (int sect : sections){
            history[sect] += 1;
        }
    }
    public String[] getWeek(){
        return week;
    }
    public int[] getHistory(){
        return history;
    }
    public void setBreaks(int first, int second, int day){
        firstBreaks[day] = first;
        secondBreaks[day] = second;
    }
    public void setFirstBreaks(int first, int day){
        firstBreaks[day] = first;
    }
    public void setSecondBreaks(int second, int day){
        secondBreaks[day] = second;
    }
    public int[] firstBreaks(){
        return firstBreaks;
    }
    public int[] secondBreaks(){
        return secondBreaks;
    }
}