package eu.flrkv.civassign.GUI.Template;

import javax.swing.*;
import java.awt.*;

public abstract class GeneralFrameTemplate extends JFrame {

    public GeneralFrameTemplate(String title, Dimension dim, boolean visibility)
    {
        // Execute parent constructor
        super(title);

        // Set the icon
        this.setIconImage(new ImageIcon("common/images/logos/Frame_logo_origin.png").getImage());

        // Set dimension
        this.setSize(dim);

        // Visibility
        this.setVisible(visibility);
    }

    public GeneralFrameTemplate(String title, Dimension dim)
    {
        // Execute parent constructor
        super(title);

        // Set the icon
        this.setIconImage(new ImageIcon("common/images/logos/Frame_logo_origin.png").getImage());

        // Set dimension
        this.setSize(dim);

        // Visibility
        this.setVisible(true);
    }


}
