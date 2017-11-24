package profe.empleados.beans;

import java.io.Serializable;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import profe.empleados.daos.DAOEmpleados;
import profe.empleados.model.Empleado;

@ManagedBean
public class GestorEmpleados implements Serializable {

	private boolean listaLosEmpleadosBonitos;
	@ManagedProperty(value="#{daoFake}")
	private DAOEmpleados dao;
	
	public GestorEmpleados() {
		// TODO Auto-generated constructor stub
	}
	
	public Set<Empleado> getEmpleados() {
		return dao.getEmpleados();
	}
	
	public boolean isListarEmpleados() {
		return listaLosEmpleadosBonitos;
	}
	
	public void listarEmpleados(ActionEvent event) {
		listaLosEmpleadosBonitos = true;
	}

	public void setDao(DAOEmpleados dao) {
		this.dao = dao;
	}

}
