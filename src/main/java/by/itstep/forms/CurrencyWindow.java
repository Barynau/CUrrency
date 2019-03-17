package by.itstep.forms;

import by.itstep.entity.Currency;
import by.itstep.service.ICurrencyService;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;


public class CurrencyWindow extends JFrame {

    ICurrencyService iCurrencyService;

    public CurrencyWindow(ICurrencyService iCurrencyService) {
        super("Валюты");
        this.iCurrencyService = iCurrencyService;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        final JTextField currencyRB = new JTextField();
        Container panel = new Container();
        final JLabel currecyLabel = new JLabel("BRB");
        panel.add(currecyLabel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(currencyRB);
        content.add(panel);


        final JTextField currencyResult = new JTextField();
        Container panel2 = new Container();
        final JLabel currecyLabel2 = new JLabel("BRB2");
        panel2.add(currecyLabel2);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel2.add(currencyResult);
        content.add(panel2);

        final JLabel currentCurrencyName = new JLabel();
        currentCurrencyName.setAlignmentX(LEFT_ALIGNMENT);
        content.add(currentCurrencyName);

        List<Currency> currencies = iCurrencyService.getAllCurrencies();
        Currency[] array = currencies.toArray(new Currency[currencies.size()]);
        final JComboBox listOfCurrencies = new JComboBox(array);
        listOfCurrencies.setAlignmentX(LEFT_ALIGNMENT);
        content.add(listOfCurrencies);



        final Currency currency = (Currency) listOfCurrencies.getSelectedItem();
        currentCurrencyName.setText(" Курс: " + currency.getRate());
        currecyLabel2.setText(currency.getCharCode());

        currencyRB.getDocument().addDocumentListener(new DocumentListener() {

            public void onChange() {
                if (currencyRB.hasFocus() && currencyRB.getText().length() > 0) {
                    Double currencyRateValue = Double.valueOf(currency.getRate());
                    Double currencyRBValue = Double.valueOf(currencyRB.getText());
                    currencyResult.setText(String.valueOf( currencyRBValue/currencyRateValue));
                }
            }

            public void changedUpdate(DocumentEvent e) {
                onChange();

            }

            public void removeUpdate(DocumentEvent e) {

                onChange();

            }

            public void insertUpdate(DocumentEvent e) {

                onChange();

            }


        });
        currencyResult.getDocument().addDocumentListener(new DocumentListener() {
            public void onChange() {
                if (currencyResult.hasFocus() ) {

                    if( currencyResult.getText().length() > 0) {
                        Double currencyRateValue = Double.valueOf(currencyResult.getText());
                        Double currencyRBValue = Double.valueOf(currency.getRate());
                        currencyRB.setText(String.valueOf(currencyRateValue * currencyRBValue));
                    }else {currencyRB.setText("");}
                }
            }

            public void insertUpdate(DocumentEvent e) {
                onChange();
            }

            public void removeUpdate(DocumentEvent e) {
                onChange();
            }

            public void changedUpdate(DocumentEvent e) {
                onChange();
            }
        });
        listOfCurrencies.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    Currency currency = (Currency) event.getItem();
                    currentCurrencyName.setText(" Курс: " + currency.getRate());
                    currecyLabel2.setText(currency.getCharCode());


                }
            }
        });
        pack();
        setLocation(500, 300);
        setVisible(true);
    }

}






