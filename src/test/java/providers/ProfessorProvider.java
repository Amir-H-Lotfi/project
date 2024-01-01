package providers;

import com.ibm.jvm.trace.format.api.Message;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import us.core.pr.domain.entity.Course;
import us.core.pr.domain.entity.CourseTaught;
import us.core.pr.domain.entity.Professor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ProfessorProvider
        implements ArgumentsProvider
{
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception
    {
        return null;
    }
}
