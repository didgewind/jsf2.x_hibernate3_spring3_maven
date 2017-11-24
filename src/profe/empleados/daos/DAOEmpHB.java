package profe.empleados.daos;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import profe.empleados.model.Empleado;
import profe.empleados.model.Evento;
import profe.empleados.model.Nomina;

public class DAOEmpHB implements DAOEmpleados {

	private SessionFactory sessionFactory;
	
	public DAOEmpHB() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Set<Empleado> getEmpleados() {
		// TODO Auto-generated method stub
		return new HashSet<Empleado>(
				getSession().createQuery("from Empleado").list());
	}

	@Override
	public boolean insertaEmpleado(Empleado emp) {
		getSession().save(emp);
		return true;
	}

	@Override
	public boolean eliminaEmpleado(String cif) {
		// TODO Auto-generated method stub
		Empleado emp = getEmpleado(cif);
		getSession().delete(emp);
		return true;
	}

	@Override
	public boolean modificaEmpleado(Empleado emp) {
		getSession().update(emp);
		return true;
	}

	@Override
	public Empleado getEmpleado(String cif) {
		// TODO Auto-generated method stub
		return (Empleado) getSession().
				get(Empleado.class, cif);
		
	}

	@Override
	public Set<Nomina> getNominas() {
		return new HashSet<Nomina>(
				getSession().createQuery("from Nomina").list());
	}

	@Override
	public Nomina getNomina(long id) {
		return (Nomina) getSession().
				get(Nomina.class, id);
	}

	@Override
	public Evento getEvento(long id) {
		return (Evento) getSession().
				get(Evento.class, id);
	}

	@Override
	public Set<Evento> getEventosFromEmpleado(String cif) {
		String hql = "FROM Evento eventoActual WHERE "
				+ ":cifEmpleado member of eventoActual.asistentes";
		Query query = getSession().createQuery(hql);
		query.setParameter("cifEmpleado", cif);
		return new HashSet<Evento>(query.list());
	}


	@Override
	public Empleado getEmpleadoConNominas(String cif) {
		Empleado emp = this.getEmpleado(cif);
		Hibernate.initialize(emp.getNominasEmpleado());
		return emp;
	}


	@Override
	public boolean insertaEvento(Evento event) {
		getSession().save(event);
		return true;
	}

	
	
	
	
	
	
}
