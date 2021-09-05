package knn;

public class Wine {
    public double fixed_acidity;
    public  double  volatile_acidity;
    public  double  citric_acid;
    public  double  residual_sugar;
    public  double  chlorides;
    public  double  free_sulfur_dioxide;
    public  double  total_sulfur_dioxide;

    @Override
    public String toString() {
        return "Wine{" +
                "fixed_acidity=" + fixed_acidity +
                ", volatile_acidity=" + volatile_acidity +
                ", citric_acid=" + citric_acid +
                ", residual_sugar=" + residual_sugar +
                ", chlorides=" + chlorides +
                ", free_sulfur_dioxide=" + free_sulfur_dioxide +
                ", total_sulfur_dioxide=" + total_sulfur_dioxide +
                ", density=" + density +
                ", pH=" + pH +
                ", sulphates=" + sulphates +
                ", alcohol=" + alcohol +
                ", quality=" + quality +
                '}';
    }

    public double  density;
    public  double  pH;
    public double sulphates;
    public double alcohol;
    public  int quality;

    public Wine() {
    }

    public Wine(
            double fixed_acidity,
                double    volatile_acidity,
                double    citric_acid,
                double    residual_sugar,
                 double   chlorides,
                double    free_sulfur_dioxide,
                  double  total_sulfur_dioxide,
                 double   density,
                 double   pH,
              double      sulphates,
              double      alcohol, int quality
    ) {
    this.fixed_acidity = fixed_acidity;
    this.volatile_acidity = volatile_acidity;
    this.citric_acid = citric_acid;
    this.residual_sugar = residual_sugar;
    this.chlorides = chlorides;
    this.free_sulfur_dioxide = free_sulfur_dioxide;
    this.total_sulfur_dioxide = total_sulfur_dioxide;
    this.density = density;
    this.pH = pH;
    this.sulphates = sulphates;
    this.alcohol = alcohol;
    this.quality = quality;
    }



}
