package profe.empleados.converters;

import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import profe.empleados.daos.DAOEmpleados;
import profe.empleados.model.Empleado;

@FacesConverter("empleadoConverter")
public class EmpleadoConverter implements Converter {

	@ManagedProperty(value="#{daoBean}")
	private DAOEmpleados dao;
	
	public EmpleadoConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String value) {
		// TODO Auto-generated method stub
		return dao.getEmpleado(value);
	}

	@Override
	public String getAsString(FacesContext context, 
			UIComponent component, Object object) {
		Empleado emp = (Empleado) object;
		return emp.getCif();
	}

	public void setDao(DAOEmpleados dao) {
		this.dao = dao;
	}

}
