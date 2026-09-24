package controller;
import model.GewinnModel;
import view.ZahlenratenGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public  class SpielController implements ActionListener {
    private GewinnModel m;
    private ZahlenratenGUI g;

    public SpielController() {
        this.m = new GewinnModel();
        this.g = new ZahlenratenGUI(this);
        g.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enter")) {
            //Enter sperren
            g.getTxtEingabe().setEnabled(false);
            //Eingabe holen
            String eingabe = g.getTxtEingabe().getText();
            int eingabeZahl;
            //Wenn keine zahl eingegeben wird returnen sonst in int umwandeln
            try {
                eingabeZahl = Integer.parseInt(eingabe);
            } catch (NumberFormatException ex) {
                g.getLblRundengebnis().setText("Gib eine Zahl von 1 bis 9");
                return;
            }
            //Prüfn ob zahl zwischen 1 und 9 ist
            if (eingabeZahl < 1 || eingabeZahl > 9) {
                g.getLblRundengebnis().setText("Gib eine Zahl von 1 bis 9");
                return;
            }
            //Runde berechnen
            m.berechneComputerZahl();
            m.berechneRunde(eingabeZahl);
            //GUI aktualieseren
            g.getTxtComputerZahl().setText("" + m.getComputerZahl());
            g.getLblRundengebnis().setText("" + m.getRundenErgebnis());
            g.getLblGesamtpunkte().setText("" + m.getGesamtPunkte());
            //button aktiveren
            g.getBtnNochEinmal().setEnabled(true);
            //Farbe des rundenergebnisses ändern
            if(m.getRundenErgebnis() >= 1){
                g.getLblRundengebnis().setBackground(Color.GREEN);
            }else if(m.getRundenErgebnis() <= -1){
                g.getLblRundengebnis().setBackground(Color.RED);
            }else{
                g.getLblRundengebnis().setBackground(Color.WHITE);
            //Prüfen ob spiel gewonnen oder verloren wurde
            }
            if(m.hatGewonnen()){
                g.getLblRundengebnis().setText("Gewonnen");
                g.getLblRundengebnis().setBackground(Color.GREEN);
                g.getBtnNochEinmal().setEnabled(true);
            }else if(m.hatVerloren()){
                g.getLblRundengebnis().setText("Verloren");
                g.getBtnNochEinmal().setEnabled(true);
                g.getLblRundengebnis().setBackground(Color.RED);
            }
        } else if (e.getActionCommand().equals("NochEinmal")) {
            //GUI updaten
            g.getLblRundengebnis().setText("Gib eine Zahl von 1 bis 9");
            g.getTxtComputerZahl().setText("");
            g.getTxtEingabe().setText("");
            //button deaktivieren und Texteingabe aktivieren
            g.getBtnNochEinmal().setEnabled(false);
            g.getTxtEingabe().setEnabled(true);
            g.getTxtEingabe().setBackground(Color.WHITE);
            g.getLblGesamtpunkte().setBackground(Color.WHITE);
            g.getLblRundengebnis().setBackground(Color.WHITE);
        }
    }
    public static void main(String[] args) {
        new SpielController();
    }
}
