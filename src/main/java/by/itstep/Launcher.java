package by.itstep;

import by.itstep.forms.CurrencyWindow;
import by.itstep.service.ICurrencyService;
import by.itstep.service.IInputStreamService;
import by.itstep.service.NBRBCurrencyService;
import by.itstep.service.UrlConnect;

public class Launcher {

    public static void main(String[] args) {

        IInputStreamService inputStreamService = new UrlConnect();
        final ICurrencyService currencyService = new NBRBCurrencyService(inputStreamService);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CurrencyWindow(currencyService);
            }
        });
    }


}
