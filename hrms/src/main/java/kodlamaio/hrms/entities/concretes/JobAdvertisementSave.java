package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementSave {
	private int employerId;
	private int jobTitleId;
	private String jobDescription;
	private int cityId;
	private String minSalary;
	private String maxSalary;
	private String numberOfPosition;
	private Date applicationDate;
	private Date adsPublishDate;
}
