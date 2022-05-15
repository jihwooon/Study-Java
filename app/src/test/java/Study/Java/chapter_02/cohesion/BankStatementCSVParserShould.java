package Study.Java.chapter_02.cohesion;

import Study.Java.chapter_02.coupling.BankStatementCSVParser;
import Study.Java.chapter_02.coupling.BankStatementParser;
import Study.Java.chapter_02.coupling.BankTransaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BankStatementCSVParserShould {

     private final BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOnCorrectLine() throws Exception{
        final String line = "30-01-2017,-50,Tesco";

        final BankTransaction result = statementParser.parseFrom(line);
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0d;

        assertThat(expected.getDate()).isEqualTo(result.getDate());
        assertThat(expected.getAmount()).isEqualTo(result.getAmount());
        assertThat(expected.getDescription()).isEqualTo(result.getDescription());
    }
}
