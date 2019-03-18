package day6;



public class MyCar {

    int modelYear;

    String modelName;




    public MyCar(int year, String name) {
        modelYear = year;
        modelName = name;
    }
    public static void main(String[] args) {
        Car myCar = new Car(2012, "Infiniti");
        System.out.println(myCar.modelYear + " " + myCar.modelName);
    }
}

