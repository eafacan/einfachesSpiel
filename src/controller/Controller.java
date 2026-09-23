package controller;
import model.GewinnModel;
import view.ZahlenratenGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Controller implements ActionListener {
    private final GewinnModel m;
    private final ZahlenratenGUI g;

    public Controller(GewinnModel m) {
        this.m = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
