package Study.Java.chapter_02.srp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BankTransaction 클래")
class BankTransactionTest {

    @Test
    void creation() {
        BankTransaction bankTransaction = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100, "taco");
        BankTransaction bankTransaction2 = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100, "taco");

        System.out.println("bankTransaction : "+ bankTransaction);
        System.out.println("bankTransaction2 : "+ bankTransaction2);

        assertThat(bankTransaction.getDate()).isEqualTo(LocalDate.of(2017, Month.JANUARY, 30));
        assertThat(bankTransaction.getAmount()).isEqualTo(-100);
        assertThat(bankTransaction.getDescription()).isEqualTo("taco");
        assertThat(bankTransaction).isEqualTo(bankTransaction2);

    }

}
