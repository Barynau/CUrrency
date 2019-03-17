package by.itstep.service;

import by.itstep.entity.Currency;
import java.util.Date;
import java.util.List;

//Сервис для работы с валютами
public interface ICurrencyService {

    //Дай все валюты, с которыми ты работаешь
    List<Currency> getAllCurrencies();

    //Дай мне курс валюты по дате
    Float getExchangeRateByDate(String currency, Date date);

}
