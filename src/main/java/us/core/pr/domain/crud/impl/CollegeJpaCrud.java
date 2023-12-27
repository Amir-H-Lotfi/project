package us.core.pr.domain.crud.impl;

import org.springframework.data.domain.Example;
import us.core.pr.domain.crud.abstracts.AbstractCollegeJpaCrud;
import us.core.pr.domain.dto.CollegeDTO;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.domain.dto.mapper.impl.CollegeDTOMapper;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.College;
import us.core.pr.exception.jpa.RecordNotFoundException;
import us.core.pr.repository.ICollegeRepository;

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
    public void create(CollegeDTO.Create create)
    {

        try
        {
            IDataTransferObjectMapper<CollegeDTO.Create, College> mapper = factory.create(CollegeDTOMapper.CreateToCollege.class);
            College college = mapper.from(create);
            super.iCollegeRepository.saveAndFlush(college);

        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CollegeDTO.Read read(String key)
    {
        try
        {
            IDataTransferObjectMapper<College, CollegeDTO.Read> mapper = factory.create(CollegeDTOMapper.CollegeToRead.class);
            College college = super.iCollegeRepository.findById(key).orElseThrow(RecordNotFoundException::new);
            CollegeDTO.Read read = mapper.from(college);
            return read;
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(CollegeDTO.Update read)
    {
        try
        {
            IDataTransferObjectMapper<CollegeDTO.Update, College> mapper = factory.create(CollegeDTOMapper.UpdateToCollege.class);
            College college = mapper.from(read);
            super.iCollegeRepository.saveAndFlush(college);
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(CollegeDTO.Delete delete)
    {
        try
        {
            IDataTransferObjectMapper<CollegeDTO.Delete, College> mapper = factory.create(CollegeDTOMapper.DeleteToCollege.class);
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
