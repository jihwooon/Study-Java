package Study.Java.chapter_02.cohesion;

import Study.Java.chapter_02.coupling.BankStatementCSVParser;
import Study.Java.chapter_02.coupling.BankStatementParser;
import Study.Java.chapter_02.coupling.BankTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BankStatementCSVParser 클래스")
class BankStatementCSVParserTest {

    private final BankStatementParser statementParser = new BankStatementCSVParser();
    private String LINE;
    private BankTransaction EXCEPTION;

    @BeforeEach
    void setUp() {
        LINE = "30-01-2017,-50,Tesco";
        EXCEPTION = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
    }

    @DisplayName("ㅇㅇ")
    @Test
    public void shouldParseOnCorrectLine() {
        final BankTransaction result = statementParser.parseFrom(LINE);

        assertThat(EXCEPTION.getDate()).isEqualTo(result.getDate());
        assertThat(EXCEPTION.getAmount()).isEqualTo(result.getAmount());
        assertThat(EXCEPTION.getDescription()).isEqualTo(result.getDescription());
    }

    @Test
    public void shouldParseLinesFrom() {
        List<BankTransaction> result = statementParser.parseLinesFrom(List.of(LINE));

        assertThat(result).isNotEmpty();

        BankTransaction bankTransaction = result.get(0);

        assertThat(bankTransaction.getDate()).isEqualTo(EXCEPTION.getDate());
        assertThat(bankTransaction.getAmount()).isEqualTo(EXCEPTION.getAmount());
        assertThat(bankTransaction.getDescription()).isEqualTo(EXCEPTION.getDescription());

    }
}
