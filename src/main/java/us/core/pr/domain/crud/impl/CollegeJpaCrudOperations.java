package us.core.pr.domain.crud.impl;

import org.springframework.data.domain.Example;
import us.core.pr.domain.crud.abstractions.abstracts.AbstractCollegeJpaCrud;
import us.core.pr.exception.utils.mapper.MapperNotFoundException;
import us.core.pr.utils.mapper.factory.abstractions.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.utils.mapper.impl.college.CollegeToRead;
import us.core.pr.utils.mapper.impl.college.CreateToCollege;
import us.core.pr.utils.mapper.impl.college.DeleteToCollege;
import us.core.pr.utils.mapper.impl.college.UpdateToCollege;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.entity.College;
import us.core.pr.exception.entity.CollegeRecordNotFoundException;
import us.core.pr.exception.entity.RecordNotFoundException;
import us.core.pr.repository.ICollegeRepository;
import us.core.pr.domain.dto.college.*;
import us.core.pr.exception.jpa.college.*;

public class CollegeJpaCrudOperations
        extends AbstractCollegeJpaCrud
{

    private final IDataTransferObjectMapperFactory factory;

    public CollegeJpaCrudOperations(ICollegeRepository icRepository, IDataTransferObjectMapperFactory factory)
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
        catch (MapperNotFoundException | IllegalArgumentException e)
        {
            throw new CollegeEntityCreatingFailureException(e);
        }
    }

    @Override
    public Read read(String key)
    {
        try
        {
            IDataTransferObjectMapper<College, Read> mapper = factory.create(CollegeToRead.class);
            College college = super.iCollegeRepository.findByName(key).orElseThrow(CollegeRecordNotFoundException::new);
            Read read = mapper.from(college);
            return read;
        }
        catch (MapperNotFoundException | CollegeRecordNotFoundException e)
        {
            throw new CollegeEntityReadingFailureException(e);
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
        catch (IllegalArgumentException | MapperNotFoundException e)
        {
            throw new CollegeEntityUpdatingFailureException(e);
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
            else throw new CollegeRecordNotFoundException();
        }
        catch (MapperNotFoundException | RecordNotFoundException e)
        {
            throw new CollegeEntityRemovingFailureException(e);
        }
    }
}
