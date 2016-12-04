package Homework9Proj3.Week12Homework.FinalProject;


/**
 * Write a description of class Parital here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Partial
{
    private int startTime;
    private int finishTime;
    private boolean fullTimeVal;
    
    Partial(int first, int second, boolean bool){
        startTime = first;
        finishTime = second;
        fullTimeVal = bool;
    }
    public int start(){
        return startTime;
    }
    public int finish(){
        return finishTime;
    }
    public boolean fullTime(){
        return fullTimeVal;
    }
}
