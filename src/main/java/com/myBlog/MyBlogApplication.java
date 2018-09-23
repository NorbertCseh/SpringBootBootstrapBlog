package com.myBlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Három másik annotáciot foglal magába,
// @EnableAutoConfiguration
// @ComponentScan
// @Configuration
public class MyBlogApplication {

	// Main függvény ami minden Java alkalmazásba kell.
	public static void main(String[] args) {
		SpringApplication.run(MyBlogApplication.class, args);
	}
}

/*
 * inversion of control
 * 
 * Keretrendszerek nélküli a világban, controll flow volt az elterjedt, azaz a
 * felhasználói kód írányitott. Segédkönyvtárak sem változtattak ezen,
 * meghívhattak más eljrásokat, de sosem hívtak vissza a felhasználói kódba.
 * 
 * Keretrendszerek után:
 * 
 * A felhasználói kód, csak komponensek/ szolgáltatások és ezek
 * összekapcsolásáért a keretrendszer felelős. A keretrendszer hívja meg a
 * felhasználó kódjait.
 * 
 * Tökéletes példa erre a @PostConstruct annotácíóval ellátott eljárás, ami csak
 * egyszer fut le, amikor elindul a program.
 * 
 * Dependency Injection
 * 
 * IoC séma alkalmazása.
 * 
 * Komponensek függöségét csökkentjük vele, így könnyebb késöbb modosítani,
 * lecserélni, bővíteni, ujrahasznosítani.
 * 
 * Van egy konténer, ami össze kapcsolja a komponenseket, Loosely coupled.
 * 
 * Ehez kell:
 * 
 * @Autowired
 * 
 * @Controller
 */