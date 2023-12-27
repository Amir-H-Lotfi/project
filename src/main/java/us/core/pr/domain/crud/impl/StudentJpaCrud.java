package us.core.pr.domain.crud.impl;

import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;
import us.core.pr.domain.dto.StudentDTO;
import us.core.pr.domain.dto.mapper.interfaces.IDataTransferObjectMapper;
import us.core.pr.domain.dto.mapper.factory.interfaces.IDataTransferObjectMapperFactory;
import us.core.pr.domain.dto.mapper.impl.StudentDTOMapper;
import us.core.pr.domain.entity.Student;
import us.core.pr.exception.FailedToReadEntityException;
import us.core.pr.exception.jpa.RecordNotFoundException;
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
    public void create(StudentDTO.Create create)
    {
        try
        {
            IDataTransferObjectMapper<StudentDTO.Create, Student> mapper = factory.create(StudentDTOMapper.CreateToStudent.class);
            Student student = mapper.from(create);
            isRepository.saveAndFlush(student);
        }
        catch (Exception ignored)
        {
        }
    }

    @Override
    public StudentDTO.Read read(String key)
    {
        try
        {
            IDataTransferObjectMapper<Student, StudentDTO.Read> mapper = factory.create(StudentDTOMapper.StudentToRead.class);
            Student student = isRepository.findById(key).orElseThrow(EntityNotFoundException::new);
            StudentDTO.Read read = mapper.from(student);
            return read;
        }
        catch (Exception ignored)
        {

        }
        throw new FailedToReadEntityException();
    }

    @Override
    public void update(StudentDTO.Update update)
    {
        try
        {

            IDataTransferObjectMapper<StudentDTO.Update, Student> mapper = factory.create(StudentDTOMapper.UpdateToStudent.class);
            Student student = mapper.from(update);
            isRepository.saveAndFlush(student);
        }
        catch (Exception ignored)
        {
        }
    }

    @Override
    public void delete(StudentDTO.Delete delete)
    {
        try
        {
            IDataTransferObjectMapper<StudentDTO.Delete, Student> mapper = factory.create(StudentDTOMapper.DeleteToStudent.class);
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
