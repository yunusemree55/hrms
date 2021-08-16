package kodlamaio.hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.entities.concretes.Cv.CoverLetter;
import kodlamaio.hrms.entities.concretes.Cv.Education;
import kodlamaio.hrms.entities.concretes.Cv.Experience;
import kodlamaio.hrms.entities.concretes.Cv.Image;
import kodlamaio.hrms.entities.concretes.Cv.Language;
import kodlamaio.hrms.entities.concretes.Cv.Skill;
import kodlamaio.hrms.entities.concretes.Cv.SocialMedia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","coverLetters","educations","experiences","languages","socialMedias","skills","images"}) 
@Table(name="job_seekers")
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
@EqualsAndHashCode(callSuper=false)
public class JobSeeker extends User{
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	 
	@Column(name="birth_of_year")
	private int birthOfYear;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<CoverLetter> coverLetters;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<Education> educations;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<SocialMedia> socialMedias;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<Skill> skills;

	@OneToMany(mappedBy = "jobSeeker")
	private List<Image> images; 
	
	

	

}
