package profe.empleados.negocio;

import java.util.Set;

import profe.empleados.model.Empleado;
import profe.empleados.model.Evento;
import profe.empleados.model.Nomina;

public interface NegocioEmpleados {

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#getEmpleados()
	 */
	public abstract Set<Empleado> getEmpleados();

	public abstract Set<Nomina> getNominas();

	public abstract Nomina getNomina(long id);

	public abstract Evento getEvento(long id);

	public abstract Set<Evento> getEventosFromEmpleado(String cif);

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#insertaEmpleado(profe.empleados.model.Empleado)
	 */
	public abstract boolean insertaEmpleado(Empleado emp);

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#eliminaEmpleado(java.lang.String)
	 */
	public abstract boolean eliminaEmpleado(String cif);

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#modificaEmpleado(profe.empleados.model.Empleado)
	 */
	public abstract boolean modificaEmpleado(Empleado emp);

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#getEmpleado(java.lang.String)
	 */
	public abstract Empleado getEmpleado(String cif);

	public abstract Empleado getEmpleadoConNominas(String cif);
	
	public abstract boolean insertaEmpleadoYEvento(Empleado emp, Evento event);

}