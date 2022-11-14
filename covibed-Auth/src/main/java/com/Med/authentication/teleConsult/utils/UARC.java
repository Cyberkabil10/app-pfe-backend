package com.Med.authentication.teleConsult.utils;
// UARC = User Authentication Response Code
public class UARC {

    private int code;
    private String message;

    public UARC() {
        // TODO Auto-generated constructor stub
        this.code=100;
        this.message=getErrorMessage(code);
    }
    public UARC(int code) {
        this.code=code;
        this.message=getErrorMessage(code);
    }

    public int getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }

    private String getErrorMessage(int code){
        String msg="";
        switch(code){
        case 100:msg="User registered succssefully";
            break;
        case 101:msg="Error : Email user is empty";
        break;
        case 102:msg="Error : Email user is empty";
            break;
        case 103:msg="Error : Username is empty";
        break;
        case 104:msg="Error : Invalid email";
        break;
        case 105:msg="Error : problem when adding User into Database...";
        break;
        case 106:msg="Error : No parameter, User information is empty...";
        break;
        default: msg="Error : Internal error, please check your administrator";
            break;
        }

        return msg;
    }

}
