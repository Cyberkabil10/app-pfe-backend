package com.Med.authentication.teleConsult.utils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {

    public Test() {
        // TODO Auto-generated constructor stub
    }

     public String passwordEncoder(String pwd){
            String encodedPwd="",strpwd="";
            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            encodedPwd= encoder.encode(pwd);

             System.out.println("---------------------> ["+pwd+"] / ["+encodedPwd+"]");
              return encodedPwd;
     }

    public static void main(String args []){
        /*EmailValidator v=EmailValidator.getInstance();

        System.out.println("[ achraf.mabrouk@exis-it.com ] = "+v.isValid("achraf.mabrouk@exis-it.com"));
        System.out.println("[ achraf.mabrouk@exis-it ] = "+v.isValid("achraf.mabrouk@exis-it"));
        System.out.println("[ achraf.mabroukAtexis-it ] = "+v.isValid("achraf.mabroukAtexis-it.com"));
        System.out.println("[ @exis-it.com ] = "+v.isValid("@exis-it.com"));*/

         Test t=new Test();
         System.out.println("Crypted password = "+t.passwordEncoder("123"));

    }

}
