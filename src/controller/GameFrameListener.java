package controller;

import view.GameFrame;

import javax.swing.*;

public class GameFrameListener {
    private GameFrame view;
    private Game game;
    private BrainGame brainGame;

    public GameFrameListener(GameFrame view) {
        this.view = view;
    }

    private boolean isGameRunning() {
        return game != null || brainGame != null;
    }

    private void stopGame() {
        if (game != null && game.getFlag())
            game.stop();
        if (brainGame != null && brainGame.getFlag())
            brainGame.stop();
        game = null;
        brainGame = null;
    }

    public void onNewGameMenuItemClicked() {
        if (isGameRunning()) {
            if (JOptionPane.showConfirmDialog(view, "게임이 이미 진행 중입니다.\n새 게임을 시작할까요?", view.getTitle(), 2) == 2)
                return;
            stopGame();
        }
        game = new Game(view.getGamePanel());
        view.getGamePanel().getInputPanel().getInputText().addActionListener(game);
        Thread th = new Thread(game);
        th.start();
    }

    public void onNewGameBrainMenuItemClicked() {
        if (isGameRunning()) {
            if (JOptionPane.showConfirmDialog(view, "게임이 이미 진행 중입니다.\n새 게임을 시작할까요?", view.getTitle(), 2) == 2)
                return;
            stopGame();
        }
        brainGame = new BrainGame(view.getGamePanel());
        view.getGamePanel().getInputPanel().getInputText().addActionListener(brainGame);
        Thread th = new Thread(brainGame);
        th.start();
    }

    public void onLeaderBoardMenuItemClicked() {
        if (!view.getLeaderBoardDialog().isVisible())
            view.getLeaderBoardDialog().setVisible(true);
        else
            view.getLeaderBoardDialog().requestFocus();
    }

    public void onExitMenuItemClicked() {
        if (JOptionPane.showConfirmDialog(view, "정말로 종료할까요?", view.getTitle(), 0) == 0)
            System.exit(0);
    }

    public void onWordListMenuItemClicked() {
        if (!view.getWordDialog().isVisible())
            view.getWordDialog().setVisible(true);
        else
            view.getWordDialog().requestFocus();
    }

    public void onSoundSettingsMenuItemClicked() {
        if (!view.getAudioDialog().isVisible())
            view.getAudioDialog().setVisible(true);
        else
            view.getAudioDialog().requestFocus();
    }
}
