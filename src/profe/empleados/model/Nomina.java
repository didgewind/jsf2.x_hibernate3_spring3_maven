/**
 * 
 */
package profe.empleados.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author didgewind
 *
 */
public class Nomina implements Serializable {

	private long id;
	private Date fecha;
	private float bruto;

	private Empleado emplNomina;

	
	/**
	 * 
	 */
	public Nomina() {
		// TODO Auto-generated constructor stub
	}

	public Nomina(Date fecha, float bruto) {
		super();
		this.fecha = fecha;
		this.bruto = bruto;
	}

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getBruto() {
		return bruto;
	}

	public void setBruto(float bruto) {
		this.bruto = bruto;
	}

	@Override
	public String toString() {
		return "id=" + id + " - fecha=" + fecha + " - bruto=" + bruto;
	}

	public Empleado getEmplNomina() {
		return emplNomina;
	}

	public void setEmplNomina(Empleado emplNomina) {
		this.emplNomina = emplNomina;
	}


}
