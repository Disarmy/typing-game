package view;

import javax.swing.*;
import java.awt.*;

public class WordDialog extends JDialog {
    private WordPanel wordPanel = new WordPanel();

    public WordDialog(Frame owner) {
        super(owner, "단어", true);
        setMinimumSize(new Dimension(400, 430));
        setResizable(false);
        setContentPane(wordPanel);
    }
}
