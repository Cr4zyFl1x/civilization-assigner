package eu.flrkv.civassign.Storage;

import eu.flrkv.civassign.Init;
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


public class SQLiteController {

    private static final String DATABASE_FILENAME = "data.db";


    private static boolean databaseFileExists()
    {
        return new File(getDatabaseFilepath()).exists();
    }

    private static String getDatabaseFilepath()
    {
        return Init.CIVILIZATION_DATA_FOLDER + "\\" + DATABASE_FILENAME;
    }

    /**
     * Gibt das Connection Objekt der gespeicherten Datenbankverbinfung zur&uuml;ck
     * @return Connection Objekt der gespeicherten Datenbankverbinfung
     * @throws SQLException Falls ein Fehler bei der Verbindung auftrat
     */
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:sqlite:" + getDatabaseFilepath());
    }

    /**
     * Führt den Inhalt einer SQL-Skriptdatei aus.
     * @param pScriptPath Pfad zur SQL-Skriptdatei
     */
    public static boolean executeScript(String pScriptPath)
    {
        try {
            Utils.consoleLog("INFO", "Executing SQL-File '"+pScriptPath+"' ...");
            ScriptRunner runner = new ScriptRunner(getConnection());
            runner.setEscapeProcessing(false);
            runner.runScript(new InputStreamReader(new FileInputStream(pScriptPath), StandardCharsets.UTF_8));
            runner.setStopOnError(false);
            runner.closeConnection();
            return true;
        } catch (FileNotFoundException e) {
            Utils.consoleLog("ERROR", "The SQL File ('"+pScriptPath+"') was not found!");
            return false;
        } catch (SQLException exception) {
            Utils.consoleLog("ERROR", "Database connection error or invalid sql file!");
            return false;
        }
    }

    public static void initializeConnection()
    {
        if (!databaseFileExists()) {
            Utils.consoleLog("INFO", "Starting initialization of SQLite database!");
            try {
                Connection c = getConnection();
            } catch (SQLException e) {
                // NULL
            }
            executeScript("common/template/db.sql");
        }
    }




















}
