package costos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the contador database table.
 * 
 */
@Entity
@Table(name="contador", schema="santamaria")
@NamedQuery(name="Contador.findAll", query="SELECT c FROM Contador c")
public class Contador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cnt_id")
	private long cntId;

	@Column(name="cnt_descripcion")
	private String cntDescripcion;

	@Column(name="cnt_nombre")
	private String cntNombre;

	@Column(name="cnt_valor")
	private BigDecimal cntValor;

	public Contador() {
	}

	public long getCntId() {
		return this.cntId;
	}

	public void setCntId(long cntId) {
		this.cntId = cntId;
	}

	public String getCntDescripcion() {
		return this.cntDescripcion;
	}

	public void setCntDescripcion(String cntDescripcion) {
		this.cntDescripcion = cntDescripcion;
	}

	public String getCntNombre() {
		return this.cntNombre;
	}

	public void setCntNombre(String cntNombre) {
		this.cntNombre = cntNombre;
	}

	public BigDecimal getCntValor() {
		return this.cntValor;
	}

	public void setCntValor(BigDecimal cntValor) {
		this.cntValor = cntValor;
	}

}