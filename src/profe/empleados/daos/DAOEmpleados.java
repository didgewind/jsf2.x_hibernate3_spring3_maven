/**
 * 
 */
package profe.empleados.daos;

import java.util.Set;

import profe.empleados.model.Empleado;
import profe.empleados.model.Evento;
import profe.empleados.model.Nomina;

/**
 * @author Administrador
 *
 * Interfaz para acceder a los empleados
 */
public interface DAOEmpleados {

	/**
	 * Devuelve el conjunto de empleados
	 * @return
	 */
	public abstract Set<Empleado> getEmpleados();
	
	/**
	 * Inserta el empleado emp. Devuelve true si todo ha sido correcto, y
	 * false en caso contrario. En caso de que el empleado exista, se deja la decisión de sustituirlo
	 * o no a la clase de implementación
	 * @param emp
	 * @return
	 */
	public abstract boolean insertaEmpleado(Empleado emp);
	
	public abstract boolean eliminaEmpleado(String cif);
	
	public abstract boolean modificaEmpleado(Empleado emp);
	
	public abstract Empleado getEmpleado(String cif);
	
	public abstract Empleado getEmpleadoConNominas(String cif);
	
	public abstract Set<Nomina> getNominas();
	
	public abstract Nomina getNomina(long id);
	
	public abstract Evento getEvento(long id);

	public abstract Set<Evento> getEventosFromEmpleado(String cif);
	
	public abstract boolean insertaEvento(Evento event);
}
