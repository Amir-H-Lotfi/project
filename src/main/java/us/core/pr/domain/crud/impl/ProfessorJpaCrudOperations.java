package us.core.pr.domain.crud.impl;

import org.springframework.data.domain.Example;
import us.core.pr.domain.crud.abstractions.abstracts.AbstractProfessorJpaCrud;
import us.core.pr.exception.utils.mapper.MapperNotFoundException;
import us.core.pr.utils.mapper.factory.abstractions.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.utils.mapper.impl.professor.CreateToProfessor;
import us.core.pr.utils.mapper.impl.professor.DeleteToProfessor;
import us.core.pr.utils.mapper.impl.professor.ProfessorToRead;
import us.core.pr.utils.mapper.impl.professor.UpdateToProfessor;
import us.core.pr.utils.mapper.abstractions.IDataTransferObjectMapper;
import us.core.pr.domain.entity.Professor;
import us.core.pr.exception.entity.ProfessorRecordNotFoundException;
import us.core.pr.exception.entity.RecordNotFoundException;
import us.core.pr.repository.IProfessorRepository;
import us.core.pr.domain.dto.professor.*;
import us.core.pr.exception.jpa.professor.*;

public class ProfessorJpaCrudOperations
        extends AbstractProfessorJpaCrud
{
    private final IDataTransferObjectMapperFactory factory;

    public ProfessorJpaCrudOperations(IProfessorRepository ipRepository, IDataTransferObjectMapperFactory factory)
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
        catch (IllegalArgumentException| MapperNotFoundException e)
        {
            throw new ProfessorEntityCreatingFailureException(e);
        }
    }

    @Override
    public Read read(String key)
    {
        try
        {
            IDataTransferObjectMapper<Professor, Read> mapper = factory.create(ProfessorToRead.class);
            Professor professor = super.ipRepository.findByPersonnelId(key).orElseThrow(ProfessorRecordNotFoundException::new);
            return mapper.from(professor);
        }
        catch (MapperNotFoundException | ProfessorRecordNotFoundException e)
        {
            throw new ProfessorEntityReadingFailureException(e);
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
        catch (IllegalArgumentException | MapperNotFoundException e)
        {
            throw new ProfessorEntityUpdatingFailureException(e);
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
            else
                throw new ProfessorRecordNotFoundException();
        }
        catch (MapperNotFoundException | ProfessorRecordNotFoundException e)
        {
            throw new ProfessorEntityRemovingFailureException(e);
        }
    }
}
