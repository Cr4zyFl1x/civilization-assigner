package eu.flrkv.civassign.GUI.Frames;

import eu.flrkv.civassign.GUI.Template.GeneralFrameTemplate;
import eu.flrkv.civassign.Utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class MainMenu extends GeneralFrameTemplate {
    private JPanel menuPanel;
    private JLabel logo;

    public MainMenu()
    {
        super("Sid Meier's Civilization VI - Zivilisationsverteiler", new Dimension(900, 600));
        this.setVisible(true);
        this.add(menuPanel);
    }


    private void createUIComponents()
    {

    }
}
