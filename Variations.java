import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Variations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int z = scanner.nextInt();
        scanner.nextLine();
        String[] xy = scanner.nextLine().split(" ");
        String x = xy[0];
        String y = xy[1];
        List<String> variations = generateVariations(z, x, y);
        Collections.sort(variations);
        for (String variation : variations) {
            System.out.println(variation);
        }
    }

    private static List<String> generateVariations(int z, String x, String y) {
        List<String> variations = new ArrayList<>();
        generateVariationsHelper(z, x, y, "", variations);
        return variations;
    }

    private static void generateVariationsHelper(int z, String x, String y, String currentVariation, List<String> variations) {
        if (z == 0) {
            variations.add(currentVariation);
            return;
        }
        generateVariationsHelper(z - 1, x, y, currentVariation + x, variations);
        generateVariationsHelper(z - 1, x, y, currentVariation + y, variations);
    }
}