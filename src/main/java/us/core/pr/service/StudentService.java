package us.core.pr.service;

import org.springframework.stereotype.Service;
import us.core.pr.repository.ISRepository;
import us.core.pr.service.abstraction.AbstractStudentService;

@Service
public class StudentService
        extends AbstractStudentService
{

    public StudentService(ISRepository isRepository)
    {
        super(isRepository);
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
