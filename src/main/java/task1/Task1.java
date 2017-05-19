package task1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {

        CrazyLogger cl = new CrazyLogger();
        String[] test3 = new String[3];
        try {
            System.out.println("test");
            cl.writeFine();

            System.out.println("test2");
            cl.writeFine();

            for (int i = 0; i <4 ; i++) {
                System.out.println(test3[i]);
            }
            cl.writeFine();
        } catch (IndexOutOfBoundsException e) {
            cl.writeError("Index out of bounds");
        }
        catch (Exception e) {
            cl.writeError("Unknown error");
        }
    cl.find("Error");
    System.out.println();
    cl.printAllLog();
    System.out.println();
    cl.printEr();
    System.out.println();
    cl.printFine();

    }
}
class CrazyLogger{
    Date date = new Date();
    SimpleDateFormat formatD = new SimpleDateFormat("dd-MM-yyyy hh:mm");
    String s = formatD.format(date);
    StringBuilder sb = new StringBuilder();
    List<String> log = new ArrayList<>();
    void writeFine(){
        sb.append(s);
        sb.append("  -  ");
        sb.append("Done without errors");
        log.add(sb.toString());
        sb.setLength(0);
    }
    void writeError(String er){
        sb.append(s);
        sb.append("  -  ");
        sb.append("Error: "+er);
        log.add(sb.toString());
        sb.setLength(0);
    }
    void find(String toFind) {
        for (int i = 0; i < log.size(); i++) {
            if (log.get(i).contains(toFind)) {
                System.out.println(log.get(i));
            }
        }
    }
    void printAllLog(){
        for (int i = 0; i < log.size(); i++) {
            System.out.println(log.get(i));
        }
    }
    void printEr(){
        for (int i = 0; i < log.size(); i++) {
            if (log.get(i).contains("Error:")) {
                System.out.println(log.get(i));
            }
        }
    }
    void printFine(){
        for (int i = 0; i < log.size(); i++) {
            if (!log.get(i).contains("Error:")) {
                System.out.println(log.get(i));
            }
        }
    }

}