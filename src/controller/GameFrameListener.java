package controller;

import view.GameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrameListener implements ActionListener {
    private GameFrame view;
    private Game game;
    private BrainGame brainGame;

    public GameFrameListener(GameFrame view) {
        this.view = view;
    }

    private void onNewGameMenuItemClicked() {
        if (game != null) {
            if (JOptionPane.showConfirmDialog(view, "게임이 이미 진행 중입니다.\n새 게임을 시작할까요?", view.getTitle(), 2) == 1)
                return;
            if (game.getFlag())
                game.setFlag(false);
            game = null;
        }
        else if(brainGame != null){
            if (JOptionPane.showConfirmDialog(view, "게임이 이미 진행 중입니다.\n새 게임을 시작할까요?", view.getTitle(), 2) == 1)
                return;
            if (brainGame.getFlag())
                brainGame.setFlag(false);
            brainGame = null;
        }
        game = new Game(view.getGamePanel());
        view.getGamePanel().getInputPanel().getInputText().addActionListener(game);
        Thread th = new Thread(game);
        th.start();
    }

    private void onNewGameBrainMenuItemClicked() {
        if (brainGame != null) {
            if (JOptionPane.showConfirmDialog(view, "게임이 이미 진행 중입니다.\n새 게임을 시작할까요?", view.getTitle(), 2) == 1)
                return;
            if (brainGame.getFlag())
                brainGame.setFlag(false);
            brainGame = null;
        }
        else if(game != null){
            if (JOptionPane.showConfirmDialog(view, "게임이 이미 진행 중입니다.\n새 게임을 시작할까요?", view.getTitle(), 2) == 1)
                return;
            if (game.getFlag())
                game.setFlag(false);
            game = null;
        }
        brainGame = new BrainGame(view.getGamePanel());
        view.getGamePanel().getInputPanel().getInputText().addActionListener(brainGame);
        Thread th = new Thread(brainGame);
        th.start();
    }

    private void onLeaderBoardMenuItemClicked() {
        if (!view.getLeaderBoardDialog().isVisible())
            view.getLeaderBoardDialog().setVisible(true);
        else
            view.getLeaderBoardDialog().requestFocus();
    }

    private void onExitMenuItemClicked() {
        if (JOptionPane.showConfirmDialog(view, "정말로 종료할까요?", view.getTitle(), 0) == 0)
            System.exit(0);
    }

    private void onWordListMenuItemClicked() {
        if (!view.getWordDialog().isVisible())
            view.getWordDialog().setVisible(true);
        else
            view.getWordDialog().requestFocus();
    }

    private void onCreateGameMenuItemClicked() {
    }

    private void onJoinGameMenuItemClicked() {
    }

    private void onExitGameMenuItemClicked() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "새 클래식 게임":
                onNewGameMenuItemClicked();
                break;
            case "새 브레인 게임":
                onNewGameBrainMenuItemClicked();
                break;
            case "리더보드":
                onLeaderBoardMenuItemClicked();
                break;
            case "끝내기":
                onExitMenuItemClicked();
                break;
            case "단어 목록":
                onWordListMenuItemClicked();
                break;
            case "게임 생성":
                onCreateGameMenuItemClicked();
                break;
            case "게임 참가":
                onJoinGameMenuItemClicked();
                break;
            case "게임 나가기":
                onExitGameMenuItemClicked();
                break;
        }
    }
}
