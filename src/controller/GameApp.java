package controller;

import model.WordManager;
import view.GameFrame;

public class GameApp {
	public static WordManager wordManager = new WordManager();

	public static void main(String[] args) {
		GameFrame f = new GameFrame();
	}

}
