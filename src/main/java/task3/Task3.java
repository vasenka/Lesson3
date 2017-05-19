package task3;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task3 {
    public static void main(String[] args) {

        Finder finder = new Finder();
        finder.newName();
    }
}
class Finder{

    void newName(){

        List<Integer> numOfPicture = new ArrayList<>();
        numOfPicture.add(0);
        int i = 0;
        boolean oneByOne = true;
        try (BufferedReader br = new BufferedReader(getResource("task3.html"))) {
            while (br.ready()) {
                String string = br.readLine();

                Pattern p = Pattern.compile("(Рис\\. \\d+)");
                Matcher m = p.matcher(string);
                if(m.find()){
                    System.out.println(m.group());
                     String number = m.group().substring(5);
                     numOfPicture.add(Integer.parseInt(number));
                    i++;
                    if (numOfPicture.get(i)<numOfPicture.get(i-1)) {
                        oneByOne = false;
                    }

                }

            }
            if (!oneByOne){
                System.out.println("Автор упоминал рисунки не по порядку!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        static InputStreamReader getResource(String name) throws UnsupportedEncodingException {
        Class<Finder> cls = Finder.class;
        return new InputStreamReader(cls.getResourceAsStream(name),"Cp1251");
    }

}