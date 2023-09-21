import java.io.*;
import java.text.*;
import java.math.*;

public class TaylorArcsin {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int numberK = 0;
        double numberX = 0;

        System.out.println("Enter k (accuracy):");
        try {
            String line = br.readLine();
            numberK = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Not an integer");
        } catch (IOException e) {
            System.out.println("Keyboard reading error");
        }

        System.out.println("Enter x (-1, 1) to calculate arcsin(x):");
        try {
            String line = br.readLine();
            numberX = Double.parseDouble(line);
        } catch (IOException e) {
            System.out.println("Keyboard reading error");
        }

        double eps = 1 / Math.pow(10, numberK * 2);
        double element = numberX;
        double arcsinus = numberX;
        int i = 1;
        while (Math.abs(element) > eps) {
            element = element * (2 * i - 1) * numberX * numberX / (2 * i);
            arcsinus = arcsinus + element / (2 * i + 1);
            i++;
        }

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(numberK);
        System.out.println(formatter.format(arcsinus));
        System.out.println(formatter.format(Math.asin(numberX)));
    }
}