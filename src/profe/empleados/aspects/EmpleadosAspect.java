package profe.empleados.aspects;

import org.aspectj.lang.JoinPoint;

public class EmpleadosAspect {

	public EmpleadosAspect() {
		// TODO Auto-generated constructor stub
	}
	
	public void muestraMensajeAntes(JoinPoint jp) {
		System.out.println("Entrando en el método " + jp.getSignature().getName() +
				" del objeto " + jp.getTarget().getClass());
	}

	public void muestraMensajeDespues(JoinPoint jp) {
		System.out.println("Saliendo del método " + jp.getSignature().getName() +
				" del objeto " + jp.getTarget().getClass());
	}

}
