package kodlamaio.hrms.entities.concretes.Cv;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="resumes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeeker"})
public class Resume {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy ="resume")
	private List<School> schools;
	
	@OneToMany(mappedBy = "resume")
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "resume")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "resume")
	private List<SocialMedia> socialMedias;
	
	@OneToMany(mappedBy = "resume")
	private List<Skill> skills;
	
	@OneToMany(mappedBy = "resume")
	private List<Photo> photos;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private JobSeeker jobSeeker;

}
