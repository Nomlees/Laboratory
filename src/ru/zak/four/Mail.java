package ru.zak.four;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail {
    private static final String IN_FILE_TXT = "src\\ru\\zak\\three\\pokemon.txt";
    private static final String IN_URL = "https://www.py4e.com/code3/mbox.txt";

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(IN_FILE_TXT));
        URL url = new URL(IN_URL);
        int count = 0;
        URLConnection connection = url.openConnection();
        try (InputStream input = connection.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            while (reader.ready()) {
                String temp = reader.readLine();
                //Pattern probab = Pattern.compile("X\\-DSPAM\\-Probability.+");
               // Matcher m1 = probab.matcher(temp);
                Pattern conf = Pattern.compile("X\\-DSPAM\\-Confidence.+");
                Matcher m2 = conf.matcher(temp);


                Pattern from = Pattern.compile("From.+");
                Matcher m3 = conf.matcher(temp);

                //while (m1.find()) {
                  //  System.out.println(temp);
                 //   count++;
                //}
              while (m2.find()) {
                 System.out.println(temp);
                  writer.write(m2.group());
                   count++;
               }
                while (m3.find()) {
                    System.out.println(temp);
                    count++;
                }

            }
        }
        System.out.println(count);
    }
}