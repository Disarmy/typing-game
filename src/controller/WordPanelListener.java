package controller;

import model.WordManager;
import view.WordPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

public class WordPanelListener {
    private WordPanel view;
    private WordManager wordManager = new WordManager();

    public WordPanelListener(WordPanel view) {
        this.view = view;
    }

    public void onAddButtonClicked() {
        wordManager.add(view.getText());
        view.setText("");
        refresh();
    }

    public void onRemoveButtonClicked() {
        wordManager.remove(view.getText());
        view.setText("");
        refresh();
    }

    public void onSaveButtonClicked() {
        if (wordManager.save())
            JOptionPane.showMessageDialog(view, "저장되었습니다.", "단어", 1);
    }

    public void onLoadButtonClicked() {
        if (wordManager.load())
            refresh();
    }

    private void refresh() {
        view.setSize(wordManager.getSize());
        view.setListData(wordManager.getAllWords());
    }

    public void valueChanged(ListSelectionEvent e) {
        JList<String> list = (JList<String>)e.getSource();
        view.setText(list.getSelectedValue());
    }
}
