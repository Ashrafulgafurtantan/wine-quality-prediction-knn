package knn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CrossValidation {
    public List<Wine> points = new ArrayList<Wine>();
    public List<Wine> trainingPoints = new ArrayList<Wine>();
    public List<Wine> testPoints = new ArrayList<Wine>();
    public void getTestAndTrainingData (File file) throws FileNotFoundException {

        Scanner cin = new Scanner(file);

        while (cin.hasNextLine())
        {
            String temp = cin.nextLine();

            Scanner tempScanner = new Scanner(temp).useDelimiter(";");
            Wine wine = new Wine(
                    tempScanner.nextDouble(),tempScanner.nextDouble(),tempScanner.nextDouble(), tempScanner.nextDouble(),tempScanner.nextDouble(),tempScanner.nextDouble(),tempScanner.nextDouble(),
                    tempScanner.nextDouble(),tempScanner.nextDouble(),tempScanner.nextDouble(),tempScanner.nextDouble(),tempScanner.nextInt());
            points.add(wine);

            tempScanner.close();
        }
        cin.close();
        System.out.println(points.size());
        for(int i=0; i<points.size()/10; i++)
        {
            Random rand = new Random();
            int temp = rand.nextInt(points.size());
            if(points.get(temp)==null)
            {
                i--;
                continue;
            }
            testPoints.add(points.get(temp));
            points.set(temp,null);
        }

        for(int i=0; i<points.size(); i++)
        {
            if(points.get(i)==null)
                continue;

            trainingPoints.add(points.get(i));
        }
    }
}
