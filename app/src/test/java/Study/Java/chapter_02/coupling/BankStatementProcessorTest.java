package Study.Java.chapter_02.coupling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BankStatementProcessor 클래스")
class BankStatementProcessorTest {
  private List<BankTransaction> bankTransactionList;

  private double TOTAL = 0;
  private Month month = Month.FEBRUARY;
  private String CATEGORY = "Salary";

  @BeforeEach
  void setUp() {
    bankTransactionList = Arrays.asList(new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco"),
                                        new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100, "Deliveroo"),
                                        new BankTransaction(LocalDate.of(2017, Month.FEBRUARY, 01), 6000, "Salary"));
  }

  @Test
  void calculateTotalAmount() {
    for (BankTransaction bankTransaction : bankTransactionList) {
      TOTAL += bankTransaction.getAmount();
    }

    assertThat(TOTAL).isEqualTo(5850);
  }

  @Test
  void calculateTotalInMonth() {
    for (BankTransaction bankTransaction : bankTransactionList) {
      if(bankTransaction.getDate().getMonth() == month) {
        TOTAL = bankTransaction.getAmount();
      }
    }

    assertThat(TOTAL).isEqualTo(6000);
  }

  @Test
  void calculateTotalForCategory() {
    for (BankTransaction bankTransaction : bankTransactionList) {
      if(bankTransaction.getDescription() == CATEGORY) {
        TOTAL = bankTransaction.getAmount();
      }
    }

    assertThat(TOTAL).isEqualTo(6000);
  }

}
