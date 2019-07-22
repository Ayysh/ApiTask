package com.flaregames.stackoverflow.repository;

import com.flaregames.stackoverflow.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Question
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    /**
     * This method is used to fetch list of Questions based on TagName
     * @param tagName
     * @return  List<Question>
     */
    @Query(value = "SELECT * FROM question q INNER JOIN question_tag qt ON q.id = qt.question_id " +
            "INNER JOIN tag t ON t.id = qt.tag_id WHERE t.tag = :tagName",nativeQuery = true)
    public List<Question> findByTag(@Param("tagName") String tagName);

}
