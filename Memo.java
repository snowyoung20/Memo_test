package Memo_test;

public class Memo {
    String name;
    String password;
    String text;
    String now;


    public Memo(String name, String password, String text, String now) {
        this.name = name;
        this.password = password;
        this.text = text;
        this.now = now;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getText() {
        return text;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public  String toString(){
        return "이름 : " + name + "\n비밀번호 : " + password + "\n내용 : " + text + "\n작성일 : " + now;
    }

}

