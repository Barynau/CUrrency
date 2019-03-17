package by.itstep.service;

import java.io.InputStream;

//Отвечает за получение InputStream
//1) по url
//2) из файла
//3) из сети

public interface IInputStreamService {
    InputStream getInputStream(String source);
}
