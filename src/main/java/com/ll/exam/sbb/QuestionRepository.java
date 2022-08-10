package com.ll.exam.sbb;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);

    Question findBySubjectAndContent(String subject, String content);
}