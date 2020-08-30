# Spring MVC CRUD + Thymeleaf + MySQL

Az alkalmazás célja, hogy a cég munkatársainak különöbző adatait tárolja.

## Korábbi verzió

0. Ha nem sikerült befejezni, akkor az előző rész végéig eljutó verziót letöltheted innen: [hr-app](hr-app.zip).

Ezután ugyanúgy ahogy a projektalapot importáltuk, ugyanúgy kell ezt is a fejlesztői környezetbe importálni! Ha segítség kell hozzá, akkor térj vissza az előző rész 'Projektalap importálása fejlesztői környezetbe' című alfejezetéhez.

## Lista szépítése
Nagyon egyszerűen néz most ki a listázó nézet, így használjunk valamit, hogy jobban nézzen ki! Vegyük elő a Bootstrap CSS keretrndszer segítségét!

Módosítsuk az **employees.html** oldal tartalmát az alábbira:

``` html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
 
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Munkatársak</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>
 
<body>
    <div class="container my-2">
    <div class="card">
    <div class="card-body">
        <div th:switch="${employees}" class="container my-5">
            <div class="col-md-10">
                <h2 th:case="null">Egy munkatárs sincs a rendszerben</h2>
                <div th:case="*">
                    <table class="table table-striped table-responsive-md">
                        <thead>
                            <tr>
								<th>Azonosító</th>
								<th>Vezetéknév</th>
								<th>Utónév</th>
								<th>E-mail cím</th>
							</tr>
                        </thead>
                        <tbody>
                            <tr th:each="employee : ${employees}">
                                <td th:text="${employee.id}"></td>
                                <td th:text="${employee.firstName}"></td>
                                <td th:text="${employee.lastName}"></td>
                                <td th:text="${employee.email}"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
 
            </div>
        </div>
    </div>
    </div>
    </div>
</body>
 
</html>
```

Indítsuk újra az alkalmazást, és nézzük meg az eredményt! Na ugye, hogy jobban néz ki? :)

Ennek megfelelően szépítsd mg a kezdőoldalt is egy picit! (index.html)


## Új munkatárs hozzáadása

Következő lépésben tudnunk kell új munkatársat felvenni. Ehhez a szolgáltatásunkat és a controllert kell módosítani és egy új felületet (űrlapot) kialakítani.

Kezdjük először a szolgáltatással! Az alábbi metódust adjuk hozzá az EmployeeService osztályunkhoz! Ez egy kettő az egyben metódus, ugyanis ez fogja tudni majd kezelni a módosítást is!


``` java

public Employee createOrUpdateEmployee(Employee entity) {
	// ha még nincs azonosítója, akkor elmenti újként
	if (entity.getId() == null) {
		entity = employeeRepository.save(entity);
		return entity;
	// ha van, akkor ellenőrizzük, hogy az tényleg valós azonosító
	// ha az, akkor módosítjuk
	// ha nem, akkor mentjük újként    
	} else {
		Optional<Employee> employee = employeeRepository.findById(entity.getId());

		if (employee.isPresent()) {
			Employee newEntity = employee.get();
			newEntity.setEmail(entity.getEmail());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());

			newEntity = employeeRepository.save(newEntity);

			return newEntity;
		} else {
			entity.setId(null);
			entity = employeeRepository.save(entity);
			return entity;
		}
	}
}

```

És ne felejtsük el importálni az Optional interface-t! (Ctrl + Shift + O)


Szintén a szolgáltatáshoz adjuk még hozzá az id alapján lekérést biztosító szolgáltatást, mert erre a következő lépésben szükségünk lesz!

``` java

    // id alapján lekérjük egy munkatárs adatait
 public Employee getEmployeeById(Long id) {
	Optional<Employee> employee = employeeRepository.findById(id);

	if(employee.isPresent()) {
		return employee.get();
	} else {
		throw new IllegalArgumentException("No employee record exist for given id");
	}
}

```


Jöjjön a controller módosítása! Itt is, az egyszerűség kedvéért, mivel teljsen hasonló a kettő, így egybevesszük a létrehozás és módosítás műveletket!

Nézzen ki az **EmployeeController** osztályunk így!

``` java

package com.example.hr.controller;

import com.example.hr.domain.Employee;
import com.example.hr.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    
    /// GET

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "employees";
    }

    @GetMapping({"/employees/edit", "/employees/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) {
        if (id.isPresent()) {
            Employee employee = employeeService.getEmployeeById(id.get());
            model.addAttribute("employee", employee);
        } else {
            model.addAttribute("employee", new Employee());
        }
        return "employee-form";
    }

    /// POST
    
    @PostMapping(path = "/createEmployee")
    public String createOrUpdateEmployee(Employee employee) {
        employeeService.createOrUpdateEmployee(employee);
        return "redirect:/";
    }

}

```


Két új metódussal bővült az osztály, az egyik a felület kiszolgálásáért felel, a másik az űrlapon beküldött adatok feldolgozásáért!

Már nem maradt más hátra, mint az űrlap elkészítése! Ehhez hozzunk létre egy új fájlt a templates mappába **employee-form.html** néven és az alábbi tartalommal!


``` html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
 
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Munkatárs űrlap</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>
 
<body>
    <div class="container my-5">
        <h3>Munkatárs szerkesztése</h3>
        <div class="card">
            <div class="card-body">
                <div class="col-md-10">
                    <form action="#" th:action="@{/createEmployee}" th:object="${employee}"
                                                                       method="post">
                        <div class="row">
                            <div class="form-group col-md-8">
                                <label for="name" class="col-form-label">First Name</label> 
                                <input type="text" th:field="*{firstName}" class="form-control"
                                            id="firstName" placeholder="First Name" />
                            </div>
                            <div class="form-group col-md-8">
                                <label for="name" class="col-form-label">Last Name</label> 
                                <input type="text" th:field="*{lastName}" class="form-control"
                                            id="lastName" placeholder="Last Name" />
                            </div>
                            <div class="form-group col-md-8">
                                <label for="email" class="col-form-label">Email</label> 
                                <input type="text" th:field="*{email}" class="form-control"
                                            id="email" placeholder="Email Id" />
                            </div>
 
                            <div class="col-md-6">
                                <input type="submit" class="btn btn-primary" value=" Submit ">
                            </div>
 
                            <input type="hidden" id="id" th:field="*{id}">
     
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
 
</html>
```

Még egy plusz feladat, a listázó nézetre kell egy gombot betennünk, hogy azzal tudjunk eljutni az űrlap oldalára!
Az **employees.html** oldalon, az alábbi részletet tegyük azon sor alá, ahol a kódban van a **th:switch**

``` html

<p class="my-5">
	<a href="/employees/edit" class="btn btn-primary">
	<i class="fas fa-user-plus ml-2"> Új munkatárs </i></a>
</p>

```

Indítsuk újra az alkalmazást, és nézzük meg, hogy tudunk-e új munkatársat felvenni!


## Munkatárs adatainak módosítása

Most, hogy már tudunk új munkatársat felvenni, egy meglévő munkatárs módosítása sem lesz nagy feladat!

Ehhez csak a felületet kell csak módosítani, hiszen az előbbi lépésben a szolgáltatást, az űrlapot és a controllert is úgy készítettük el, hogy tudjanak létrehozni és szerkeszteni is!

Annyiban kell módosítani, hogy a táblázba vegyünk fel egy új oszlopot:

Egy új oszlopcím:

``` html
<th>Szerkesztés</th>
```
És egy új cella:

``` html
<td>
	<a th:href="@{/employees/edit/{id}(id=${employee.id})}" class="btn btn-primary">
		<i class="fas fa-user-edit ml-2"></i>
	</a>
</td>

```

Indítsuk újra az alkalmazást és nézzük meg, hogy tudjuk-e módosítani a munkatársak adatait!

## Munkatárs törlése

Egy munkatárs adatainak törléséhez létre kell hoznunk új metódust a szolgáltatásban és a controllerben, illetve a felületet is módosítanunk kell!

Kezdjük a szolgáltatással! Adjuk hozzá ezt a metódust a szolgáltatáshoz!

``` java

// töröl egy munkatársat azonosító alapján
public void deleteEmployeeById(Long id) {
	Optional<Employee> employee = employeeRepository.findById(id);

	// ha létezik ilyen azonosítóval munkatárs, akkor törli
	if (employee.isPresent()) {
		employeeRepository.deleteById(id);
		
	// ha nem, akkor hibát dob    
	} else {
		throw new IllegalArgumentException("No employee record exist for given id");
	}
}

```

Folytassuk a controllerrel! Ezt az alábbival egészítsük ki:

``` java

/// DELETE

@GetMapping("/employees/delete/{id}")
public String deleteEmployeeById(Model model, @PathVariable("id") Long id) {
	employeeService.deleteEmployeeById(id);
	return "redirect:/";
}
```

Végül pedig ahogy előbb a szerkesztésnél új oszlopot vegyünk fel a listázó nézeten a táblázatba:

Egy új oszlopcím:

``` html
<th>Törlés</th>
```
És egy új cella:

``` html
<td>
	<a th:href="@{/employees/delete/{id}(id=${employee.id})}" class="btn btn-primary">
		<i class="fas fa-user-times ml-2"></i>
	</a>
</td>

```



## Bónusz: részletes nézet egy munkatárshoz!

Még a feladathoz tartozik egy bónusz feladat is, hogy egy munkatárs részletes nézetét tudjuk egy külön oldalon megtekintni!
Most már tudod a csavarokat/praktikákat, mnni fog egyedül is! :) Ha segítség kell, szólj! :)

Részfeladatok:
- új metódus a controllerbe, ami id alapján visszaadja egy munkatárs adatait!
- új felület, ami egy munkatárs adatait jeleníti meg kizárólag
- link/új oszlopba gomb a részletes nézethez

## Vége! :)