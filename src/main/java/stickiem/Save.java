package stickiem;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Deals with memory.
 */
public class Save {
    private final File file;

    public Save(String filePath) {

        this.file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        assert file.exists();


    }

    public void save(ArrayList<String> details) {
        assert file.exists();
        try {

            FileWriter fw = new FileWriter(file);
            String input = "";
            for (String detail : details) {

                input += detail + System.lineSeparator();
            }
            fw.write(input);
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }


    }

    public ArrayList<String> load() {
        ArrayList<String> details = new ArrayList<>();
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                details.add(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return details;
    }
}
