package us.core.pr.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.core.pr.domain.db.entities.security.Credential;

import java.util.*;

@Repository
public interface CredentialsRepository
        extends JpaRepository<Credential, Integer>
{
    Optional<Credential> findByUsername(String username);
}
