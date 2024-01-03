package us.core.pr.domain.crud.impl;

import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;
import us.core.pr.domain.dto.mapper.impl.student.CreateToStudent;
import us.core.pr.domain.dto.mapper.impl.student.DeleteToStudent;
import us.core.pr.domain.dto.mapper.impl.student.StudentToRead;
import us.core.pr.domain.dto.mapper.impl.student.UpdateToStudent;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.domain.dto.student.*;
import us.core.pr.domain.entity.Student;
import us.core.pr.exception.ReadEntityFailureException;
import us.core.pr.exception.RecordNotFoundException;
import us.core.pr.repository.IStudentRepository;
import us.core.pr.domain.crud.abstracts.AbstractStudentJpaCrud;

import javax.persistence.EntityNotFoundException;

@Transactional(rollbackFor = Exception.class)
public class StudentJpaCrud
        extends AbstractStudentJpaCrud
{
    private final IDataTransferObjectMapperFactory factory;

    public StudentJpaCrud(IStudentRepository iStudentRepository, IDataTransferObjectMapperFactory factory)
    {
        super(iStudentRepository);
        this.factory = factory;
    }

    @Override
    public void create(Create create)
    {
        try
        {
            IDataTransferObjectMapper<Create, Student> mapper = factory.create(CreateToStudent.class);
            Student student = mapper.from(create);
            isRepository.saveAndFlush(student);
        }
        catch (Exception ignored)
        {
        }
    }

    @Override
    public Read read(String key)
    {
        try
        {
            IDataTransferObjectMapper<Student, Read> mapper = factory.create(StudentToRead.class);
            Student student = isRepository.findByStudentId(key).orElseThrow(EntityNotFoundException::new);
            Read read = mapper.from(student);
            return read;
        }
        catch (Exception ignored)
        {

        }
        throw new ReadEntityFailureException();
    }

    @Override
    public void update(Update update)
    {
        try
        {

            IDataTransferObjectMapper<Update, Student> mapper = factory.create(UpdateToStudent.class);
            Student student = mapper.from(update);
            isRepository.saveAndFlush(student);
        }
        catch (Exception ignored)
        {
        }
    }

    @Override
    public void delete(Delete delete)
    {
        try
        {
            IDataTransferObjectMapper<Delete, Student> mapper = factory.create(DeleteToStudent.class);
            Student student = mapper.from(delete);
            if (super.isRepository.exists(Example.of(student)))
            {
                isRepository.delete(student);
            }
            else throw new RecordNotFoundException();
        }
        catch (Exception ignored)
        {

        }
    }
}
