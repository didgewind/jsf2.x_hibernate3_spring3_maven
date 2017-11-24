package profe.empleados.beans;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;

import profe.empleados.model.Empleado;
import profe.empleados.negocio.NegocioEmpleados;

@ManagedBean
public class GestorEmpleadosLista implements Serializable {

	@ManagedProperty(value="#{negocioEmpleados}")
	private NegocioEmpleados negocio;
	
	private Empleado emp = new Empleado();
	private String cifSeleccionado;
	
	private Empleado empleadoSeleccionado;
	
	public GestorEmpleadosLista() {
		// TODO Auto-generated constructor stub
	}

	public void setNegocio(NegocioEmpleados negocio) {
		this.negocio = negocio;
	}

	public Set<Empleado> getEmpleados() {
		return new TreeSet<Empleado>(negocio.getEmpleados());
	}
	
	public String getCif() {
		return emp.getCif();
	}

	public void setCif(String cif) {
		emp.setCif(cif);
	}

	public String getNombre() {
		return emp.getNombre();
	}

	public void setNombre(String nombre) {
		emp.setNombre(nombre);
	}

	public String getApellidos() {
		return emp.getApellidos();
	}

	public void setApellidos(String apellidos) {
		emp.setApellidos(apellidos);
	}

	public int getEdad() {
		return emp.getEdad();
	}

	public void setEdad(int edad) {
		emp.setEdad(edad);
	}
	
	public void cambiaEmpleado(ValueChangeEvent event) {
		if(event.getPhaseId() != PhaseId.INVOKE_APPLICATION){
	        event.setPhaseId(PhaseId.INVOKE_APPLICATION);
	        event.queue();
	        return;
	    } 
		// Actualizar campos de texto con empleado con cif cifSeleccionado
		if (empleadoSeleccionado != null) {
			emp.setCif(empleadoSeleccionado.getCif());
			emp.setNombre(empleadoSeleccionado.getNombre());
			emp.setApellidos(empleadoSeleccionado.getApellidos());
			emp.setEdad(empleadoSeleccionado.getEdad());
		}
	}

	public void cambiaEmpleadoConCifSeleccionado(ValueChangeEvent event) {
		if(event.getPhaseId() != PhaseId.INVOKE_APPLICATION){
	        event.setPhaseId(PhaseId.INVOKE_APPLICATION);
	        event.queue();
	        return;
	    } 
		// Actualizar campos de texto con empleado con cif cifSeleccionado
		Empleado empAux = negocio.getEmpleado(cifSeleccionado);
		if (empAux != null) {
			emp.setCif(empAux.getCif());
			emp.setNombre(empAux.getNombre());
			emp.setApellidos(empAux.getApellidos());
			emp.setEdad(empAux.getEdad());
		}
	}

	public String getCifSeleccionado() {
		return cifSeleccionado;
	}

	public void setCifSeleccionado(String cifSeleccionado) {
		this.cifSeleccionado = cifSeleccionado;
	}
	
	public void eliminar(ActionEvent event) {
		negocio.eliminaEmpleado(getCif());
	}

	public void modificar(ActionEvent event) {
		negocio.modificaEmpleado(new Empleado(getCif(), getNombre(), getApellidos(), getEdad()));
	}

	public void insertar(ActionEvent event) {
		negocio.insertaEmpleado(new Empleado(getCif(), getNombre(), getApellidos(), getEdad()));
	}

	public Empleado getEmpleadoSeleccionado() {
		return empleadoSeleccionado;
	}

	public void setEmpleadoSeleccionado(Empleado empleadoSeleccionado) {
		this.empleadoSeleccionado = empleadoSeleccionado;
	}

}
