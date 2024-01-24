package providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import us.core.pr.domain.db.entities.university.Student;

import java.util.stream.Stream;

public class StudentProvider
        implements ArgumentsProvider
{
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception
    {
        return Stream.of(
                (Arguments) new Student()
        );
    }
}
