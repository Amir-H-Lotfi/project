package us.core.pr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.core.pr.repository.ICRepository;
import us.core.pr.service.abstraction.AbstractCollegeService;
import us.core.pr.service.abstraction.ICService;


@Service
public class CollegeService
        extends AbstractCollegeService
{

    @Autowired
    public CollegeService(ICRepository icRepository)
    {
        super(icRepository);
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
