package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Cv.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer>{

}
