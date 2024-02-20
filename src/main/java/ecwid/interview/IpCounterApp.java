package ecwid.interview;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;


public class IpCounterApp {

    private static void processFile(String fileName) {

        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {

            BitSetContainer bitSetContainer = new BitSetContainer();
            long linesProcessed = 0;
            String line;

            while ((line = in.readLine()) != null) {

                bitSetContainer.registerLongHashValue(IpToLongValueConverter.ipHashFunction(line));
                linesProcessed++;

            }

            System.out.print("Total of " + linesProcessed + "  IP addresses processed, from which "
                    + bitSetContainer.getUniqueCount() + " where unique");

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }


    public static void main(String[] args) {

        if (Files.exists(Paths.get(args[0]))) {

            processFile(args[0]);

        } else {

            System.out.println("File " +args[0] + " doesn't exist");

        }

    }

}