package corejavarefresher.c_controlFlows;

/*
 * This file gives example of Switch statement.
 * Student need to understand the program and find out the output 
 * first without running the program and then verify answers 
 * after executing the program.
 */

public class SwitchStatement {
    public static void main(String[] args) {

        int dayofWeekInNumber=6;
        String weekday = "Not Set";
        switch (dayofWeekInNumber) {        
            case 1:  weekday = "Monday";
                     break;
            case 2:  weekday = "Tuesday";
                     break;
            case 3:  weekday = "Wednesday";
                     break;
            case 4:  weekday = "Thursday";
                     break;
            case 5:  weekday = "Friday";
                     break;
            case 6:  weekday = "Saturday";
                     break;
            case 7:  weekday = "Sunday";
                     break;
            default: weekday = "Not a proper Weekday";
                     break;
        }
        System.out.println(weekday);
    }
}