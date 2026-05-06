package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
       
    /* Que es un Map Interfaces o un Map simplemente:  Es una colección, aunque no hereda de la interfaz
     * Collection, pero se puede tratar como tal utilizando las Collections Views, que veremos luego.
     * 
     * Concretamente, un Map es una coloección que relaciona claves con valores, lo que antiguamente se
     * llamaba "Hash" (clave(key) y valor (value)), donde las clves no pueden repetirse.
     * 
     * Los métodos de ordenamiento y de búsqueda que son aplicables a las interfaces que heredan de 
     * Collection, no son aplicables a la interface Map.  Por ejm:  el método (.sort) no se le puede
     * aplicar a un Map.
     * En resumen, una Interface Map, mapea (relaciona) claves con valor en un contenedor, que se puede
     * crear de varias formas y recorrer de varias formas también.      */
   /**
     	A modo de ejemplo, vamos a crear una colección (map Interface) que almacene frecuencia de repetición
     	/ocurrencia de un array de palabras que se reciben como parámetro en el método main, cuando se 
     	 * lanza la aplicación    */
    /*  Primero comprobar si estamos recibiendo el array de nombres en la variable Arguments cuando se lanza
     * la aplicación*/
    
    	List<String> listadoDeArgumentos = Arrays.asList(args);
    	listadoDeArgumentos.forEach(System.out::println);
    
    // Creación del Map a partir de listadoDeArgumentos con stream:
    								//cada vez que se quiera obtener una colección, despues de stream se usa
  /*  	Map<String, Long> m = listadoDeArgumentos.stream() // .collect
  // agrupar por nombre y cuento con la lambda(->) los nombres
    			.collect(Collectors.groupingBy(nombre -> nombre,
    					Collectors.counting()));
    	System.out.println("Mapa Resultante: " + m);  */
    	
    	/*  Proceso que tambien se usa mucho:  */
    	
    	Map<String, Long> m = null;
       
    	// Variante # 1 de creación de Map a partir de recorrer el listado de argumentos utilizando operaciones
    	/*de agregado (Tubería, métodos de clase stream, lambda, metodos por referencia, etc)*/
    	
    	m = listadoDeArgumentos.stream() //function.identity lo que entra es lo que se mantiene
    		.collect(Collectors.groupingBy(Function.identity(),
    				Collectors.counting()));
    	
    	System.out.println(m);
    	
    	// Variante # 2  Recomendada!!!
    	
    	var m2 = listadoDeArgumentos.stream()
    			.collect(Collectors.groupingBy(nombre -> nombre, 
    					Collectors.counting()));
    	
    	System.out.println(m2);
    	
    }
}


















