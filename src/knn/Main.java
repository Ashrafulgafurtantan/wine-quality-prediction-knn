package knn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {

            double accurate = 0;

            for(int i=0; i<10; i++)
            {
                CrossValidation crossValidation = new CrossValidation();
                crossValidation.getTestAndTrainingData(new File("winequality-white.csv"));
                Testing testing = new Testing(crossValidation.trainingPoints,crossValidation.testPoints);
                accurate = accurate +testing.getAccuracy();
            }

            System.out.println("Accuracy: " + accurate*100/10.0);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
