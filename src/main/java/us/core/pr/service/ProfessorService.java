package us.core.pr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.core.pr.repository.IPRepository;
import us.core.pr.service.abstraction.AbstractProfessorService;
import us.core.pr.service.abstraction.IPService;

import java.io.Serializable;

@Service
public class ProfessorService
        extends AbstractProfessorService
{

    @Autowired
    public ProfessorService(IPRepository ipRepository)
    {
        super(ipRepository);
    }


    @Override
    public void create(Object o)
    {

    }

    @Override
    public void read(Object o)
    {

    }

    @Override
    public void update(Object o)
    {

    }

    @Override
    public void delete(Object o)
    {

    }
}
