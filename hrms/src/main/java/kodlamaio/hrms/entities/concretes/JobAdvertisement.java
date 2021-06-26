package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisements")


public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	
	@Column(name="company_name")
	private String companyName;
	
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="salary")
	private double salary;
	
	@Column(name="number_of_position")
	private  int numberOfOpenPosition;
	
	@Column(name="application_dead_line")
	private LocalDate applicationDeadline;
	
	@Column(name="release_date")
	private LocalDate releaseDate;
	
	@Column(name="is_activated")
	private  boolean isActivated;
	
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="title_id")
	private JobTitle jobTitle;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	

}
