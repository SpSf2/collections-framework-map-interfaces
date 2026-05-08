package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Empleado extends Persona implements Comparable<Empleado>{

		private Dpto dpto;
		private BigDecimal salario; 
		private LocalDate fechaAlta;
		
		@Override
		public int compareTo(Empleado emp) {
			// TODO Auto-generated method stub
			return this.fechaAlta.compareTo(emp.getFechaAlta());
		}
}
