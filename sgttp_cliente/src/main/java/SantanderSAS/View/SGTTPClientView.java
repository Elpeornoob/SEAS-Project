package SantanderSAS.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import bryan.io.array.Array;

public class SGTTPClientView {
    BufferedReader br;
    String border = "++++++++++++++++++++++++++++++++++++";

    public SGTTPClientView() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public Array<String> showLoginConsole() {
        Array<String> loginData = new Array<>(2);
        System.out.println(border);
        System.out.println("Login");
        System.out.println(border);
        try {
            System.out.println("Login:");
            String login = br.readLine();
            loginData.add(login);
            System.out.println("Password:");
            String password = br.readLine();
            loginData.add(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginData;
    }

    public void showMainConsole() {
        System.out.println(border);
        System.out.println("Main");
        System.out.println(border);
    }

    public boolean showLoginError() {
        try {
            System.out.println("Login error");
            System.out.println("y/n");
            return br.readLine().equals("y");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public
}
