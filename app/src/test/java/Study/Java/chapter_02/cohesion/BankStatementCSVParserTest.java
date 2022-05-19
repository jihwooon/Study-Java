package Study.Java.chapter_02.cohesion;

import Study.Java.chapter_02.coupling.BankStatementCSVParser;
import Study.Java.chapter_02.coupling.BankStatementParser;
import Study.Java.chapter_02.coupling.BankTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("BankStatementCSVParser 클래스")
class BankStatementCSVParserTest {
    private final BankStatementParser statementParser = new BankStatementCSVParser();
    private List<BankTransaction> Array_BankTransaction;
    private String[] LIST_CSV = {"30-01-2017,-50,Tesco", "30-01-2017,-100,Deliveroo", "01-02-2017,6000,Salary"};
    private List<String> ARRAYS_LIST = Arrays.asList(LIST_CSV);

    @BeforeEach
    void setUp() {
        Array_BankTransaction = Arrays.asList(new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco"),
                                              new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100, "Deliveroo"),
                                              new BankTransaction(LocalDate.of(2017, Month.FEBRUARY, 01), 6000, "Salary"));
    }

    @Test
    @DisplayName("라인의 따른 Parse 확인")
    public void shouldParseOnCorrectLine() {
        String LINE = "30-01-2017,-50,Tesco";

        final BankTransaction result = statementParser.parseFrom(LINE);

        assertThat(Array_BankTransaction.get(0).getDate()).isEqualTo(result.getDate());
        assertThat(Array_BankTransaction.get(0).getAmount()).isEqualTo(result.getAmount());
        assertThat(Array_BankTransaction.get(0).getDescription()).isEqualTo(result.getDescription());

    }

    @Test
    @DisplayName("List로부터 라인 확인")
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

        assertThat(bankTransaction.getDate()).isEqualTo(Array_BankTransaction.get(0).getDate());
        assertThat(bankTransaction.getAmount()).isEqualTo(Array_BankTransaction.get(0).getAmount());
        assertThat(bankTransaction.getDescription()).isEqualTo(Array_BankTransaction.get(0).getDescription());

    }

    @Test
    void shouldMockingTest() {
      List mockedList = mock(List.class);

      given(mockedList.get(0)).willReturn("one");

      System.out.println(mockedList.get(0));

      verify(mockedList).get(0);

    }
}
