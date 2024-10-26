package platform;

import pages.RegistrationPage;
import pages.ProductPage;
import pages.HomePage;
import pages.LoginPage;


public class SdetUnicorns {
    public LoginPage login;
    public HomePage home;
    public RegistrationPage registration;
    public ProductPage product;


    public SdetUnicorns(){

        login = new LoginPage();
        home = new HomePage();
    }
}
