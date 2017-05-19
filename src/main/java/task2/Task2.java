package task2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;


import java.util.Locale;

import java.util.ResourceBundle;

public class Task2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
class MyFrame extends JFrame {
    StartPanel panel= new StartPanel();
    LangPanel panelRus;
    LangPanel panelEng;
      MyFrame() throws UnsupportedEncodingException {
          panelRus = new LangPanel("RU","RU");
          panelEng = new LangPanel("US","EN");
          setTitle("Questions");
          setSize(1000,500);

          JMenuBar menuBar = new JMenuBar();
          setJMenuBar(menuBar);
          JMenu language = new JMenu("Language");
          menuBar.add(language);

          JMenuItem rus = new JMenuItem("Rus");
          JMenuItem eng = new JMenuItem("Eng");
          language.add(rus);
          language.add(eng);
          panel.setVisible(true);
          add(panel);

          rus.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  panel.setVisible(false);
                  panelEng.setVisible(false);
                  panelRus.setVisible(true);
                  add(panelRus);
              }
          });
          eng.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  panel.setVisible(false);
                  panelRus.setVisible(false);
                  panelEng.setVisible(true);
                  add(panelEng);
              }
          });
      }
}
class StartPanel extends JPanel {

    JLabel label;
    String photo = "src/main/resources/task2/up1_EPAM1.jpg";
    StartPanel() {
        Image img = Toolkit.getDefaultToolkit().getImage(photo);
        label = new JLabel();
        label.setIcon(new ImageIcon(img));
        add(label);
    }
}
class LangPanel extends JPanel{
    JTextArea taQuestion;
    JLabel label;
    JTextField tf;
    JButton button;
    JTextArea taAnswer;
    String country;
    String language;
      LangPanel(String country, String language) throws UnsupportedEncodingException {

          setLayout(null);
          this.country = country;
          this.language = language;
          Locale current = new Locale(language, country);

          ResourceBundle rb = ResourceBundle.getBundle("task2.questions", current);

          String s1 = new String(rb.getString("str1").getBytes("ISO-8859-1"), "UTF-8");
          String s2 = new String(rb.getString("str2").getBytes("ISO-8859-1"), "UTF-8");
          String s3 = new String(rb.getString("str3").getBytes("ISO-8859-1"), "UTF-8");
          String s4 = new String(rb.getString("str4").getBytes("ISO-8859-1"), "UTF-8");
          String s5 = new String(rb.getString("str5").getBytes("ISO-8859-1"), "UTF-8");


          taQuestion = new JTextArea();
          taQuestion.setText(s1+'\n'+s2+'\n'+s3 +'\n'+s4+'\n'+s5);

          ResourceBundle rbSettings = ResourceBundle.getBundle("task2.settings", current);
          String labelStr = new String(rbSettings.getString("str1").getBytes("ISO-8859-1"),"UTF-8");
          String buttonStr = new String(rbSettings.getString("str2").getBytes("ISO-8859-1"),"UTF-8");

          label = new JLabel(labelStr);
          tf = new JTextField();

          button = new JButton(buttonStr);
          taAnswer = new JTextArea();

          button.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {

                  ResourceBundle rb = ResourceBundle.getBundle("task2.answers", current);
                  try {
                      String ans1 = new String(rb.getString("str1").getBytes("ISO-8859-1"), "UTF-8");
                      String ans2 = new String(rb.getString("str2").getBytes("ISO-8859-1"), "UTF-8");
                      String ans3 = new String(rb.getString("str3").getBytes("ISO-8859-1"), "UTF-8");
                      String ans4 = new String(rb.getString("str4").getBytes("ISO-8859-1"), "UTF-8");
                      String ans5 = new String(rb.getString("str5").getBytes("ISO-8859-1"), "UTF-8");
                      String ans6 = new String(rb.getString("str6").getBytes("ISO-8859-1"), "UTF-8");


                      switch (tf.getText()) {
                          case "1": {
                              taAnswer.setText(ans1);
                              break;
                          }
                          case "2": {
                              taAnswer.setText(ans2);
                              break;
                          }
                          case "3": {
                              taAnswer.setText(ans3);
                              break;
                          }
                          case "4": {
                              taAnswer.setText(ans4);
                              break;
                          }
                          case "5": {
                              taAnswer.setText(ans5);
                              break;
                          }
                          default: {
                              taAnswer.setText(ans6);
                              break;
                          }
                      }
                  } catch (UnsupportedEncodingException e1) {
                      e1.printStackTrace();
                  }
              }
          });

          taQuestion.setBounds(10,10,500,100);
          label.setBounds(10,120,150,30);
          tf.setBounds(160,120,50,30);
          button.setBounds(230,120,100,30);
          taAnswer.setBounds(10,160,500,30);

          add(taQuestion);
          add(label);
          add(tf);
          add(button);
          add(taAnswer);

          System.out.println("test");
      }
}
