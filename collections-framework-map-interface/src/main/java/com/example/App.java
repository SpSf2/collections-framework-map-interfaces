package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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
    	
    	/** CREACIÓN DE UNA LISTA DE EMPLEADOS Y ESTUDIANTES */
    	List<Empleado> empleados = new ArrayList<Empleado>();
    	
    	// se crea el builder Empleados
    	Empleado emp1 = Empleado.builder()
    			.nombre("Jorge Francisco")
    			.primerApellido("Alborch")
    			.segundoApellido("Villar")
    			.genero(Genero.HOMBRE)
    			.fechaNacimiento(LocalDate.of(1973, Month.JUNE, 23))
    			.dpto(Dpto.INFORMATICA)
    			.salario(new BigDecimal(3500.50))
    			.fechaAlta(LocalDate.of(1990, Month.SEPTEMBER, 22))
    			.build();

    	Empleado emp2 = Empleado.builder()
    			.nombre("Andres")
    			.primerApellido("Alonso")
    			.segundoApellido("Pelaez")
    			.genero(Genero.HOMBRE)
    			.fechaNacimiento(LocalDate.of(1983, Month.SEPTEMBER, 23))
    			.dpto(Dpto.INFORMATICA)
    			.salario(new BigDecimal(3400.50))
    			.fechaAlta(LocalDate.of(1995, Month.SEPTEMBER, 22))
    			.build();

    	Empleado emp3 = Empleado.builder()
    			.nombre("Jeronimo")
    			.primerApellido("Arenal")
    			.segundoApellido("Gomez")
    			.genero(Genero.HOMBRE)
    			.fechaNacimiento(LocalDate.of(1968, Month.OCTOBER, 20))
    			.dpto(Dpto.CONTABILIDAD)
    			.salario(new BigDecimal(3600.50))
    			.fechaAlta(LocalDate.of(1977, Month.JANUARY, 4))
    			.build();
    			
    	Empleado emp4 = Empleado.builder()
    			.nombre("Carolina")
    			.primerApellido("Garzon")
    			.segundoApellido("Becerra")
    			.genero(Genero.MUJER)
    			.fechaNacimiento(LocalDate.of(2001, Month.JUNE, 7))
    			.dpto(Dpto.INFORMATICA)
    			.salario(new BigDecimal(3700.50))
    			.fechaAlta(LocalDate.of(2020, Month.SEPTEMBER, 10))
    			.build();


    	Empleado emp5 = Empleado.builder()
    			.nombre("Mariana")
    			.primerApellido("Garzon")
    			.segundoApellido("Villar")
    			.genero(Genero.MUJER)
    			.fechaNacimiento(LocalDate.of(2000, Month.AUGUST, 4))
    			.dpto(Dpto.FINANZAS)
    			.salario(new BigDecimal(3300.50))
    			.fechaAlta(LocalDate.of(2022, Month.SEPTEMBER, 25))
    			.build();

    	Empleado emp6 = Empleado.builder()
    			.nombre("Francisca")
    			.primerApellido("Alvarez")
    			.segundoApellido("Glez")
    			.genero(Genero.MUJER)
    			.fechaNacimiento(LocalDate.of(1995, Month.DECEMBER, 10))
    			.dpto(Dpto.RRHH)
    			.salario(new BigDecimal(2500.50))
    			.fechaAlta(LocalDate.of(2010, Month.SEPTEMBER, 5))
    			.build();
    			
    	Empleado emp7 = Empleado.builder()
    			.nombre("Maricarmen")
    			.primerApellido("Becerra")
    			.segundoApellido("Mtnez")
    			.genero(Genero.MUJER)
    			.fechaNacimiento(LocalDate.of(2003, Month.FEBRUARY, 14))
    			.dpto(Dpto.FINANZAS)
    			.salario(new BigDecimal(2600.50))
    			.fechaAlta(LocalDate.of(2021, Month.SEPTEMBER, 8))
    			.build();

    	Empleado emp8 = Empleado.builder()
    			.nombre("Eva")
    			.primerApellido("Cornide")
    			.segundoApellido("Machado")
    			.genero(Genero.MUJER)
    			.fechaNacimiento(LocalDate.of(1990, Month.MAY, 18))
    			.dpto(Dpto.INFORMATICA)
    			.salario(new BigDecimal(3500.50))
    			.fechaAlta(LocalDate.of(2015, Month.SEPTEMBER, 22))
    			.build();

    	Empleado emp9 = Empleado.builder()
    			.nombre("Alberto")
    			.primerApellido("Glez")
    			.segundoApellido("Sanchez")
    			.genero(Genero.HOMBRE)
    			.fechaNacimiento(LocalDate.of(1990, Month.FEBRUARY, 14))
    			.dpto(Dpto.FINANZAS)
    			.salario(new BigDecimal(2600.50))
    			.fechaAlta(LocalDate.of(2008, Month.SEPTEMBER, 8))
    			.build();
    	
    	Empleado emp10 = Empleado.builder()
    			.nombre("Javier")
    			.primerApellido("Glez")
    			.segundoApellido("Sanchez")
    			.genero(Genero.HOMBRE)
    			.fechaNacimiento(LocalDate.of(1995, Month.MAY, 20))
    			.dpto(Dpto.RRHH)
    			.salario(new BigDecimal(3500.50))
    			.fechaAlta(LocalDate.of(2015, Month.SEPTEMBER, 22))
    			.build();
    	
    	Estudiante est1 = Estudiante.builder()
    			.nombre("Carlos")
    			.primerApellido("Glez")
    			.segundoApellido("Sanchez")
    			.genero(Genero.HOMBRE)
    			.fechaNacimiento(LocalDate.of(1995, Month.MAY, 20))
    			.totalAsignaturas(10)
    			.facultad(Facultad.BIOLOGIA)
    			.fechaAltaFacultad(LocalDate.of(2015, Month.SEPTEMBER, 22))
    			.build();
    	
    	Estudiante est2 = Estudiante.builder()
    			.nombre("José")
    			.primerApellido("Suarez")
    			.segundoApellido("Jimenez")
    			.genero(Genero.HOMBRE)
    			.fechaNacimiento(LocalDate.of(1996, Month.MARCH, 10))
    			.totalAsignaturas(10)
    			.facultad(Facultad.BIOLOGIA)
    			.fechaAltaFacultad(LocalDate.of(2011, Month.JULY, 25))
    			.build();
    	
    	empleados = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10);
    	
    	//  Crear una colección que agrupe empleados por genero: entonces creamos un Map que tenga como clave
    	// Genero y como valor una lista de empleados por cada genero, el operador (>>) asigna!!!
   /* 	Map<Genero, List<Empleado>> empleadosPorGenero = empleados.stream() // empleados.stream es la tuberia 
    																		// por donde pasa el empleado
    			.collect(Collectors.groupingBy(empleado -> empleado.getGenero(), // el empleado que va pasando por la tuberia se le pide el genero con la lambda   
    			Collectors.toList())); // esto lo agrega a la lista */
    	
    	//  Variante del Método: Cuando se recorre una lista que es del mismo tipo que los elementos del valor del Mapa,
    	// no hay que hacer nada para que el elemento que circula por la tubería termine en la lista correspondiente
    	// al valor de la entrada del Map y el código se reduce.
    	// Ahora metimos estudiantes en el listado
    	Map<Genero, List<Empleado>> empleadosPorGenero = empleados.stream() 
				.filter(obj -> obj instanceof Empleado)
    				.collect(Collectors.groupingBy(Persona::getGenero));
    						
    	System.out.println("Empleados por Género: " + empleadosPorGenero);
    	
    	
    	
    }
}


















