package testData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EmailGenerator {

    private static final String COUNTER_FILE = "emailCounter.txt";

    private int readCounterFromFile() throws IOException {
        Path path = Paths.get(COUNTER_FILE);
        if (Files.exists(path)) {
            String content = new String(Files.readAllBytes(path));
            return Integer.parseInt(content.trim());
        } else {
            return 1;
        }
    }

    private void writeCounterToFile(int counter) throws IOException {
        Files.write(Paths.get(COUNTER_FILE), Integer.toString(counter).getBytes());
    }

    public String generateUniqueEmail() throws IOException {
        int counter = readCounterFromFile();
        counter++;
        writeCounterToFile(counter);
        return "autotest" + counter + "@gmail.nl";
    }




}
