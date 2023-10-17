package util;


import java.util.Scanner;

public class Input {
    public static Scanner input = null;

    private Input() {
        input = new Scanner(System.in);
    }

    public static Scanner getInstance() {
        if (input == null)
            new Input();
        return input;
    }
}
