import java.util.Arrays;

public class StatisticsFromALargeSample {

    public static double[] sampleStats(int[] count) {

        double min = -1, max = -1, mean, median, mode = 0;

        long totalCount = 0;
        long totalSum = 0;

        int modeFreq = 0;

        for (int i = 0; i < 256; i++) {

            if (count[i] > 0) {

                if (min == -1) min = i;
                max = i;

                totalCount += count[i];
                totalSum += (long) i * count[i];

                if (count[i] > modeFreq) {
                    modeFreq = count[i];
                    mode = i;
                }
            }
        }

        mean = (double) totalSum / totalCount;

        long first = (totalCount + 1) / 2;
        long second = (totalCount % 2 == 0) ? first + 1 : first;

        long curr = 0;
        int m1 = 0, m2 = 0;

        for (int i = 0; i < 256; i++) {

            curr += count[i];

            if (curr >= first && m1 == 0)
                m1 = i;

            if (curr >= second) {
                m2 = i;
                break;
            }
        }

        median = (m1 + m2) / 2.0;

        return new double[]{min, max, mean, median, mode};
    }

    public static void main(String[] args) {

        int[] count = new int[256];

        count[1] = 1;
        count[2] = 3;
        count[3] = 4;

        System.out.println(Arrays.toString(sampleStats(count)));
    }
}