# Java alapok

## 1. Main

```java
public class Main {

   public static void main(String []args) {
      System.out.println("Hello World"); 
   }
   
}
```

## 2. Változók

Képzeljük el a változókat úgy, mint a fiókok, amikbe teszünk valamit, és felcímkézzük őket. Ezután tudni fogjuk, hogyha a 'pénzem' nevű címkével ellátott dobozban például 2455 Ft lesz. Bár nem feltétlenül, de ez az érték idővel változik, nevéből is adódóan, mert a pénzem fogyhat vagy gyarapodhat, akár napról napra, de persze lehet, hogy egy hétig ugyanannyi marad. 

Tehát a változóknak kell hogy legyen egy típusuk, egy nevük és persze egy értékük.
A típus fogja jelölni, hogy a változónak milyen értéke lesz. Lehet ez valamilyen szám, szöveg vagy logikai érték(igen/nem).  A név jelöli a címkét a dobozon, illetve az érték lesz az amit a dobozban tárolunk. Ezek lesznek azok a dolgok, amik szükségesek egy új változó bevezetéséhez, vagy más néven deklarálásához.

<pre>
  típus       név    =  érték  ;
|_______|   |____|     |______|
</pre>

## 3. Típusok

Ahogy említettem a változóknak van típusa, ami kell ahhoz, hogy deklarálni tudjunk egy változót. A típus meghatározza, hogy a változó milyen értéket vehet fel. 

Az adattípusoknak két nagy csoportba sorolhatók: primitív vagy referencia. A primitív adattípusok egy egyszerű értéket képesek tárolni: számot, karaktert vagy logikai értéket. A változó neve közvetlenül egy értéket jelent.

### 3.1. Primitív adattípusok

egészek:
```
	byte        bájt méretű 
	short       rövid egész 
	int         egész 
	long        hosszú egész 
```
valós számok
```
	float       egyszeres pontosságú lebegőpontos 
	double      dupla pontosságú lebegőpontos 
```
egyéb típusok
```
	char        karakter 16-bit Unicode karakter
	boolean     logikai, értéke true vagy false
```
	
Ezek közül a leggyakrabban használt típusok: int, double, char, boolean
Például:
```java
double litersOfMilk = 2.18;
````

Fontos még tudni a következőket:
A double és float típusoknál a tizedesvessző helyett tizedespontot kell használni. 
A char típusnál a változóben csak egy karakter, ennek az értékét ' ' közé kell tenni, vagy annak a karakterkódja szerepelhet. Például:
```java
char a = 'A';
char a = 65;
```
A boolean típusnál pedig csak kétféle értéket vehet fel: igaz vagy hamis.
```java
boolean isFunny = true;
boolean isFunny = false;
```

### 3.2. Referencia adattípusok

A tömbök és osztályok referencia-típusúak. A referencia-változó más nyelvek mutató vagy memóriacím fogalmára hasonlít. Az objektum neve nem egy közvetlen értéket, hanem csak egy referenciát jelent. Az értéket közvetetten, a referencián keresztül érhetjük el. Így deklarálhatjuk például az egyik leggyakrabban használt változó típust is, ez a `String` (ez is egy osztály).

```java
String apple = new String("apple");
```
A Stringeket így is létrehozhatjuk:
```java
String name = "My Name";
```
Itt fontos, hogy a szöveget, amit tárolni akarunk, " " közé kell tenni.

### 3.3. Névadás

A változók nevei a Java nyelvben case-sensitive tulajdonságúak, ami azt jelenti, hogy a `myname` és a `myName` változónevek két külön változót jelentenek.

Ezek a változónevek bármilyen Unicode betűt és számjegyet tartalmazhatnak, de fontos, hogy kizárólag betűvel, dollárjellel ($) vagy alulvonással kezdődhetnek (_). A konveció alapján viszont érdemes mindig betűvel kezdeni a változóneveket, a dollárjel pedig nem is használatos. 

A változó nevében whitespace karakter nem szerepelhet.

A konveció alapján még javasolt, hogy lehetőleg mindig értelmes és nem rövidített szavakat használjunk a változónevek képzéséhez, illetve a camelCase írásmódot prefereáljuk.

#### 3.3.1. Case

- camelCase:         `numerOfMyDogs`
- kebab-case:        `number-of-my-dogs`
- snake_case:        `number_of_my_dogs`
- PascalCase:        `NumberOfMyDogs`

### 3.4. Deklarálás vs. inicializálás

A változókat deklarálni kell, ez egyfajta létrehozás. Meg kell adni legalább a változó típusát és nevét, de már az alapértékét is meg lehet adni deklaráláskor. Ez az inicializáció. Tehát például egy `int` típusú, `numberOfMyDogs` nevű változó, aminek az értéke legyen 3, ennek a deklarálása így nézhet ki:

```java
int numberOfMyDogs; 	// itt még nem adtunk értéket
numberOfMyDogs = 3;		// egy második lépésben kapott értéket

int numberOfMyDogs = 3; // itt létrehoztuk és rögtön kapott is értéket
```

## 4. Megjegyzések
``` java
/* 
 * This is my first java program.
 * And these lines are comments.
 */
 
// this is a single-line comment
```

## 5. Operátorok

Az operátorok egy, kettő vagy három operanduson hajtanak végre egy műveletet. 

Az egyoperandusú operátorokat unáris operátoroknak hívjuk. Például a ++ operátor az operandusát 1-el növeli. A kétoperandusú operátorokat bináris operátoroknak hívjuk. Például az = operátor a jobb oldali operandus értékét a baloldali operandusba másolja.

Megkülönböztetünk aritmetikai operátorokat, relációs operátorokat, logikai operátorokat és értékadó operátorokat.
Ezek közül a legfontosabbak:

```
+     összeadás
-     kivonás 
*     szorzás
/     osztás
%     osztás maradéka

>     op1 nagyobb, mint op2
>=    op1 nagyobb vagy egyenlő, mint op2
<     op1 kisebb, mint op2
<=    op1 kisebb vagy egyenlő, mint op2
==    op1 és op2 egyenlők
!=    op1 és op2 nem egyenlők

&&    és
||    vagy
!     nem

++    megnöveli az értékét eggyel(ugyanaz, mint i=i+1)
--    lecsökkenti az értékét eggyel(ugyanaz, mint i=i-1)
+=    értéknövelő adott értékkel
-=    értékcsökkentő adott értékkel
```

## 6. Matematika

```java
Math.PI           π

Math.random()     0 és 1 közötti véletlenszerű értéket ad vissza

sin, cos, stb matematikai függvények

Math.ceil()       felfelé kerekít
Math.floor()      lefelé kerekít
Math.round()      egészre kerekít
```

## 7. Feladatok

1. Írjuk ki a konzolra, hogy "Hello world!"!
2. Írjunk programot, amely csillagokból kirajzolja a konzolra az alábbi házikót vagy egy tetszőleges mintát bármilyen karakterek felhasználásával

```
  *
 ***
*****
*   *
*   *
*****
```

3. Írjuk ki a 4 és 3 összegét és különbségét, úgy hogy az eredményt a program számolja!

```
4 + 3 = 7
4 - 3 = 1
```

4. Írjuk ki két tetszőleges szám összegét, szorzatát, különbségét, hányadosát és osztási maradékát!
5. Számoljuk ki az a oldalú négyzet területét, ha a=4, 6, 11 és 20!
6. Írjuk ki az első 5 számot, és mellé a négyzetüket!
7. Számoljuk ki a téglatest térfogatát és felszínét, ha az oldalai: a=3, b=4, c=5!
8. Számoljuk ki a kör kerületét, és területét, ha a sugara 5! Ha ilyen körlapok határolnak egy 10 egység magas hengert, akkor mennyi lesz a henger térfogata?
9. Egy bankba 2 millió Ft-ot tettünk be, 3 évre. Mennyi pénzünk lesz három év múlva, ha az éves kamat 3 százalék?
10. Leértékelés volt az áruházban! Ági meg akar venni egy ruhát, aminek eredeti ára 4500 forint. Számoljuk ki, hogy a 20%-kos leértékelés után mennyibe kerül a ruha! Mennyibe fog kerülni ez Áginak, ha még van neki egy -15%-os kuponja is?


