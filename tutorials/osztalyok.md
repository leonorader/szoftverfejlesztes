# Osztályok és entitások létrehozása

Lehet fejlesztői környezet nélkül is, de célszerű használni, mert segíti a fejlesztést több szempontból is. Az alábbiakban az Eclipse szerint fogom bemutatni.

## Projekt és fájl létrehozása

Hozzunk létre egy új Java projektet, **osztalyok** neven, vagy ha már létezik bármilyen Java projektünk, akkor azt is megnyithatjuk.

Hozzunk létre ebben a projektben egy új Java osztályt (New -> Class, majd adjuk meg a nevét). A példában a **Product** osztályt fogom létrehozni.

Valahogy így kell, hogy kinézzen a kód ennél a lépésnél a **Product.java** fájlban:

```java
public class Product {
    
}
```

## Tulajdonságok felvétele

Tegyük fel, hogy az osztályunkban az alábbi adatokat szeretnénk tárolni:

- name - szöveges - a termék neve
- quantity  - szám - a termék darabszáma
- enabled - igaz/hamis - a termék elérhetősége (megvehető-e)
- startDate - dátum - a termék elérhetőségének kezdődátuma
- category - felsorolás - a termék kategóriája (három értékű lehet: PAINTING, SCULPTURE, OTHER)

### Szöveges tulajdonság felvétele

Az enkapszuláció elvét követve célszerű minden tulajdonságot privát tulajdonságként felvenni, majd a getter/setter metódusokat legenerálni hozzájuk.

Ezek alapján a **name** property-t így tudom felvenni:

``` java
private String name;
```

### Szám típusú tulajdonság felvétele

Különbséget kell tenni, hogy egész, hosszú egész vagy törtszámról beszélünk. Az egész szám típus kisebb maximális értékkel rendelkezik, mint a hosszú egész szám típus, így a hosszú egészet célszerű akkor választani, ha tudható, hogy bizonyosan nagyon nagy számokat is akartunk majd benne tárolni. 

#### Egész szám típus

Ha a **quantity** tulajdonságom belefér az egész szám típusba, akkor:

``` java
private Integer quantity;
```

#### Hosszú egész típus

Ha csak a hosszú egészbe fér bele, akkor:

``` java
private Long quantity;
```

#### Törtszám

Ha pedig törtszám típus lenne, akkor:

``` java
private Double quantity;
```

### Igaz/hamis típusú tulajdonság felvétele

Ha egy adott property csak igazat vagy hamisat tárolhat, akkor:

``` java
private Boolean enabled;
```

### Dátum típusú tulajdonság felvétele

Dátum típus esetén a **java.util** csomagjának **Date** osztályát használom:

``` java
private Date startDate;
```

Nem szabad elfeljteni, hogy be kell importálni a Date osztályt!

### Felsorolás típusú tulajdonság felvétele

Először létre kell hozni a felsorolási típusunkat. Ezt úgy tudjuk megtenni, hogy létrehozunk egy új **enumot** (Jobb klikk, New -> Enum, majd elnevezem) A példa alapján létrehozom a **ProductCategory** felsorolást, és felveszem a kért három értéket bele:

```java
public enum ProductCategory {
    
    PAINTING,
    SCULPTURE,
    OTHER;
    
}
```

Miután ez megvan, a **Product** osztályomat az alábbival egészítem ki:

``` java
private ProductCategory category;
```

### Getter + Setter

Miután minden tulajdonságot felvettem, az osztályom így néz ki:

```java
import java.util.Date;

public class Product {
    
    private String name;
    
    private Integer quantity;
    
    private Boolean enabled;
    
    private Date startDate;
    
    private ProductCategory category;
    
}
```

Ezek után szükséges, hogy a fenti tulajdonságok "kívülről" is elérhetőek legyenek, ezért le kell generálnom a getter és setter metódusokat.

Az utolsó bezáról kapcsos zárójel elé állok és jobb klikk -> Source -> Generate setters and getters... -> kijelölök minden property-t, majd legereráltatom a metódusokat.

### ToString metódus

Ahhoz, hogy a kiíratáskor jól jelenjenek meg az adatok, ezért még a **toString** metódust is legerálom:

Újra az utolsó bezáró kapcsos zárójel elé állok, jobb klikk -> Source -> Generate toString. Itt it kiválasztok minden tulajdonságot, majd Generate.

Végül így néz ki az osztályom:

```java
import java.util.Date;

public class Product {

    private String name;

    private Integer quantity;

    private Boolean enabled;

    private Date startDate;

    private ProductCategory category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", enabled=" + enabled +
                ", startDate=" + startDate +
                ", category=" + category +
                '}';
    }
}
```



## Osztály entitássá alakítása

Miután létrehoztam egy osztályt és entitássá kell alakítanom, akkor a következő lépéseket kell megtennem.

Itt már célszerű a Spring Initializer segítségét igénybe venni, amely új projekthez elég csak a **Spring Data JPA** függőséget hozzáadni. Majd importálás, és akár a korábbi **Product** osztályom belemásolásra a projektbe.

### Table és Entity annotációk

Ha megvan az alap **Product** osztályom, akkor nyissuk meg a fájlt és a `public class Product`sor fölé illesszük be a két alábbi sort:

```java
@Table(name = "product")
@Entity
```

A @Table annotáció name paraméterén keresztül azt adhatjuk meg, hogy az adatbzáisban a tábla milyen néven szerepel.

Ezeket se felejtsük el importálni a **javax.persistence** csomagból.

### Típusok kiegészítése

#### Szöveges típus esetén

Szöveges típus esetén szabályozható, hogy a táblában a mező milyen hosszúságú lehet. Ezt mindig a mező fölé helyezendő annotációval tehetem meg.

```java
@Column(length = 200)
private String name;
```

Itt se felejtsük el importálni a Column annotációt **javax.persistence** csomagból.

#### Dátum típus esetén

Időpont, dátum esetén szintén a property fölé az alábbi annotáció elhelyezése szükséges:

```java
@Temporal(TemporalType.DATE)
```

Ha csak a dátum részt tároljuk, akkor DATE érték kell, ha csak időpont részét, akkor TIME érték, ha pedig dátum és idő is, akkor TIMESTAMP értéket válasszunk.

Itt se felejtsük el az importálást a **javax.persistence** csomagból.

#### Felsorolás esetén

Ha felsorolási típusunk van, akkor el kell dönteni, hogy a sorszámot (ORDINAL), vagy a nevét (STRING) tároljuk az adatbázistáblában. Célszerű a név szerinti tárolást választni, és az alábbi annotációt elhelyezni a property fölé:

```java
@Enumerated(EnumType.STRING)
```

Itt se felejtsük el az importálást a **javax.persistence** csomagból.

### Összefoglalva

Végül az entitásunk így néz ki:

``` java
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Table(name="product")
@Entity
public class Product {

    @Column(length = 200)
    private String name;

    private Integer quantity;

    private Boolean enabled;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", enabled=" + enabled +
                ", startDate=" + startDate +
                ", category=" + category +
                '}';
    }
}
```



