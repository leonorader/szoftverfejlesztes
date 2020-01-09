public class Main {

 public static void main(String[] args) {

  int[] pricesOfLaptop = new int[] {
   280000,
   285000,
   290000,
   260000,
   270000
  };

  System.out.println("Az ötödik napon a laptop ára: " + pricesOfLaptop[4]);

  System.out.println(pricesOfLaptop.length);

  for (int i = 0; i < pricesOfLaptop.length; i++) {
   System.out.println((i + 1) + ". elem: " + pricesOfLaptop[i]);
  }

  for (int i = 0; i < pricesOfLaptop.length; i++) {
   System.out.println((i + 1) + ". elem 20% kedvezménnyel: " + 0.8 * pricesOfLaptop[i]);
  }

  for (int i = pricesOfLaptop.length - 1; i >= 0; i--) {
   System.out.println(pricesOfLaptop[i]);
  }

  // programozási tételek
  // 1. összegzés
  int sum = 0;
  for (int i = 0; i < pricesOfLaptop.length; i++) {
   sum += pricesOfLaptop[i];
  }
  System.out.println("Átlagár: " + (sum / pricesOfLaptop.length));

  // 2. számolás
  int d = 0;
  for (int i = 0; i < pricesOfLaptop.length; i++) {
   if (pricesOfLaptop[i] <= 280000) {
    d++;
   }
  }
  System.out.println(d + " napon volt maximum 280 000 a laptop ára.");

  // 3. maximum
  int max = pricesOfLaptop[0];
  for (int i = 1; i < pricesOfLaptop.length; i++) {
   if (pricesOfLaptop[i] > max) {
    max = pricesOfLaptop[i];
   }
  }
  System.out.println("A legnagyobb ismert ár: " + max + " Ft");

  // 4. minimum
  int min = pricesOfLaptop[0];
  for (int i = 1; i < pricesOfLaptop.length; i++) {
   if (pricesOfLaptop[i] < min) {
    min = pricesOfLaptop[i];
   }
  }
  System.out.println("A legkisebb ismert ár: " + min + " Ft");

  // 5. kiválasztás - melyik az az első érték, ami 286000 forintttól több?
  int i = 0;
  while (pricesOfLaptop[i] < 286000) {
   i++;
  }
  System.out.println("Ez az első ilyen érték: " + pricesOfLaptop[i]);

  // 6. eldöntés
  i = 0;
  while (i < pricesOfLaptop.length && pricesOfLaptop[i] < 500000) {
   i++;
  }
  System.out.println("Van-e ilyen elem? " + (i < pricesOfLaptop.length));

  // 7. lineáris keresés
  i = 0;
  while (i < pricesOfLaptop.length && pricesOfLaptop[i] < 500000) {
   i++;
  }
  boolean l = i < pricesOfLaptop.length;
  System.out.println("Van-e ilyen elem és ha van, akkor mi az?");
  System.out.println(l ? "Van: " + pricesOfLaptop[i] : "Nincs ilyen elem.");


  // OPERATORS
  // ? : ternary operator
  if (i > 2) {
   System.out.println("igaz");
  } else {
   System.out.println("hamis");
  }
  System.out.println(i > 2 ? "igaz" : "hamis");

  // 1. időjárásjelentés
  // - hőmérsékleteket tartalmazó tömb egy heti adattal
  // - mi lesz az átlaghőmérséklet?
  // - hányszor lesz fagypont alatti hőmérséklet?
  // - mi lesz az első fagypont feletti érték? ha egyáltalán lesz?
  // - mi lesz a legmagasabb hőmérséklet?

  double[] temperatures = new double[] {
   -2.5, 1.5, -0.5, 2.7, -1.8, 1.3, 0.6
  };

  double s = 0;
  for (int j = 0; j < temperatures.length; j++) {
   s += temperatures[j];
  }
  double averageTemperature = s / temperatures.length;
  System.out.println("Átlaghőmérséklet: " + averageTemperature);

  int c = 0;
  for (int j = 0; j < temperatures.length; j++) {
   if (temperatures[j] < 0) {
    c++;
   }
  }
  System.out.println("Fagypont alatti hőmérséklet " + c + " alkalommal lesz.");

  int j = 0;
  while (j < temperatures.length && temperatures[j] <= 0) {
   j++;
  }
  boolean m = j < temperatures.length;
  System.out.println(m ?
   ("Van, az első fagypont feletti érték: " + temperatures[j]) :
   "Nem lesz fagypont feletti érték.");

  double maxTemperature = temperatures[0];
  for (int k = 0; k < temperatures.length; k++) {
   if (temperatures[k] > maxTemperature) {
    maxTemperature = temperatures[k];
   }
  }
  System.out.println("A legmagasabb hőmérséklet " + maxTemperature + " Celsius fok lesz.");

 }

}