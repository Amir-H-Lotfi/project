package us.core.pr.domain.crud.impl;

import org.springframework.data.domain.Example;
import us.core.pr.domain.crud.abstracts.AbstractProfessorJpaCrud;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.domain.dto.mapper.impl.professor.CreateToProfessor;
import us.core.pr.domain.dto.mapper.impl.professor.DeleteToProfessor;
import us.core.pr.domain.dto.mapper.impl.professor.ProfessorToRead;
import us.core.pr.domain.dto.mapper.impl.professor.UpdateToProfessor;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.entity.Professor;
import us.core.pr.exception.RecordNotFoundException;
import us.core.pr.repository.IProfessorRepository;
import us.core.pr.domain.dto.professor.*;

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
    public void create(Create create)
    {

        try
        {
            IDataTransferObjectMapper<Create, Professor> mapper = factory.create(CreateToProfessor.class);
            Professor professor = mapper.from(create);
            super.ipRepository.saveAndFlush(professor);
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
            IDataTransferObjectMapper<Professor, Read> mapper = factory.create(ProfessorToRead.class);
            Professor professor = super.ipRepository.findByPersonnelId(key).orElseThrow(RecordNotFoundException::new);
            return mapper.from(professor);
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Update update)
    {
        try
        {
            IDataTransferObjectMapper<Update, Professor> mapper = factory.create(UpdateToProfessor.class);
            Professor professor = mapper.from(update);
            super.ipRepository.saveAndFlush(professor);
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
            IDataTransferObjectMapper<Delete, Professor> mapper = factory.create(DeleteToProfessor.class);
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
