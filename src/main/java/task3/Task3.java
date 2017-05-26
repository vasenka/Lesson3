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
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(getResource("task3.html"))) {
            while (br.ready()) {
                sb.setLength(0);
                String string = br.readLine();

                Pattern p = Pattern.compile("(Р|р)ис[унке]*\\.* \\d+[^&]{2}");
                Matcher m = p.matcher(string);

                Pattern p2 = Pattern.compile("[А-Я]{1}[^А-Я]*(НМ[^А-Я]*){0,2}([СО]<sub>[^А-Я]*)?(НМ[^А-Я]*|(С\\d+)?[^А-Я]*){0,2}(\\(?(на )?[Рр]ис(унке)?\\.* \\d+\\)?[^А-Я]*(НМ[^А-Я]*){0,2}([СО]<sub>[^А-Я]*)?(НМ[^А-Я]*|(С\\d+)?[^А-Я]*){0,2})+[\\.\\?!]");
             //   Pattern p2 = Pattern.compile("[А-Я]{1}[^А-Я]*((НМ|[СО]<sub>|(С\\d+)?)[^А-Я]*){0,3}(\\(?(на )?[Рр]ис(унке)?\\.* \\d+\\)?[^А-Я]*(НМ[^А-Я]*){0,2}([СО]<sub>[^А-Я]*)?(НМ[^А-Я]*|(С\\d+)?[^А-Я]*){0,2})+[\\.\\?!]");

                Matcher m2 = p2.matcher(string);

                while (m2.find())       {

                    System.out.println(m2.group());
                }

                while (m.find()) {

                    String number = m.group();//.substring(5);
                    if ((m.group().length()==8)) {//|(m.group().length()==9)) {
                        numOfPicture.add(Integer.parseInt(""+number.charAt(5)));
                    } else if ((m.group().length()==9)) {
                        numOfPicture.add(Integer.parseInt(""+number.charAt(5)+number.charAt(6)));
                    } else if ((m.group().length()==11)) {
                        numOfPicture.add(Integer.parseInt(""+number.charAt(8)));
                    } else {
                        numOfPicture.add(Integer.parseInt(""+number.charAt(8)+number.charAt(9)));
                    }

                    i++;
                    if (numOfPicture.get(i)<numOfPicture.get(i-1)) {
                        oneByOne = false;
                    }

                }


            }
            if (!oneByOne){
                System.out.println("\n");
                System.out.println("Автор упоминал рисунки не по порядку!");
                //System.out.println(numOfPicture);
            } else {
                System.out.println("\n");
                System.out.println("Автор упоминал рисунки по порядку!");
              //  System.out.println(numOfPicture);
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