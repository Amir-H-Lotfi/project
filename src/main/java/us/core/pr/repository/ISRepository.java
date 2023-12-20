package us.core.pr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.core.pr.domain.entity.Student;

@Repository
public interface ISRepository
        extends JpaRepository<Student, String>
{
}
