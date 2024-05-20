package util;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.LoginData;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoginDataGenerator {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter entity count");
        int count = Integer.parseInt(in.nextLine());
        LoginData[] array = new LoginData[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Enter email");
            String email = in.nextLine();
            System.out.println("Enter password");
            String password = in.nextLine();
            System.out.println("Enter username");
            String username = in.nextLine();
            LoginData data = new LoginData();
            data.email = email;
            data.password = password;
            data.username = username;
            array[i] = data;
        }
        XmlMapper mapper = new XmlMapper();
        File file = new File("src/test/java/data/login_data.xml");
        mapper.writeValue(file, array);
    }
}
