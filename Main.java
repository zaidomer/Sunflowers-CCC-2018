import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int numFlowers = input.nextInt();
        int rowCount = 0;
        boolean matchFound = false;
        String[] stringNumberArray = new String[numFlowers*numFlowers];
        int[][] measurements = new int[numFlowers][numFlowers];
        for(int i = 0; i < stringNumberArray.length; i++) {
            stringNumberArray[i] = input.next();
        }

        for(int i = 0; i < numFlowers; i++) {
            for(int j = 0; j < numFlowers; j++) {
                measurements[i][j] = Integer.parseInt(stringNumberArray[rowCount]);
                rowCount++;
            }
        }

        while(matchFound == false){
            measurements = rotate(measurements, numFlowers);
            matchFound = bubbleCheck(measurements, numFlowers);
        }
         for(int i = 0; i < numFlowers; i++) {
            for(int j = 0; j < numFlowers; j++) {
                System.out.print(measurements[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rotate(int[][] measurements, int numFlowers) {
        int[][] newMeasurements = new int[numFlowers][numFlowers];
        int rowCount = 0;
        int columnCount = 0;
        for(int j = numFlowers-1; j >= 0; j--){
            for(int i = 0; i < numFlowers; i++) {
                newMeasurements[rowCount][columnCount] = measurements[i][j];
                columnCount++;
            }
            rowCount++;
            columnCount = 0;
        }
        return newMeasurements;
    }

    public static boolean bubbleCheck(int[][] measurements, int numFlowers) {
        boolean matchFound = true;
        for(int i = 0; i < numFlowers; i++) {
            for(int j = 0; j < numFlowers-1; j++) {
                if(measurements[i][j] > measurements[i][j+1]) {
                    matchFound = false;
                } else if(measurements[j][i] > measurements[j+1][i]) {
                    matchFound = false;
                }
            }
        }
        return matchFound;
    }
}