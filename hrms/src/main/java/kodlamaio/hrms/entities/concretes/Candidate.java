package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name="candidates")
@Data
@EqualsAndHashCode(callSuper=true)
@PrimaryKeyJoinColumn(name="user_id",referencedColumnName ="id")

@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User {
	

	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality_id")
	private String nationalityId;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="birth_year")
	private String birthYear;
	
	
	
	

}
