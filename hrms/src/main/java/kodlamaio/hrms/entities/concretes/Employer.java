package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employers")
@Data
@EqualsAndHashCode(callSuper=true)
@PrimaryKeyJoinColumn(name="user_id",referencedColumnName ="id")

@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User {
	
	
	
	@Column(name="company_name")
	private String companyName;
	
	
	@Column(name="company_web")
	private String companyWeb;
	
	@Column(name="company_phone_number")
	private String companyPhoneNumber;
	
	

}
