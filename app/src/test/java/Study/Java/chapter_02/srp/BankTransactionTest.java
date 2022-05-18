package Study.Java.chapter_02.srp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BankTransactionTest {


  @Test
  void creation() {

    BankTransaction bankTransaction = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100, "taco");

    BankTransaction bankTransaction2 = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100, "taco");

    assertThat(bankTransaction.getDate()).isEqualTo(LocalDate.of(2017, Month.JANUARY, 30));
    assertThat(bankTransaction.getAmount()).isEqualTo(-100);
    assertThat(bankTransaction.getDescription()).isEqualTo("taco");
    assertThat(bankTransaction).isEqualTo(bankTransaction2);

  }

}
