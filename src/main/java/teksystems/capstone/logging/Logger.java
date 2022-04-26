package teksystems.capstone.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    public static void writeLog(String info) throws IOException {
        System.out.println("Good morning starshine. The earth says hello.");

        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("writefile.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(info);
            bufferedWriter.append("\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
