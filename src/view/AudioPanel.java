package view;

import controller.AudioPanelListener;

import javax.swing.*;

public class AudioPanel extends JPanel {
    private AudioDialog owner;
    private AudioPanelListener controller;

    private JCheckBox effectCheckBox = new JCheckBox("효과음");
    private JSlider effectSlider = new JSlider();
    private JCheckBox backgroundCheckBox = new JCheckBox("배경음");
    private JSlider backgroundSlider = new JSlider();
    private JButton okButton = new JButton("확인");

    public AudioPanel(AudioDialog owner) {
        this.owner = owner;
        controller = new AudioPanelListener(this);

        setBackground(MyColor.BASE);
        effectCheckBox.setBackground(MyColor.BASE);
        effectSlider.setBackground(MyColor.BASE);
        backgroundCheckBox.setBackground(MyColor.BASE);
        backgroundSlider.setBackground(MyColor.BASE);
        okButton.setBackground(MyColor.DARK);

        effectCheckBox.addItemListener(e-> controller.itemStateChanged(e));
        effectSlider.addChangeListener(e-> controller.stateChanged(e));
        backgroundCheckBox.addItemListener(e-> controller.itemStateChanged(e));
        backgroundSlider.addChangeListener(e-> controller.stateChanged(e));
        okButton.addActionListener(e-> controller.onOkButtonClicked());

        add(effectCheckBox);
        add(effectSlider);
        add(backgroundCheckBox);
        add(backgroundSlider);
        add(okButton);
    }

    public AudioDialog getOwner() {
        return owner;
    }

    public JCheckBox getEffectCheckBox() {
        return effectCheckBox;
    }

    public JSlider getEffectSlider() {
        return effectSlider;
    }

    public JCheckBox getBackgroundCheckBox() {
        return backgroundCheckBox;
    }

    public JSlider getBackgroundSlider() {
        return backgroundSlider;
    }
}
