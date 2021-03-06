package gui.utils;

import gui.fields.DateField;
import gui.fields.IntegerField;
import gui.styled_components.StyledJLabel;
import gui.styled_components.StyledJPanel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimePanel extends StyledJPanel {

    private DateField dateField;
    private IntegerField hourField;
    private IntegerField minuteField;

    public DateTimePanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        add(new StyledJLabel("Date (year-month-day):"));

        dateField = new DateField();
        dateField.setDate(LocalDate.now());
        add(dateField);

        add(new StyledJLabel("Time (24h): "));

        hourField = new IntegerField();
        hourField.setMaxValue(23);
        hourField.setColumns(2);
        hourField.setHorizontalAlignment(JTextField.CENTER);
        add(hourField);

        minuteField = new IntegerField();
        minuteField.setMaxValue(59);
        minuteField.setColumns(2);
        minuteField.setHorizontalAlignment(JTextField.CENTER);
        add(minuteField);

        setDateTime(LocalDateTime.now());
    }

    public LocalDateTime getDateTime() {
        return LocalDateTime.of(
                dateField.getDate(),
                LocalTime.of(Integer.parseInt(hourField.getText()), Integer.parseInt(minuteField.getText()))
        );
    }

    public void setDateTime(final LocalDateTime dateTime) {
        dateField.setDate(dateTime.toLocalDate());
        hourField.setText("" + dateTime.format(DateTimeFormatter.ofPattern("HH")));
        minuteField.setText("" + dateTime.format(DateTimeFormatter.ofPattern("mm")));
    }
}
