package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
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
    	/* extends se puede utilizar cuando ya tienes la lista hecha, no acepta add */
    	/* Luego cambiamos a super Persona para agregar add y quitamos null
    	/** CREACIÓN DE UNA LISTA DE EMPLEADOS Y ESTUDIANTES */
    	List<? super Persona> listadoGenerico = new ArrayList<>(); // para usar el metodo add
    	                                                //le puedo agregar persona , empleado y estudiante
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
    			.nombre("Mariana")
    			.primerApellido("Alvarez")
    			.segundoApellido("Glez")
    			.genero(Genero.MUJER)
    			.fechaNacimiento(LocalDate.of(1995, Month.DECEMBER, 10))
    			.dpto(Dpto.RRHH)
    			.salario(new BigDecimal(2500.50))
    			.fechaAlta(LocalDate.of(2010, Month.SEPTEMBER, 5))
    			.build();
    			
    	Empleado emp7 = Empleado.builder()
    			.nombre("Mariana")
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
    	
    //	listadoGenerico = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10, est1);
    	
    	listadoGenerico.add(emp1);
    	listadoGenerico.add(emp2);
    	listadoGenerico.add(emp3);
    	listadoGenerico.add(emp4);
    	listadoGenerico.add(emp5);
    	listadoGenerico.add(emp6);
    	listadoGenerico.add(emp7);
    	listadoGenerico.add(emp8);
    	listadoGenerico.add(emp9);
    	listadoGenerico.add(emp10);
    	listadoGenerico.add(est1);
    	listadoGenerico.add(est2);
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
    	
    	/* Map<Genero, List<Empleado>> empleadosPorGenero = empleados.stream() 
				.filter(obj -> obj instanceof Empleado)
    				.collect(Collectors.groupingBy(Persona::getGenero));
    						
    	System.out.println("Empleados por Género: " + empleadosPorGenero); */
    	
    	//  Casteo com map para convertir al objeto en empleado!!!
    	
   /* 	Map<Genero, List<Empleado>> empleadosPorGenero = listadoGenerico.stream()
    			.filter(objeto -> objeto instanceof Empleado)// si el objeto que va circulando por la tuberia es una instancia de Empleado, entonces pasa al map
    			.map(objeto -> (Empleado) objeto) //y lo castea. El metodo map recibe el objeto y lo forza a ser un Empleado 
    											 
    			.collect(Collectors.groupingBy(Empleado::getGenero)); 



    			System.out.println("Empleados por Genero: " + empleadosPorGenero); */
    	
    	
    	// Obtener una coleccion que agrupe empleados por Dpto y Género
    	// Declaramos  el primer Map con Dpto como clave y como las claves no se pueden repetir entonces, declaramos un 2º Map que tendrá como clave Genero		
    	Map<Dpto, Map<Genero, List<Empleado>>> empleadosPorDptoYGenero = listadoGenerico.stream()
    			.filter(o -> o instanceof Empleado)
    			.map(o -> (Empleado)o)
    			.collect(Collectors.groupingBy(Empleado::getDpto,
    						Collectors.groupingBy(Empleado::getGenero)));
    	
    	/* Obtener una colección que agrupe solo nombres de los empleados por genero sin que se dupliquen los nombres*/
    		// Clave Genero porque va a agrupar por genero y un set para que no admita duplicados
    	Map<Genero, Set<String>> nombresPorGenero = listadoGenerico.stream()
    			.filter(o -> o instanceof Empleado)
    			.map(o -> (Empleado)o)
    			.collect(Collectors.groupingBy(Empleado::getGenero, 
    					// un mapper es un collector que recibe la función que le pide al empleado el nombre
    					Collectors.mapping(Empleado::getNombre,
    							Collectors.toSet())));
    			
    	System.out.println("Empleados por Genero: " + nombresPorGenero);
    	
    	/* Obtener una colección que agrupe nombres de Empleados separados por comas y por Edad*/
    	Map<Long, String> nombresPorEdad = listadoGenerico.stream()
    			.filter(o -> o instanceof Empleado)
				.map(o -> (Empleado)o)
    			.collect(Collectors.groupingBy(emp -> 
    				ChronoUnit.YEARS.between(emp.getFechaNacimiento(),
    						LocalDate.now()),
    				Collectors.mapping(Empleado::getNombre,
    						Collectors.joining(","))));
    	
    	System.out.println("Empleados por Genero: " + nombresPorEdad);
    	
    	/* Ejercicio: Obtener una coleccion que agrupe y calcule el salario Promedio por fecha de Alta
    	 * solo para el genero MUJER*/
    	
    	Map<LocalDate, Map<Genero, Double>> salarioPromedio = listadoGenerico.stream()
    			.filter(o -> o instanceof Empleado emp && emp.getGenero().equals(Genero.MUJER))
    			.map(o -> (Empleado)o)// se importó java.util.Collectors
    			.collect(groupingBy(Empleado::getFechaAlta,
    				groupingBy(Empleado::getGenero,
    						averagingDouble(emp -> emp.getSalario().doubleValue()))));
    	// covertimos el salario obtenido a double para poder usar averagingDouble
    	System.out.println("Empleados por Genero: " + salarioPromedio);
    						 
    	/*  Para recorrer un Map hay que utilizar una de las 3 vistas de colecciones (Collections Views)
    	 * para especificar is queremos recorrer las claves del mapa, los valores del maps o todas las
    	 * entradas del mapa, invluyendo claves y valores*/
    	
    	// 1º  Recorrer el Map m que esta arriba al principio con "For mejorado" y mostrar solamente los
    	// valores que sean par:
    	
    	for(Map.Entry<String, Long> entry : m.entrySet()) {
    		
    		String k = entry.getKey();
    		Long v = entry.getValue();
    		
    		if (v % 2 == 0) {
    			System.out.println(v);
    		};
    		
    	}
    	// Lo mismo pero con operaciones de agregado:
    	
	    m.entrySet().forEach(entry -> {
	    	
	    	if (entry.getValue() % 2 == 0) {
	    		System.out.println(entry.getValue());
	    	}
	    });
	    // Recorrer el Mapa empleadosPorDptoYGenero y mostrar el orden natural por antiguedad, los más
	    //antiguos primero: 1º con for mejorado y después operaciones de agregado
	    
/*	    for (Map.Entry<Dpto, Map<Genero, List<Empleado>>> entry1: empleadosPorDptoYGenero.entrySet()) {
			
			// la clave de la entrada del mapa entry1:
	    	Dpto clave1 = entry1.getKey();
	    	
	    	// La segunda clave, de la entrada entry1 que es el Genero puede ser más de una para cada Dpto
	    	// Como obtenemos dica clave?  Rpta: a partir del value de la entrada entry1
	    	Map<Genero, List<Empleado>> valor1 = entry1.getValue();
	    	
	    		for (Map.Entry<Genero, List<Empleado>> entry2 : valor1.entrySet()) {
	    			
	    			Genero clave2 = entry2.getKey();
	    			List<Empleado> empleados = entry2.getValue();
	    			
	    			System.out.println("\nDel Departamento: " + clave1 + ", y del Género: " + clave2);
	    			System.out.println("Los Empleados ordenados por Antiguedad son: \n");
	    			
	    			// ordenamos la lista de empleados según el orden natural de la clase Empleado
	    			Collections.sort(empleados);
	    			
	    			for (Empleado empleado : empleados) {
	    				
	    				System.out.println(empleado);
	    			}
	    		}
	    }    */
    
    	// ahora con Operaciones de Agregado:
	    System.out.println("------  Con Operaciones de Agregado  ------");
	    
	    empleadosPorDptoYGenero.entrySet().forEach(entry1 -> {
	    	
	    	Dpto dpto = entry1.getKey();
	    	
	    	System.out.println("\nDel Dpto: " + entry1.getKey());
	    	
	    	Map<Genero, List<Empleado>> mapaAnidado = entry1.getValue();
	    	
	    	mapaAnidado.entrySet().forEach(entry2 -> {
	    		
	    		Genero genero = entry2.getKey();
	    		
	    		System.out.println("Del Género: "+ entry2.getKey());
	    		
	    		System.out.println("\nLa Lista de empleados ordenada según el Orden Natural por Antiguedad: ");
	    		
	    		List<Empleado> empleados = entry2.getValue();
	    		
	    		empleados.stream().sorted().forEach(System.out::println);
	    	});
	    	
	    	
	    	
	    });
    	/** ORDENAMIENTO DE LAS CLAVES DE UN MAPA
    	 * Los algoritmos de busqueda y ordenamiento que se aplican a las colecciones que heredan  de la interfaz
    	 * Collection "NO" se pueden aplicar a la interfaz Map
    	 * Lo que se rcomienda es trabajar los mapas como un objeto creado a partir de la clase y posteriormente
    	 * copiar dicho mapa en un TreeMap, que permite ordenar las claves.
    	 * 
    	 *  De hecho cuando se crea un mapa a partir de recorrer una lista, por defecto se utiliza "HashMap"
    	 *  
    	 *  ejem: vamos a ordenar las claves del mapa m*/
    	
	     System.out.println("----------     ORDENAMIENTO DE LAS CLAVES DE UN MAPA     -----------");
	     System.out.println("\nMapa m, sin ordenar las claves: ");
	     System.out.println(m);
	     
	     //Como ordenar las claves del mapa m, lexicograficamente de la A a la Z:
	     Map<String, Long> mOrdenadolexicograficamente = new TreeMap<>();
	     
	     mOrdenadolexicograficamente.putAll(m);
	     System.out.println("\nOrdenando las claves: ");
	     System.out.println(mOrdenadolexicograficamente);
	     
	     // ordenar el mapa en orden lexicograficamente inverso:
	     
	     Map<String, Long> mOrdenadolexicograficamenteInverso = new TreeMap<String, Long>(Comparator.reverseOrder());
	     
	     mOrdenadolexicograficamenteInverso.putAll(m);
	     System.out.println("\nclaves en orden Inversa: ");
	     System.out.println(mOrdenadolexicograficamenteInverso);
	     
    	// Recordar que la lista m se llena en el Run As configuration
    }
}


















