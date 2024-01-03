package us.core.pr.domain.crud.impl;

import org.springframework.data.domain.Example;
import us.core.pr.domain.crud.abstracts.AbstractCollegeJpaCrud;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.domain.dto.mapper.impl.college.CollegeToRead;
import us.core.pr.domain.dto.mapper.impl.college.CreateToCollege;
import us.core.pr.domain.dto.mapper.impl.college.DeleteToCollege;
import us.core.pr.domain.dto.mapper.impl.college.UpdateToCollege;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.College;
import us.core.pr.exception.RecordNotFoundException;
import us.core.pr.repository.ICollegeRepository;
import us.core.pr.domain.dto.college.*;

public class CollegeJpaCrud
        extends AbstractCollegeJpaCrud
{

    private final IDataTransferObjectMapperFactory factory;

    public CollegeJpaCrud(ICollegeRepository icRepository, IDataTransferObjectMapperFactory factory)
    {
        super(icRepository);
        this.factory = factory;
    }

    @Override
    public void create(Create create)
    {

        try
        {
            IDataTransferObjectMapper<Create, College> mapper = factory.create(CreateToCollege.class);
            College college = mapper.from(create);
            super.iCollegeRepository.saveAndFlush(college);

        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Read read(String key)
    {
        try
        {
            IDataTransferObjectMapper<College, Read> mapper = factory.create(CollegeToRead.class);
            College college = super.iCollegeRepository.findByName(key).orElseThrow(RecordNotFoundException::new);
            Read read = mapper.from(college);
            return read;
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Update read)
    {
        try
        {
            IDataTransferObjectMapper<Update, College> mapper = factory.create(UpdateToCollege.class);
            College college = mapper.from(read);
            super.iCollegeRepository.saveAndFlush(college);
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Delete delete)
    {
        try
        {
            IDataTransferObjectMapper<Delete, College> mapper = factory.create(DeleteToCollege.class);
            College college = mapper.from(delete);
            if (super.iCollegeRepository.exists(Example.of(college)))
            {
                super.iCollegeRepository.delete(college);
            }
            else throw new RecordNotFoundException();
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
    }
}
