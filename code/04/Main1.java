public class Main1 {

 public static void main(String[] args) {
  // 5 db valtozo - ötös lottón
  // Az én szerencseszámaim: 2, 5, 7, 24, 32

  int luckyNumber1 = 2;
  int luckyNumber2 = 5;
  int luckyNumber3 = 7;
  int luckyNumber4 = 24;
  int luckyNumber5 = 32;

  System.out.println("Az én szerencseszámaim: " +
   luckyNumber1 + ", " +
   luckyNumber2 + ", " +
   luckyNumber3 + ", " +
   luckyNumber4 + ", " +
   luckyNumber5);

  // int[] luckyNumbers;
  // luckyNumbers = new int[5];
  //int[] luckyNumbers = new int[5];

  /*
  luckyNumbers[0] = 2;
  luckyNumbers[1] = 5;
  luckyNumbers[2] = 7;
  luckyNumbers[3] = 24;
  luckyNumbers[4] = 32;
  */

  int[] luckyNumbers = new int[] {
   2,
   5,
   7,
   24,
   32
  };

  String lila = "barna";
  // kedvenc színeim - legalább 3
  String[] favouriteColours = new String[] {
   "lila",
   "kék",
   "citromsárga"
  };

  // reggeli hőmérsékletek
  double[] temperatures = new double[] {
   1.5,
   -2.8,
   -10.5,
   4.2,
   6.7,
   -6.4,
   7.2
  };

  System.out.println("Szerdán reggel " + temperatures[2] + " Celsius fok volt.");

  // A harmadik kedvenc színem a(z)
  System.out.println("A harmadik kedvenc színem a(z)" + favouriteColours[2]);


 }

}

