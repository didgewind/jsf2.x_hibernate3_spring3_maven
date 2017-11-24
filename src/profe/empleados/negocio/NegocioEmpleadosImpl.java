package profe.empleados.negocio;


import java.util.Set;

import profe.empleados.daos.DAOEmpleados;
import profe.empleados.model.Empleado;
import profe.empleados.model.Evento;
import profe.empleados.model.Nomina;

public class NegocioEmpleadosImpl implements NegocioEmpleados {

	private DAOEmpleados dao;
	
	public NegocioEmpleadosImpl() {
		// TODO Auto-generated constructor stub
	}

	public void setDao(DAOEmpleados dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#getEmpleados()
	 */
	
	@Override
	public Set<Empleado> getEmpleados() {
		return dao.getEmpleados();
	}

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#getNominas()
	 */
	@Override
	public Set<Nomina> getNominas() {
		return dao.getNominas();
	}

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#getNomina(long)
	 */
	@Override
	public Nomina getNomina(long id) {
		return dao.getNomina(id);
	}

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#getEvento(long)
	 */
	@Override
	public Evento getEvento(long id) {
		return dao.getEvento(id);
	}

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#getEventosFromEmpleado(java.lang.String)
	 */
	@Override
	public Set<Evento> getEventosFromEmpleado(String cif) {
		return dao.getEventosFromEmpleado(cif);
	}

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#insertaEmpleado(profe.empleados.model.Empleado)
	 */
	@Override
	public boolean insertaEmpleado(Empleado emp) {
		return dao.insertaEmpleado(emp);
	}

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#eliminaEmpleado(java.lang.String)
	 */
	@Override
	public boolean eliminaEmpleado(String cif) {
		return dao.eliminaEmpleado(cif);
	}

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#modificaEmpleado(profe.empleados.model.Empleado)
	 */
	@Override
	public boolean modificaEmpleado(Empleado emp) {
		return dao.modificaEmpleado(emp);
	}

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#getEmpleado(java.lang.String)
	 */
	@Override
	public Empleado getEmpleado(String cif) {
		return dao.getEmpleado(cif);
	}

	@Override
	public Empleado getEmpleadoConNominas(String cif) {
		// TODO Auto-generated method stub
		return dao.getEmpleadoConNominas(cif);
	}

	@Override
	public boolean insertaEmpleadoYEvento(Empleado emp, Evento event) {
		boolean bOk = dao.insertaEvento(event);
		bOk = dao.insertaEmpleado(emp) || bOk;
		if (!bOk) {
			throw new RuntimeException("Error al insertarEmpleado o Evento");
		}
		return true;
	}

	
}
