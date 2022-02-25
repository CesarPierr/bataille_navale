package ensta.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.Hit;
import ensta.model.Player;
import ensta.model.AbstractShip;
import ensta.ai.BattleShipsAI;
import ensta.model.Battleship;
import ensta.model.Carrier;
import ensta.model.Destroyer;
import ensta.model.Submarine;
import ensta.util.ColorUtil;

public class TestGame {
    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Board board = new Board();
        board.print();
        AbstractShip[] batals = {
                new Destroyer(),
                new Carrier(), new Submarine(),
                new Submarine(),
                new Battleship() };
        BattleShipsAI IA = new BattleShipsAI(board, board);
        IA.putShips(batals);
        int detruits = 0;
        Coords coords = new Coords();
        board.print();
        while (detruits != 5) {
            Hit hitOutput = IA.sendHit(coords);
            System.out.println("Tir en " + coords.toString() + " : " + hitOutput.toString());
            if (hitOutput != Hit.MISS && hitOutput != Hit.STRIKE) {
                detruits++;
            }
            board.print();
            sleep(500);
        }
    }
}
