package view;

import controller.GameFrameListener;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private GameFrameListener controller = new GameFrameListener(this);

    private JMenuBar menuBar = makeMenu();
    private JToolBar toolBar = makeToolBar();
    private GamePanel gamePanel = new GamePanel();
    private WordDialog wordDialog = new WordDialog(this);
    private LeaderBoardDialog leaderBoardDialog;
    private AudioDialog audioDialog = new AudioDialog(this);

    public GameFrame() {
        super("타이핑 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setJMenuBar(menuBar);
        Container c = getContentPane();
        c.add(toolBar, BorderLayout.NORTH);
        c.add(gamePanel, BorderLayout.CENTER);
        setVisible(true);

        JTextField inputText = gamePanel.getInputPanel().getInputText();
        inputText.setFocusable(true);
        inputText.requestFocus();
    }

    private JMenuBar makeMenu() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(MyColor.DARK);

        JMenu gameMenu = new JMenu("게임");
        JMenuItem newGameMenuItem = new JMenuItem("새 클래식 게임");
        JMenuItem newGameBrainMenuItem = new JMenuItem("새 브레인 게임");
        JMenuItem leaderBoardMenuItem = new JMenuItem("리더보드");
        JMenuItem exitMenuItem = new JMenuItem("끝내기");

        newGameMenuItem.setBackground(MyColor.DARK);
        newGameBrainMenuItem.setBackground(MyColor.DARK);
        leaderBoardMenuItem.setBackground(MyColor.DARK);
        exitMenuItem.setBackground(MyColor.DARK);

        newGameMenuItem.addActionListener(controller);
        newGameBrainMenuItem.addActionListener(controller);
        leaderBoardMenuItem.addActionListener(controller);
        exitMenuItem.addActionListener(controller);

        gameMenu.add(newGameMenuItem);
        gameMenu.add(newGameBrainMenuItem);
        gameMenu.addSeparator();
        gameMenu.add(leaderBoardMenuItem);
        gameMenu.addSeparator();
        gameMenu.add(exitMenuItem);

        JMenu wordMenu = new JMenu("단어");
        JMenuItem wordListMenuItem = new JMenuItem("단어 목록");

        wordListMenuItem.setBackground(MyColor.DARK);

        wordListMenuItem.addActionListener(controller);

        wordMenu.add(wordListMenuItem);

        JMenu settingsMenu = new JMenu("설정");
        JMenuItem soundSettings = new JMenuItem("소리 설정");

        soundSettings.setBackground(MyColor.DARK);

        soundSettings.addActionListener(controller);

        settingsMenu.add(soundSettings);

        menuBar.add(gameMenu);
        menuBar.add(wordMenu);
        menuBar.add(settingsMenu);
        return menuBar;
    }

    private JToolBar makeToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setBackground(MyColor.BASE);

        JButton newGameButton = new JButton("새 클래식 게임");
        JButton newGameBrainButton = new JButton("새 브레인 게임");
        JButton leaderBoardButton = new JButton("리더보드");
        JButton wordListButton = new JButton("단어 목록");

        newGameButton.setBackground(MyColor.LIGHT);
        newGameBrainButton.setBackground(MyColor.LIGHT);
        leaderBoardButton.setBackground(MyColor.LIGHT);
        wordListButton.setBackground(MyColor.LIGHT);

        newGameButton.addActionListener(controller);
        newGameBrainButton.addActionListener(controller);
        leaderBoardButton.addActionListener(controller);
        wordListButton.addActionListener(controller);

        toolBar.add(new JLabel(" 게임 시작 "));
        toolBar.add(newGameButton);
        toolBar.add(newGameBrainButton);
        toolBar.addSeparator();
        toolBar.add(leaderBoardButton);
        toolBar.addSeparator();
        toolBar.add(wordListButton);
        toolBar.setFloatable(false);
        return toolBar;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public WordDialog getWordDialog() {
        return wordDialog;
    }

    public LeaderBoardDialog getLeaderBoardDialog() {
        leaderBoardDialog = new LeaderBoardDialog(this);
        return leaderBoardDialog;
    }

    public AudioDialog getAudioDialog() {
        return audioDialog;
    }
}
