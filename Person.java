package Homework9Proj3.Week12Homework.FinalProject;
public class Person
{
    private String name;
    private boolean pregnant = false;
    private boolean fullTime;
    private int startTime;
    private int finishTime;
    private int[] history = new int[7];
    //holds an array of their past sections
    //weekday is associated by index ie - 
    //0 == monday, 1 == tuesday etc
    //breaker front = 12, breaker back = 13, float all = 14
    
    public Person(String localName, int start, int finish, boolean type){
        name = localName;
        startTime = start;
        finishTime = finish;
        fullTime = type;
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
    public int start(){
        return startTime;
    }
    public int finish(){
        return finishTime;
    }
    //called by saying the weekday ie 3 for thursday
    public void setSection(int day, int section){
        history[day] = section;
    }
    public int[] getHistory(){
        return history;
    }
}