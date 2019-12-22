# Vadbejelentő

## Funkcionális követelmények

### Bejelentés

- a felhasználók fajta, kép, helyszín, időpont, veszélyesség megadásával új bejelentést tudnak tenni
- lehessen a korábbi bejelentéseket listázni, szűrni, keresni, rendezni
- térképes nézeten legutóbbi bejelentése
- azonnali segítségre szorulok! – a felhasználó veszélyben van
- közösségépítő funkció: bejelentés megköszönése

### Értesítések

- bejelentés után a közösségi média felületekre bejegyzések készítése
- a felhasználók tudjanak feliratkozni SMS értesítésre
- a feliratkozott felhasználók SMS értesítést kapnak

### Bejelentések kezelése

- vadásztársaságok külön felületen tudják kezelni az intézkedéseket
- állapot módosítása: befogva, kilőve, valótlan

### Statisztikák

- vadásztársaságoknál statisztikák generálása idő, fajta, helyszín, veszélyesség alapján

## Nem funkcionális követelmények

- egyszerű felhasználói felület
- lehessen használni bármilyen eszközön (reszponzív)

## Menedzselési követelmények

### Környezeti

- nem működik együtt semmilyen külső szoftverrel
- térképszolgáltató igénybevétele

### Működési

- alkalmazást bármikor használhatják, folyamatos rendelkezdésreállással
- háttérrendszert csak munkaidőben használják, ritkábban

### Fejlesztési

- mobilalkalmazást cross-platform alkalmazásként kell megírni (Cordova, Ionic)
- háttérrendszert egy Java alapú webes alkalmazás, OOP környezetben

## Termék követelmények

### Hatékonyság

- folyamatos hálózati kapcsolatot igényel
- gyors (1 másodperc alatti) válaszidő minden bevitelre egy alsó kategóriás számítógépen a legtöbb funkcióra
