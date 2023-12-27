package us.core.pr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.core.pr.domain.entity.Professor;

import java.io.Serializable;

@Repository
public interface IProfessorRepository
        extends JpaRepository<Professor, String>, Serializable
{
}
