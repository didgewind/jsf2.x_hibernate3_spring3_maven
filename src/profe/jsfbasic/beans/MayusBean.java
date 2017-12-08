package profe.jsfbasic.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class MayusBean implements Serializable {

	private String textoOriginal;
	private String textoModificado;
	private int contador;
	private boolean botonMayPulsado;
	private transient HtmlCommandButton botonMay;
	
	private String[] mensajesBoton = {"¡Qué bien que pulsas!",
			"Pues anda que tú", "Y lo que queráis"
	};
	
	public MayusBean() {
		// TODO Auto-generated constructor stub
	}

	public String getTextoOriginal() {
		return textoOriginal;
	}

	public void setTextoOriginal(String textoOriginal) {
		this.textoOriginal = textoOriginal;
	}

	public String getTextoModificado() {
		return textoModificado;
	}

	public void setTextoModificado(String textoModificado) {
		this.textoModificado = textoModificado;
	}
	
	public String pasaAMayusculas() {
		textoModificado = textoOriginal.toUpperCase();
		contador++;
		botonMayPulsado = true;
		int index = getRandomNumber(2);
		botonMay.setValue(mensajesBoton[index]);
		return null;
	}
	
	private int getRandomNumber(int max) {
		int nReturn = (int) Math.round(Math.random() * max);
		return nReturn;
	}
	
	public String recomenzar() {
		/*
		 * Como el botón asociado a esta acción tiene immediate=true el campo textoOriginal no se procesaría, así que necesitamos procesarlo
		 * de forma explícita con el código de abajo
		 */
		textoOriginal = ""; // Esta línea es fundamental, porque es lo que aparecerá en el campo de texto tras la llamada a resetValue()
		UIInput uiTextoOrig = ((UIInput) (FacesContext.getCurrentInstance().getViewRoot().findComponent("formMay:textoOriginal")));
		uiTextoOrig.resetValue();
		// Para reiniciar todos los input field del formulario
/*		UIComponent fc = FacesContext.getCurrentInstance().getViewRoot().findComponent(":formbasic");
        if (null != fc) {
            List<UIComponent> components = fc.getChildren();
            for (UIComponent component : components) {
                if (component instanceof UIInput) {
                    UIInput input = (UIInput) component;
                    input.resetValue();
                }
            }
        }*/
		botonMayPulsado = false;
		return null;
	}

	public int getContador() {
		return contador;
	}

	public boolean isBotonMayPulsado() {
		return botonMayPulsado;
	}

	public void setBotonMayPulsado(boolean botonMayPulsado) {
		this.botonMayPulsado = botonMayPulsado;
	}

	public HtmlCommandButton getBotonMay() {
		return botonMay;
	}

	public void setBotonMay(HtmlCommandButton botonMay) {
		this.botonMay = botonMay;
	}

}
