package eu.flrkv.civassign;

import com.bulenkov.darcula.DarculaLaf;
import eu.flrkv.civassign.CivUtils.Civilization;
import eu.flrkv.civassign.GUI.Frames.MainMenu;
import eu.flrkv.civassign.GUI.GUIController;
import eu.flrkv.civassign.Storage.SQLiteController;
import eu.flrkv.civassign.Utils.Utils;

import javax.swing.*;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Klasse um das Programm zu starten
 */
public class Main {

    /**
     * Methode, welche bei Programmstart ausgeführt wird. (Startpunkt)
     * @param args Startargumente
     */
    public static void main(String[] args)
    {
        // Main Info (for debugging)
        Utils.consoleLog("INFO", "System main stage reached.");

        // Try to set new look & Feel
        loadLookAndFeel(new DarculaLaf());

        // Try to register Drivers
        registerDrivers();

        // Initialization check
        Init.checkInitialization();

        // Create GUI & Start GUI
        GUIController g = new GUIController();
        SwingUtilities.invokeLater(g::run);
    }

    /**
     * Setzt das Design (Look and Feel) für das Swing UI.
     * Gibt Status- und Fehlermeldungen in der Konsole aus.
     * @param pLookAndFeel Das zu verwendende Design/LookAndFeel als Objekt des Datentyps 'LookAndFeel'
     */
    private static void loadLookAndFeel(LookAndFeel pLookAndFeel)
    {
        try {
            UIManager.setLookAndFeel(pLookAndFeel);
            Utils.consoleLog("INFO", "The LookAndFeel was loaded successfully!");
        } catch (UnsupportedLookAndFeelException e) {
            Utils.consoleLog("ERROR", "Failed to load LookAndFeel!");
        }
    }


    private static void registerDrivers()
    {
        try {
            Utils.consoleLog("INFO", "Registering SQLite JDBC driver...");
            DriverManager.registerDriver(new org.sqlite.JDBC());
            Utils.consoleLog("INFO", "SQLite JDBC Driver was successfully registered!");
        } catch (SQLException e) {
            Utils.consoleLog("ERROR", "Failed to load the mySQL JDBC driver!");
        }
    }





    private static void setCivilizations() {
        Civilization[] civilizations ={
                new Civilization("Ägypten", "Kleopatra"),
                new Civilization("England", "Eleonore von Aquitanien"),
                new Civilization("Frankreich", "Eleonore von Aquitanien"),
                new Civilization("Griechenland", "Gorgo"),
                new Civilization("Phönizien", "Dido"),
                new Civilization("Deutschland", "Friedrich Barbarossa"),
                new Civilization("Indien", "Gandhi"),
                new Civilization("Sumer", "Gilgamensch"),
                new Civilization("Norwegen", "Harald Hardrâde"),
                new Civilization("Japan", "Hojo Tokimune"),
                new Civilization("Frankreich", "Katharina von Medici"),
                new Civilization("Schweden", "Kristina"),
                new Civilization("Maori", "Kupe"),
                new Civilization("Mali", "Mansa Musa"),
                new Civilization("Ungarn", "Matthias Corvinus"),
                new Civilization("Kongo", "Mvemba á Nzinga"),
                new Civilization("Inka", "Pachacútec"),
                new Civilization("Griechenland", "Perikles"),
                new Civilization("Russland", "Peter"),
                new Civilization("Brasilien", "Pedro II."),
                new Civilization("Spanien", "Phillip II."),
                new Civilization("China", "Qin Shi Huang"),
                new Civilization("Arabien", "Saladin"),
                new Civilization("Osmanisches Reich", "Süleyman"),
                new Civilization("Amerika", "Teddy Roosevelt"),
                new Civilization("Skythien", "Tomyris"),
                new Civilization("Rom", "Trajan"),
                new Civilization("England", "Victoria"),
                new Civilization("Kanada", "Wilfried Laurier"),
        };
    }
}