package us.core.pr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.core.pr.domain.entity.Student;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface IStudentRepository
        extends JpaRepository<Student, Integer>
{
    Optional<Student> findByStudentId(String studentId);
}
