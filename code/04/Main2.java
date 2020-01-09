public class Main2 {

 public static void main(String[] args) {

  // OPERATORS
  // ==
  int a = 5;
  int b = 6;
  System.out.println(a == 5);
  System.out.println(a == 12);
  System.out.println(5 == 5);
  System.out.println(a == b);

  // > <
  System.out.println(a > 6);
  System.out.println(b < 3);
  System.out.println(a < b);
  System.out.println(19 > 3);

  // >= <=
  System.out.println(a >= 5);
  System.out.println(b <= 3);

  System.out.println(true == (b == 6));

  /*
  if (feltétel) {
  kód, ami akkor fut le, ha a feltétel igaz
  }
  */

  int numberOfTrees = 12;
  if (numberOfTrees > 10) {
   System.out.println("Kedves Gazda! Sok a fád!");
  }

  if (numberOfTrees < 5) {
   System.out.println("Hát nagyon kevés fád van...");
  }

  /*
  if (feltétel) {
  kód, ami akkor fut le, ha a feltétel igaz
  } else {
  kód, ami akkor fut le, ha a feltétel nem igaz
  }
  */

  int numberOfApples = 1;
  if (numberOfApples > 2) {
   System.out.println("Fúú neked sok almád van.");
  } else {
   System.out.println("Hát nincs valami sok almád... ");
  }


  /*
  if (feltétel1) {
  kód, ami akkor fut le, ha a feltétel1 igaz
  } else if (feltétel2) { - opcionális
  kód, ami akkor fut le, ha a feltétel2 igaz
  } else if (feltétel3) { - opcionális
  kód, ami akkor fut le, ha a feltétel3 igaz
  } else { - opcionális
  kód, ami akkor fut le, ha egyik feltétel sem igaz
  }
  */

  int hours = 10;
  if (hours < 10) {
   System.out.println("Jó reggelt!");
  } else if (hours >= 10 && hours < 18) {
   System.out.println("Jó napot!");
  } else if (hours >= 18 && hours < 22) {
   System.out.println("Jó estét");
  } else {
   System.out.println("Jó éjt!");
  }

  // 1. változó létrehozása - páros/páratlan
  int numberOfPeople = 17;
  if (numberOfPeople % 2 == 0) {
   System.out.println("Párban vannak");
  } else {
   System.out.println("Valaki hoppon marad.");
  }

  // 2. háromszög oldalainak hossza -> derékszögű háromszög-e
  // a = 3, b = 4, c = 5
  int sideA = 3;
  int sideB = 4;
  int sideC = 5;

  if (sideA * sideA + sideB * sideB == sideC * sideC) {
   System.out.println("Derékszögű");
  } else {
   System.out.println("Nem derékszögű háromszög");
  }

  // LOOPS
  /*
  while (feltetel) {
  kód, addig fut le újra és újra amíg a feltetel igaz
  }
  */

  /*
  while (true) {
  System.out.println("Én örökké fogok élni... MUHAHAHAH!!");
  }
  */

  int x = 10;
  while (x > 0) {
   System.out.println(x);
   x = x - 1;
  }

  int days = 0;
  while (true) {
   System.out.println(days);
   if (days > 365) {
    break;
   }
   days = days + 1;
  }

  /*
  do {
  kód, ami fut amíg a feltétel igaz
  } while (feltétel)
  */

  int t = 0;
  do {
   t = t + 1;
  } while (t < 200);
  System.out.println(t);

  /*
  for (inicializálás; feltétel; növekmény) {
  kód, ami fut minden iterációban
  }
  */

  // i++ megegyezik a i = i + 1 megegyezik i += 1
  for (int i = 0; i < 10; i++) {
   System.out.println(i);
  }

  /*
  for (;;) {
  System.out.println("Én örökké fogok élni... MUHAHAHAH!!");
  }
  */
  int d;
  for (d = 20; d > 0; d--) {
   System.out.println(d);
  }


  // 1. írjuk ki a számokat 0-100-ig - csak az öttel oszthatóakat
  for (int i = 0; i < 100; i++) {
   if (i % 5 == 0) {
    System.out.println(i);
   }
  }

  // 2. FizzBuzz
  // 1-100 írjuk a számokat
  // osztható 3-mal és 5-tel is akkor -> FizzBuzz
  // osztható 3-mal -> Fizz
  // osztható 5-tel -> Buzz
  // nem osztható egyikkel sem akkor csak a számot írjuk ki
  for (int i = 0; i < 100; i++) {
   if (i % 5 == 0 && i % 3 == 0) {
    System.out.println("FizzBuzz");
   } else if (i % 3 == 0) {
    System.out.println("Fizz");
   } else if (i % 5 == 0) {
    System.out.println("Buzz");
   } else {
    System.out.println(i);
   }
  }

 }

}