import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngine implements ActionListener {

    SimpleCalculator parent;
    char selectAction = ' ';//+ - * /
    double currentResult = 0;


    CalculatorEngine(SimpleCalculator parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String dispFiledText = parent.displayField.getText();
        double displayValue = 0;
        if (!"".equals(dispFiledText)) {
            displayValue = Double.parseDouble(dispFiledText);
        }
        Object src = e.getSource();
        if (src == parent.buttonPlus) {
            selectAction = '+';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonDivide) {
            selectAction = '/';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonMinus) {
            selectAction = '-';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonMultiply) {
            selectAction = '*';
            currentResult = displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonEqual) {
            if (selectAction == '+') {
                currentResult += displayValue;
                parent.displayField.setText("" + currentResult);

            } else if (selectAction == '-') {
                currentResult -= displayValue;
                parent.displayField.setText("" + currentResult);
            } else if (selectAction == '/') {
                currentResult /= displayValue;
                parent.displayField.setText("" + currentResult);
            } else if (selectAction == '*') {
                currentResult *= displayValue;
                parent.displayField.setText("" + currentResult);
            } else {
                String clickedButtonLable = clickedButton.getText();
                parent.displayField.setText(dispFiledText + clickedButtonLable);
            }


        }
    }
}
