package knn;


import java.util.Comparator;

public class Distance
{
    private double distance;
    private int attribute;

    private Wine testPoint;
    private Wine trainingPoint;

    public Distance(Wine testPoint, Wine trainingPoint) {
        this.testPoint = testPoint;
        this.trainingPoint = trainingPoint;

        calcDistance();
    }

    @Override
    public String toString() {
        return "Distance{" +
                "distance=" + distance +
                ", attribute=" + attribute +
                '}';
    }

    private void calcDistance ()
    {
        distance = Math.sqrt(
            Math.pow(testPoint.fixed_acidity-trainingPoint.fixed_acidity,2)+
            Math.pow(testPoint.volatile_acidity-trainingPoint.volatile_acidity,2)+
            Math.pow(testPoint.citric_acid-trainingPoint.citric_acid,2)+
            Math.pow(testPoint.residual_sugar-trainingPoint.residual_sugar,2)+
            Math.pow(testPoint.chlorides-trainingPoint.chlorides,2)+
            Math.pow(testPoint.free_sulfur_dioxide-trainingPoint.free_sulfur_dioxide,2)+
            Math.pow(testPoint.total_sulfur_dioxide-trainingPoint.total_sulfur_dioxide,2)+
            Math.pow(testPoint.density-trainingPoint.density,2)+
            Math.pow(testPoint.pH-trainingPoint.pH,2)+
            Math.pow(testPoint.sulphates-trainingPoint.sulphates,2)+
            Math.pow(testPoint.alcohol-trainingPoint.alcohol,2)
        );

        attribute = trainingPoint.quality;
    }

    public double getDistance() {
        return distance;
    }

    public int getAttribute() {
        return attribute;
    }


}
