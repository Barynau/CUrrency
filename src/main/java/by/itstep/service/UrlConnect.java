package by.itstep.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


//Реализация получения InputStream из Интернета
public class UrlConnect implements IInputStreamService {
    public InputStream getInputStream(String url) {
        try {
            return new URL(url).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
