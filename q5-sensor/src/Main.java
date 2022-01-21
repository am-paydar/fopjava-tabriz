import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float data, sum = 0, min = Float.MAX_VALUE, max = -Float.MAX_VALUE, previousData = 0, temp,
                firstIncrementalData = 0, lastIncrementalData = 0, maxIncrementalInterval = -Float.MAX_VALUE,
                firstDecrementalData = 0, lastDecrementalData = 0, maxDecrementalInterval = -Float.MAX_VALUE;
        int average, index = 0, stabilityCount = 0, maxStabilityInterval = 0;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextFloat()) {
            data = scanner.nextFloat();

            if (index != 0) {

                //processing stability interval
                if (data == previousData) {
                    stabilityCount += 1;
                } else {

                    if (stabilityCount > maxStabilityInterval) {


                        maxStabilityInterval = stabilityCount;
                    }
                    stabilityCount = 0;


                }


                //processing Increasing interval
                if (data > previousData) {
                    lastIncrementalData = data;
                } else {
                    temp = lastIncrementalData - firstIncrementalData;
                    if (temp > maxIncrementalInterval) {
                        maxIncrementalInterval = temp;
                    }
                    firstIncrementalData = data;
                    lastIncrementalData = data;
                }

                //processing Decreasing interval
                if (data < previousData) {
                    lastDecrementalData = data;
                } else {
                    temp = firstDecrementalData - lastDecrementalData;

                    if (temp > maxDecrementalInterval) {
                        maxDecrementalInterval = temp;
                    }
                    firstDecrementalData = data;
                    lastDecrementalData = data;
                }


            }


            //for calculating min data
            if (min > data) {
                min = data;
            }
            //for calculating max data
            if (data > max) {
                max = data;
            }

            sum += data;

            index += 1;

            //for storing first interval
            if (index == 1) {
                firstIncrementalData = data;
                firstDecrementalData = data;


            }

            previousData = data;


        }
        average = Math.round(sum / index);
        maxIncrementalInterval = Math.max(maxIncrementalInterval, lastIncrementalData - firstIncrementalData);
        maxDecrementalInterval = Math.max(maxDecrementalInterval, firstDecrementalData - lastDecrementalData);
        maxStabilityInterval = Math.max(maxStabilityInterval, stabilityCount) + 1;


        System.out.println(Math.round(maxIncrementalInterval) + "," + Math.round(maxDecrementalInterval) + "," +
                maxStabilityInterval + "," + Math.round(max) + "," + Math.round(min) + "," + average);


    }
}
