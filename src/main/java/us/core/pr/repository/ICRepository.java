package us.core.pr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.core.pr.domain.entity.College;

import java.io.Serializable;

@Repository
public interface ICRepository
        extends JpaRepository<College, String>, Serializable
{
}
