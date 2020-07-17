# Git a gyakorlatban

1. Hozz létre egy mappát 'tanfolyam' néven a C: meghajtón, majd a tanfolyam mappában 'git-feladat' néven

2. Nyisd meg ezt a mappát parancssorban (cmd - command line)

   - `cd C:\tanfolyam\git-feladat`

3. Inicializált egy új git repositoryként

   - `git init`

4. Hozz létre a git-feladat mappában egy `index.html` állományt az alábbi tartalommal:

   ```html
   <!DOCTYPE html>
   <html>
       <head>
           <title>Page Title</title>
       </head>
       <body>
           <h1>This is a Heading</h1>	
           <p>This is a paragraph.</p>
       </body>
   </html>
   ```

5. (Nyisd meg a fájlt böngészőben, hogy tényleg jól jelenik meg! :P)

6. Add ki az alábbi állapotlekérdező parancsot: (!!! sikítás !!!)

   - `git status`

7. Adjuk hozzá az indexhez az új állományokat (és a módosításainkat): 

   - `git add .`  - pont azt jelenti, hogy minden módosítást és új fájlt hozzáad - wildcard character / helyettesítő karakter

8. Állítsuk be a szükséges adatokat:

   - `git config --global user.email "username@domain.hu"`

   - `git config --global user.name "username"`

9. Hozzunk létre egy új commitot!

   - `git commit -m "initial"`
   - az m kapcsoló paramétere lesz a commit message 
   - a commit message mindig leírja, hogy mi a változtatások lényege/összefoglalója
   - a legelső commit konvenció szerint mindig "initial" tartalmú

10. Add ki az alábbi állapotlekérdező parancsot: 

    - `git status`
    - most "tiszta" az indexünk és a working copy-nk

11. Módosítsuk az index.html fájlunkat! Adjuk hozzá egy új bekezdést!

    - `<p>hali emberkék</p>`

12. Kérdezzük le újra az állapotot, látni kell a módosítást!

    - `git status`

13. Adjuk hozzá az indexhez a módosításainkat!

    - `git add index.html` - ha nem akarunk minden módosítást commitolni, akkor nevükön nevezve is hozzáadhatóak a módosítások! 

14. Hozzunk létre egy új commitot "new paragraph" commit üzenettel!

15. Nézzük meg a logot!

    - `git log`
    - két bejegyzést kell látnunk, időbélyeggel, szerzővel, commit üzenettel együtt

16. Innentől kezdve ismételjük a folyamatot a lokális repository esetén:

    - módosításokat végzünk
    - hozzáadjuk ezeket az indexünkhöz
    - commitokat készítünk megfelelő üzenetekkel

17. (esetleg SourceTree használatának megismerése + egyéb grafikusa felülettel rendelkező kliensporgramok)

----
18. Nyissuk meg a GitHub oldalát. 

