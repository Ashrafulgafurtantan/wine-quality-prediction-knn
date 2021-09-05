package knn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {

            double accurate = 0;

            for(int i=0; i<10; i++)
            {
                CrossValidation crossValidation = new CrossValidation();
                crossValidation.getTestAndTrainingData(new File("winequality-white.csv"));
                Testing testing = new Testing(crossValidation.trainingPoints,crossValidation.testPoints,false);
                accurate = accurate +testing.getAccuracy();
            }

            System.out.println("Accuracy: " + accurate*100/10.0);
            while (true){
                System.out.print(" Chose one:\n1.Test\n2.Exit\n");

                Scanner sc = new Scanner(System.in);
                if(sc.nextInt() == 2)
                    break;
                else{
                    System.out.println("Give us data,use ; as a delimiter.eg(6.6;0.34;0.4;8.1;0.046;68;170;0.99494;3.15;0.5;9.55;6)");
                    Scanner dataLine = new Scanner(System.in);
                    System.out.println();
                    String temp = dataLine.next();

                    Scanner tempScanner = new Scanner(temp).useDelimiter(";");

                    Wine wine = new Wine(
                            tempScanner.nextDouble(),tempScanner.nextDouble(),tempScanner.nextDouble(),
                            tempScanner.nextDouble(),tempScanner.nextDouble(),tempScanner.nextDouble(),tempScanner.nextDouble(),
                            tempScanner.nextDouble(),tempScanner.nextDouble(),tempScanner.nextDouble(),tempScanner.nextDouble());
                    System.out.println(wine.toString());
                    CrossValidation crossValidation = new CrossValidation();
                    crossValidation.getTestAndTrainingData(new File("winequality-white.csv"));
                    List<Wine> singleTestPoint = new ArrayList<Wine>();
                    singleTestPoint.add(wine);
                    Testing testing = new Testing(crossValidation.trainingPoints,singleTestPoint,true);
                }


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
