package us.core.pr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.core.pr.domain.entity.College;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface ICollegeRepository
        extends JpaRepository<College, Integer>, Serializable
{
    Optional<College> findByName(String name);
}
