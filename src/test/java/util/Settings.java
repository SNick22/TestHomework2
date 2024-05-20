package util;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.LoginData;
import model.SettingsModel;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class Settings {

    public static String baseUrl;
    public static LoginData validLogin;

    public Settings() {
        try {
            FileInputStream fis = new FileInputStream("src/test/java/data/settings.xml");
            String xml = new String(fis.readAllBytes(), StandardCharsets.UTF_8);
            fis.close();
            XmlMapper mapper = new XmlMapper();
            SettingsModel settingsModel = mapper.readValue(xml, SettingsModel.class);
            baseUrl = settingsModel.baseUrl;
            validLogin = settingsModel.loginData;
        } catch (Throwable ignored) {

        }
    }
}
