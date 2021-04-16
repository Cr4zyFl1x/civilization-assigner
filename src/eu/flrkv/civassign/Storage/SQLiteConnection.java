package eu.flrkv.civassign.Storage;

import eu.flrkv.civassign.Utils.Utils;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {

    private static final String DATA_FOLDER = System.getProperty("user.home") + "\\.civ6assigner";

    private static final String DATABASE_FILENAME = "data.db";


    private static void createDir()
    {
        File folder = new File(DATA_FOLDER);
        if (!folder.exists()) {
            if (folder.mkdirs()) Utils.consoleLog("INFO", "Created SQLite database file!");
        }
    }

    private static boolean databaseExists()
    {
        return new File(getDatabaseFilepath()).exists();
    }

    private static String getDatabaseFilepath()
    {
        return DATA_FOLDER + "\\" + DATABASE_FILENAME;
    }

    /**
     * Gibt das Connection Objekt der gespeicherten Datenbankverbinfung zur&uuml;ck
     * @return Connection Objekt der gespeicherten Datenbankverbinfung
     * @throws SQLException Falls ein Fehler bei der Verbindung auftrat
     */
    public static Connection getConnection() throws SQLException
    {
        if (!databaseExists()) createDir();
        return DriverManager.getConnection("jdbc:sqlite:" + getDatabaseFilepath());
    }

    /**
     * Führt den Inhalt einer SQL-Skriptdatei aus.
     * @param pScriptPath Pfad zur SQL-Skriptdatei
     */
    public static void executeScript(String pScriptPath)
    {
        try {
            Utils.consoleLog("INFO", "Executing SQL-File '"+pScriptPath+"' ...");
            ScriptRunner runner = new ScriptRunner(getConnection());
            runner.runScript(new InputStreamReader(new FileInputStream(pScriptPath), StandardCharsets.UTF_8));
            runner.setStopOnError(false);
            runner.closeConnection();
        } catch (FileNotFoundException e) {
            Utils.consoleLog("ERROR", "The SQL File ('"+pScriptPath+"') was not found!");
        } catch (SQLException exception) {
            Utils.consoleLog("ERROR", "Database connection error or invalid sql file!");
        }
    }
















}
