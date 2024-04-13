package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.StudentSurvey;

public interface StudentSurveyRepository extends JpaRepository<StudentSurvey, Long>{

    
}
