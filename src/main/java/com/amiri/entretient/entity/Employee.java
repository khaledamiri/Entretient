package com.amiri.entretient.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Table(name = "EMPLOYEE")
@Entity
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_emp")
	private Integer idEmp;

	@Column(name = "name_emp")
	@NotNull
	
	private String nameEmp;
	@Column(name = "matricule")
	@NotNull
	@Min(value = 2)
	@Max(value = 10)
	private Double matricule;
	@Column(name = "statut")
	private Boolean statut;
	@Column(name = "type_emp")
	private String typeEmp;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(Integer idEmp) {
		this.idEmp = idEmp;
	}

	public String getNameEmp() {
		return nameEmp;
	}

	public void setNameEmp(String nameEmp) {
		this.nameEmp = nameEmp;
	}

	public Double getMatricule() {
		return matricule;
	}

	public void setMatricule(Double matricule) {
		this.matricule = matricule;
	}

	public Boolean getStatut() {
		return statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
	}

	public String getTypeEmp() {
		return typeEmp;
	}

	public void setTypeEmp(String typeEmp) {
		this.typeEmp = typeEmp;
	}

}
