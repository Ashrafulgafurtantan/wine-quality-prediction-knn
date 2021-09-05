package knn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Testing
{
    List<Wine> trainingPoints;
    List<Wine> testPoints;
    List<Distance> resultPoints = new ArrayList<>();
    int testingPointSize;
    int accurate = 0;
    double accuracy = 0;

    public Testing(List<Wine> trainingPoints, List<Wine> testPoints) {
        this.trainingPoints = trainingPoints;
        this.testPoints = testPoints;
        doKNN();
    }

    public void doKNN ()
    {
        for(Wine dataPoint: testPoints)
        {
            for (Wine trainingPoint: trainingPoints)
            {
                Distance distance = new Distance(dataPoint,trainingPoint);
                resultPoints.add(distance);
            }

            Collections.sort(resultPoints,(o1, o2) -> Double.compare(o1.getDistance(), o2.getDistance()));
            if(calcClassName(dataPoint))
                accurate++;

            resultPoints.clear();
        }

        accuracy=(double)accurate/testingPointSize;
    }
    public boolean calcClassName (Wine dataPoint) {
        int maxVal = 0;
        final int[] tempList = new int[11];
        for (int i=0; i<5; i++){
            if(resultPoints.get(i).getAttribute() == dataPoint.quality){
                maxVal++;
            }
            tempList[resultPoints.get(i).getAttribute()]+=1;
        }
        testingPointSize = testPoints.size()-130;
        if(maxVal>=2)
            return true;
        else{
            for(int index = 0;index<11;index++){
                if(tempList[index] >maxVal){
                    return false;
                }
            }
            return true;
        }


    }
    /*
    public boolean calcClassName (Wine dataPoint) {
      Temp  class0=new Temp(0,0);
      Temp  class1=new Temp(1,0);
      Temp  class2=new Temp(2,0);
      Temp  class3=new Temp(3,0);
       Temp class4=new Temp(4,0);
      Temp  class5=new Temp(5,0);
       Temp class6=new Temp(6,0);
      Temp  class7=new Temp(7,0);
      Temp  class8=new Temp(8,0);
      Temp  class9 = new Temp(9,0);
     Temp   class10=new Temp(10,0);


        for (int i=0; i<5; i++){
            System.out.println(resultPoints.get(i).getAttribute());
            if (resultPoints.get(i).getAttribute() == class0.name)
                class0.value +=1;
            else if (resultPoints.get(i).getAttribute() == class1.name)
                class1.value +=1;
            else if (resultPoints.get(i).getAttribute() == class2.name)
                class2.value +=1;
            else if (resultPoints.get(i).getAttribute() == class3.name)
                class3.value +=1;
            else if (resultPoints.get(i).getAttribute() == class4.name)
                class4.value +=1;
            else if (resultPoints.get(i).getAttribute() == class5.name)
                class5.value +=1;
            else if (resultPoints.get(i).getAttribute() == class6.name)
                class6.value +=1;
            else if (resultPoints.get(i).getAttribute() == class7.name)
                class7.value +=1;
            else if (resultPoints.get(i).getAttribute() == class8.name)
                class8.value +=1;
            else if (resultPoints.get(i).getAttribute() == class9.name)
                class9.value +=1;
            else if (resultPoints.get(i).getAttribute() ==  class10.name)
                class10.value +=1;
        }
        List<Temp> tempList = new ArrayList<Temp>();
        tempList.add(class0);
        tempList.add(class1);
        tempList.add(class2);
        tempList.add(class3);
        tempList.add(class4);
        tempList.add(class5);
        tempList.add(class6);
        tempList.add(class7);
        tempList.add(class8);
        tempList.add(class9);
        tempList.add(class10);


        Collections.sort(tempList,(o1, o2) -> Integer.compare(o1.value, o2.value));
         testingPointSize = testPoints.size()-20;

         if(dataPoint.quality == tempList.get(10).name || tempList.get(10).value == tempList.get(9).name )
            return  true;
         else
             return false;

    }

    */

    public double getAccuracy() {
        return accuracy;
    }
}

class Temp{
    int name;
    int value;

    @Override
    public String toString() {
        return "Temp{" +
                "name=" + name +
                ", value=" + value +
                '}';
    }

    public Temp(int name, int value){
        this.name = name;
        this.value = value;
    }
}