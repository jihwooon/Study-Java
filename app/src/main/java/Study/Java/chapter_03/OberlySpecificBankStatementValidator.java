package Study.Java.chapter_03;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

public class OberlySpecificBankStatementValidator {

  private String description;
  private String date;
  private String amount;

  public OberlySpecificBankStatementValidator(String description, String date, String amount) {
    this.description = Objects.requireNonNull(description);
    this.date = Objects.requireNonNull(date);
    this.amount = Objects.requireNonNull(amount);
  }

  public Notification validate() {

    final Notification notification = new Notification();

    if(this.description.length() > 100) {
      notification.addError("The description is too long");
    }

    final LocalDate parseDate;
    try {
      parseDate = LocalDate.parse(this.date);
      if (parseDate.isAfter(LocalDate.now())) {
        notification.addError("date cannot be in the future");
      }
    }
    catch (DateTimeException e) {
      notification.addError("Invalid format for date");
    }

    final double amount;
    try {
      amount = Double.parseDouble(this.amount);
    }
    catch (NumberFormatException e) {
      notification.addError("Invalid format for amount");
    }
    return notification;
  }
}
