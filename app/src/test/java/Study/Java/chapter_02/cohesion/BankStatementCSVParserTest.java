package Study.Java.chapter_02.cohesion;

import Study.Java.chapter_02.coupling.BankStatementCSVParser;
import Study.Java.chapter_02.coupling.BankStatementParser;
import Study.Java.chapter_02.coupling.BankTransaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BankStatementCSVParser 클래스")
class BankStatementCSVParserTest {
    private final BankStatementParser statementParser = new BankStatementCSVParser();

    private BankTransaction EXCEPTION = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
    private BankTransaction EXCEPTION1 = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100, "Deliveroo");
    private BankTransaction EXCEPTION2 = new BankTransaction(LocalDate.of(2017, Month.FEBRUARY, 01), 6000, "Salary");

    private List<BankTransaction> Array_BankTransaction = Arrays.asList(EXCEPTION, EXCEPTION1, EXCEPTION2);

    private String[] LIST_LINE = {"30-01-2017,-50,Tesco", "30-01-2017,-100,Deliveroo", "01-02-2017,6000,Salary"};
    private List<String> ARRAYS_LIST = Arrays.asList(LIST_LINE);

    @Test
    public void shouldParseOnCorrectLine() {
        String LINE = "30-01-2017,-50,Tesco";

        final BankTransaction result = statementParser.parseFrom(LINE);

        assertThat(EXCEPTION.getDate()).isEqualTo(result.getDate());
        assertThat(EXCEPTION.getAmount()).isEqualTo(result.getAmount());
        assertThat(EXCEPTION.getDescription()).isEqualTo(result.getDescription());
    }

    @Test
    public void shouldParseLinesFrom() {
        List<BankTransaction> result = statementParser.parseLinesFrom(ARRAYS_LIST);

        assertThat(result).isNotEmpty();

        BankTransaction bankTransaction = result.get(0);
        BankTransaction bankTransaction1 = result.get(1);
        BankTransaction bankTransaction2 = result.get(2);

        System.out.println("EXCEPTION = "  + bankTransaction);
        System.out.println("EXCEPTION1 = "  + bankTransaction1);
        System.out.println("EXCEPTION2 = "  + bankTransaction2);

        assertThat(bankTransaction).isEqualTo(Array_BankTransaction.get(0));
        assertThat(bankTransaction1).isEqualTo(Array_BankTransaction.get(1));
        assertThat(bankTransaction2).isEqualTo(Array_BankTransaction.get(2));

        assertThat(bankTransaction.getDate()).isEqualTo(EXCEPTION.getDate());
        assertThat(bankTransaction.getAmount()).isEqualTo(EXCEPTION.getAmount());
        assertThat(bankTransaction.getDescription()).isEqualTo(EXCEPTION.getDescription());

        assertThat(bankTransaction1.getAmount()).isEqualTo(EXCEPTION1.getAmount());

        assertThat(bankTransaction2.getAmount()).isEqualTo(EXCEPTION2.getAmount());

    }
}
