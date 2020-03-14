package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "test1.txt";
        File file = new File(path);

        Scanner scanner = new Scanner(file);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        try {
            while (scanner.hasNext()) {
                arrayList.add(scanner.nextInt());

            }
        } catch (Exception exception) {
            System.out.println("not file");
        }

        Integer[] v = arrayList.toArray(new Integer[arrayList.size()]);

        Locale locale = new Locale("en");
        Locale.setDefault(locale);
        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        Arrays.sort(v);
        int s = 0;
        for (long k : v)
            s += k;
        double per = 0.90 * s / v.length;
        String percentle = decimalFormat.format(per);
        System.out.println(percentle);

        Arrays.sort(v);
        if (v.length % 2 != 0) {
            String median = decimalFormat.format(v[v.length / 2]);
            System.out.println(median);
        } else {
            String median = decimalFormat.format((v[v.length / 2] + v[v.length / 2 - 1]) / 2.0);
            System.out.println(median);
        }


        float ma = Collections.max(arrayList);
        String maximum = decimalFormat.format(ma);
        System.out.println(maximum);

        float mi = Collections.min(arrayList);
        String minimum = decimalFormat.format(mi);
        System.out.println(minimum);

        double sum = 0;
        for (int x : v) {
            sum += x;
        }

        String average = decimalFormat.format(sum / v.length);
        System.out.println(average);

    }
}
