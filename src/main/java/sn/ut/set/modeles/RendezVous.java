package sn.ut.set.modeles;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class RendezVous{
	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false, updatable=false)
	private String description;
	private String lieu;
	private String codeRV;
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate date;
	public RendezVous() {
		super();
	}
public RendezVous(String codeRV,String description,String lieu,LocalDate date ) {
	super();
	this.codeRV=codeRV;
	this.description=description;
	this.lieu=lieu;
	this.date=date;
		
	}
public Long getId() {
	 return this.id;
}
 public String getCodeRV() {
	 return this.codeRV;
 }
 public String getLieu() {
		return this.lieu;
 }
 public String getDescription() {
		return this.description;
}
 public LocalDate getDate() {
		return this.date;
 }
	
 public void setCodeRV( String codeRV) {
	 this.codeRV=codeRV;
		
 }
	
public void setDescription( String description) {
	 this.description=description;
		
}
public void setLieu( String lieu) {
	 this.lieu=lieu;
		
}
public void setDate( LocalDate date) {
	 this.date=date;
		
}
 
	
	

}
