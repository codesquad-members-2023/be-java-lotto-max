package kr.codesquad;

import kr.codesquad.view.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input input = new Input();
        String purchaseAmount = input.input(br, 0);
        String luckyNumber = input.input(br, 1);
    }
}