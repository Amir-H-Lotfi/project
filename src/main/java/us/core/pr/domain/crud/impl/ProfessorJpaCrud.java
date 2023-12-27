package us.core.pr.domain.crud.impl;

import org.springframework.data.domain.Example;
import us.core.pr.domain.crud.abstracts.AbstractProfessorJpaCrud;
import us.core.pr.domain.dto.ProfessorDTO;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.domain.dto.mapper.impl.ProfessorDTOMapper;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.Professor;
import us.core.pr.exception.jpa.RecordNotFoundException;
import us.core.pr.repository.IProfessorRepository;

public class ProfessorJpaCrud
        extends AbstractProfessorJpaCrud
{
    private final IDataTransferObjectMapperFactory factory;

    public ProfessorJpaCrud(IProfessorRepository ipRepository, IDataTransferObjectMapperFactory factory)
    {
        super(ipRepository);
        this.factory = factory;
    }

    @Override
    public void create(ProfessorDTO.Create create)
    {

        try
        {
            IDataTransferObjectMapper<ProfessorDTO.Create, Professor> mapper = factory.create(ProfessorDTOMapper.CreateToProfessor.class);
            Professor professor = mapper.from(create);
            super.ipRepository.saveAndFlush(professor);
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProfessorDTO.Read read(String key)
    {
        try
        {
            IDataTransferObjectMapper<Professor, ProfessorDTO.Read> mapper = factory.create(ProfessorDTOMapper.ProfessorToRead.class);
            Professor professor = super.ipRepository.findById(key).orElseThrow(RecordNotFoundException::new);
            return mapper.from(professor);
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(ProfessorDTO.Update update)
    {
        try
        {
            IDataTransferObjectMapper<ProfessorDTO.Update, Professor> mapper = factory.create(ProfessorDTOMapper.UpdateToProfessor.class);
            Professor professor = mapper.from(update);
            super.ipRepository.saveAndFlush(professor);
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(ProfessorDTO.Delete delete)
    {
        try
        {
            IDataTransferObjectMapper<ProfessorDTO.Delete, Professor> mapper = factory.create(ProfessorDTOMapper.DeleteToProfessor.class);
            Professor professor = mapper.from(delete);
            if (super.ipRepository.exists(Example.of(professor)))
            {
                super.ipRepository.delete(professor);
            }
            else throw new RecordNotFoundException();
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
    }
}
