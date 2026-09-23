package view;
import java.awt.*;
import javax.swing.*;
public class zahlenratenGUI extends JFrame{
    private JLabel lblGesamtpunkte;
    private JLabel lblRundengebnis;
    private JTextField txtEingabe;
    private JTextField txtComputerZahl;
    private JButton btnNochEinmal;

    public zahlenratenGUI() {
        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);
        setVisible(true);
    }
}
