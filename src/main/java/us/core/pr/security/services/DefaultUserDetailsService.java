package us.core.pr.security.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import us.core.pr.domain.db.entities.security.Credential;
import us.core.pr.repository.CredentialsRepository;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.utils.mapper.factory.abstractions.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.utils.mapper.impl.security.CredentialsToUserDetails;


@Service
public class DefaultUserDetailsService
        implements UserDetailsService
{
    private CredentialsRepository            repository;
    private IDataTransferObjectMapperFactory factory;

    public DefaultUserDetailsService(CredentialsRepository repository, IDataTransferObjectMapperFactory factory)
    {
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {

        Credential credential = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User[username=%s] Not Found", username)));
        IDataTransferObjectMapper<Credential, UserDetails> mapper = factory.create(CredentialsToUserDetails.class);
        UserDetails userDetails = mapper.from(credential);
        return userDetails;
    }
}
