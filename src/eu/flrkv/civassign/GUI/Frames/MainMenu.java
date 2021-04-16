package eu.flrkv.civassign.GUI.Frames;

import eu.flrkv.civassign.GUI.Template.GeneralFrameTemplate;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends GeneralFrameTemplate {
    private JPanel menuPanel;
    private JLabel logo;

    public MainMenu()
    {
        super("Sid Meier's Civilization VI - Zivilisationsverteiler", new Dimension(900, 600));
        this.setVisible(true);
        this.add(menuPanel);
    }

    private void createUIComponents() {
        logo = new JLabel(new ImageIcon("common/images/logos/Header_logo_65x500.png"));
    }
}
