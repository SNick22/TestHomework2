package tests;

import helpers.LoginHelper;
import model.LoginData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

//@RunWith(Parameterized.class)
public class LoginTest extends BaseTest {

//    private final LoginData loginData;
//
//    @Parameterized.Parameters
//    public static Collection<Object> data() throws IOException {
//        FileInputStream fis = new FileInputStream("src/test/java/data/login_data.xml");
//        String xml = new String(fis.readAllBytes(), StandardCharsets.UTF_8);
//        fis.close();
//        LoginData[] loginDatas = mapper.readValue(xml, LoginData[].class);
//        return Arrays.stream(loginDatas).map((x) -> (Object) x).toList();
//    }
//
//    public LoginTest(LoginData loginData) {
//        super();
//        this.loginData = loginData;
//    }
//
//    @Test
//    public void testLogin() {
//        LoginHelper loginHelper = manager.getLoginHelper();
//        loginHelper.login(loginData);
//        loginHelper.showProfile();
//        String username = loginHelper.getUsername();
//        loginHelper.showProfile();
//        assertEquals(loginData.username, username);
//    }
}
