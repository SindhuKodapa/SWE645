/* GroupName: TeamPRSTV (Preethi Ranganathan, Sindhuja Kodaparthi, Mary Rithika Reddy Gade, Tarun Vinay Gujjar, Vikas Halgar Seetharam) */

package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.StudentSurvey;

@Repository
public interface StudentSurveyRepository extends JpaRepository<StudentSurvey, Long>{

    
}