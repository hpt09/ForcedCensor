package gui;

import javafx.concurrent.Task;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BashTask extends Task {

    private String command;

    public BashTask(String c){
        this.command = c;
    }

    @Override
    protected Object call() throws Exception {
        try {

            //creates the command and executes it


            System.out.println(command);

            ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);

            Process process = pb.start();

            BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stderr = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            int exitStatus = process.waitFor();

            //if it passes or fails, print out the error/ success statement
            if (exitStatus == 0) {
                String line;
                while ((line = stdout.readLine()) != null) {
                    System.out.println(line);
                }
            } else {
                String line;
                while ((line = stderr.readLine()) != null) {
                    System.err.println(line);
                }
            }

        } catch (Exception f) {
            f.printStackTrace();
        }
        return null;
    }
}
