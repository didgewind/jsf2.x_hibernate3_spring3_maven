package profe.jsfbasic.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@ViewScoped
public class GestorColores implements Serializable {

	private String color = "#ff0000";
	private boolean ocultaTexto = true;
	private boolean colorCambiado;
	
	public GestorColores() {
		// TODO Auto-generated constructor stub
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void cambiaColor(ValueChangeEvent event) {
		this.colorCambiado = true;
		System.out.println("Has pasado del color " +
			event.getOldValue() + " al color " + 
			event.getNewValue());
	}

	public String navega() {
		boolean navegar = true;
		// si ocultaTexto es true
		if (ocultaTexto == true) {
			// Almacenar mensaje de error con id idEnlace
			FacesMessage msg = null;
		    msg = new 
		    	FacesMessage(FacesMessage.SEVERITY_ERROR, 
		    		"Error de muestreo", 
		    		"Debes mostrar el texto para poder navegar");
		    FacesContext.getCurrentInstance().
		    	addMessage("idFormColores:idEnlace", msg);
			navegar = false;
		}
		// si no hemos pulsado aún un radio button
		if (!colorCambiado) {
			// Almacenar mensaje de error con id color
			FacesMessage msg = null;
		    msg = new 
		    	FacesMessage(FacesMessage.SEVERITY_ERROR, 
		    		"Error de coloreo", 
		    		"Debes cambiar el color al menos una vez para poder navegar");
		    FacesContext.getCurrentInstance().
		    	addMessage("idFormColores:color", msg);
			navegar = false;
		}
		// si navegar es true
			// devolvemos "empleados"
		// si no
			// devolvemos null
		if (navegar) {
			return "exito";
		} else {
			return "fracaso";
		}
	}
	
	public boolean isOcultaTexto() {
		return ocultaTexto;
	}

	public void setOcultaTexto(boolean ocultaTexto) {
		this.ocultaTexto = ocultaTexto;
	}

	
}

	