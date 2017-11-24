package profe.empleados.daos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import profe.empleados.model.Empleado;
import profe.empleados.model.Evento;
import profe.empleados.model.Nomina;

/**
 * Implementación de DAOEmpleados que trabaja en memoria
 * @author Administrador
 *
 */
public class DAOEmpFake implements DAOEmpleados {

	private Map<String, Empleado> mpEmpleados = 
			new HashMap<String, Empleado>();
	
	public DAOEmpFake() {
		mpEmpleados.put("2389471290H", new Empleado("2389471290H", "Luis", "Pascual", 32));
		mpEmpleados.put("3045893409Y", new Empleado("3045893409Y", "Begoña", "García", 1));
		mpEmpleados.put("0938573904T", new Empleado("0938573904T", "Javier", "López", 1));
		mpEmpleados.put("9234873942U", new Empleado("9234873942U", "Antonio", "Boniato", 11));
	}
	
	/*
	 * (non-Javadoc)
	 * @see profe.daos.DAOEmpleados#getEmpleados()
	 */
	@Override
	public Set<Empleado> getEmpleados() {
		return (HashSet<Empleado>)new HashSet<Empleado>
				(mpEmpleados.values()).clone();
	}

	@Override
	public boolean insertaEmpleado(Empleado emp) {

		// Comprobar si ya existe el empleado emp
		Empleado eAux = mpEmpleados.get(emp.getCif());
		// Si no existe
		if (eAux == null) {
			// inserto emp
			mpEmpleados.put(emp.getCif(), emp);
			// devuelvo true
			return true;
		} else { // Si no
			// devuelvo false
			return false;
		}
	}

	@Override
	public boolean eliminaEmpleado(String cif) {
		Object o = mpEmpleados.remove(cif);
		if (o!=null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean modificaEmpleado(Empleado emp) {
		// Comprobar si ya existe el empleado emp
		Empleado eAux = mpEmpleados.get(emp.getCif());
		// Si existe
		if (eAux != null) {
			// lo modifico
			mpEmpleados.put(emp.getCif(), emp);
			// devuelvo true
			return true;
		} else { // Si no
			// devuelvo false
			return false;
		}
	}

	@Override
	public Empleado getEmpleado(String cif) {
		// TODO Auto-generated method stub
		return mpEmpleados.get(cif);
	}

	@Override
	public Set<Nomina> getNominas() {
		// TODO Auto-generated method stub
		return null;
	}

	public void sayHello() {
		
	}

	@Override
	public Nomina getNomina(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evento getEvento(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Evento> getEventosFromEmpleado(String cif) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado getEmpleadoConNominas(String cif) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertaEvento(Evento event) {
		// TODO Auto-generated method stub
		return false;
	}


}
