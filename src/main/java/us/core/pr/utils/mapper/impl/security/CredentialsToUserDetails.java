package us.core.pr.utils.mapper.impl.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import us.core.pr.domain.db.entities.security.Credential;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;

public class CredentialsToUserDetails
        implements IDataTransferObjectMapper<Credential, UserDetails>
{
    @Override
    public UserDetails from(Credential source)
    {
        User.UserBuilder userBuilder = User.builder();
        String[] roles = source.getRoles().stream().map(role -> role.getRole().name()).toArray(String[]::new);
        String[] authorities = source.getAuthorities().stream().map(authority -> authority.getAuthorities().name()).toArray(String[]::new);
        userBuilder
                .username(source.getUsername())
                .password(source.getPassword())
                .accountExpired(source.getAccountExpired())
                .credentialsExpired(source.getCredentialsExpired())
                .accountLocked(source.getLocked())
                .roles(roles)
                .authorities(authorities);

        return userBuilder.build();
    }
}
