package kodlamaio.hrms.entities.concretes;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="job_titles_id")
	private JobTitle jobTitle;
	
	
	@Column(name="job_description")
	private String jobDescription;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="min_salary")
	private String minSalary;
	
	@Column(name="maxSalary")
	private String maxSalary;
	
	@Column(name="number_of_position")
	private String numberOfPosition;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="application_date")
	private Date applicationDate;
	
	@Column(name="ads_publish_date")
	private Date adsPublisDate;

}
