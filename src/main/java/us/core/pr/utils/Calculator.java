package us.core.pr.utils;

import us.core.pr.domain.db.entities.university.Student;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.AbstractMap;

public class Calculator
        implements Serializable
{
    public static BigDecimal average(Student student)
    {
        AbstractMap.SimpleEntry<BigDecimal, BigDecimal> entry = student.getCourseTaken().stream().map(courseTaken ->
        {
            BigDecimal grade = BigDecimal.valueOf(courseTaken.getGrade());
            BigDecimal credit = BigDecimal.valueOf(courseTaken.getCourse().getCredit());
            return new AbstractMap.SimpleEntry<>(grade.multiply(credit), credit);
        }).reduce((fEntry, sEntry) ->
        {
            BigDecimal key = fEntry.getKey().add(sEntry.getKey());
            BigDecimal value = fEntry.getValue().add(sEntry.getValue());
            return new AbstractMap.SimpleEntry<>(key, value);
        }).get();

        BigDecimal avg = entry.getKey().divide(entry.getValue(), RoundingMode.DOWN);
        return avg;
    }
}
