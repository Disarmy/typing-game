package controller;

import view.GameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrameListener implements ActionListener {
    private GameFrame view;

    public GameFrameListener(GameFrame view) {
        this.view = view;
    }

    private void onNewGameMenuItemClicked() {
    }

    private void onNewGameBrainMenuItemClicked() {
    }

    private void onLeaderBoardMenuItemClicked() {
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
