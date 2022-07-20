package by.tms.homework.lesson12.task1;
import java.io.*;

public final class Poem {
    public static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public final static int[] VALUE_ALPHABET = new int[ALPHABET.length()];

    private Poem() {}

    public static void calculateNumberOfRepetitionsLetters(File inputFile, File outputFile) {
        if (inputFile != null && inputFile.exists() && inputFile.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    line = line.toUpperCase();
                    for (int i = 0; i < ALPHABET.length(); i++) {
                        for (int j = 0; j < line.length(); j++) {
                            if (ALPHABET.charAt(i) == line.charAt(j)) {
                                VALUE_ALPHABET[i]++;
                            }
                        }
                    }
                }
                StringBuilder builder = new StringBuilder();

                for(int i = 0; i < ALPHABET.length(); i++) {
                    builder.append("Letter ")
                            .append(ALPHABET.charAt(i))
                            .append(": ")
                            .append(VALUE_ALPHABET[i])
                            .append("\n");
                }

                bufferedWriter.write(builder.toString());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
