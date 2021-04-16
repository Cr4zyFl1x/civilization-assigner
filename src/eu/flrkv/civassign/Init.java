package eu.flrkv.civassign;

import eu.flrkv.civassign.Storage.SQLiteController;

import java.io.File;

public class Init {

    public static final String DATA_FOLDER = System.getProperty("user.home") + "\\AppData\\Roaming\\CivilizationAssigner";

    public static final String CIVILIZATION_IMAGES_FOLDER = DATA_FOLDER + "\\CivilizationImages";
    public static final String CONFIG_FOLDER = DATA_FOLDER + "\\ConfigFiles";
    public static final String CIVILIZATION_DATA_FOLDER = DATA_FOLDER + "\\CivilizationData";


    public static void checkInitialization()
    {
        File dataFolder = new File(DATA_FOLDER);
        File civImagesFolder = new File(CIVILIZATION_IMAGES_FOLDER);
        File configFolder = new File(CONFIG_FOLDER);
        File civDataFolder = new File(CIVILIZATION_DATA_FOLDER);

        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
            civImagesFolder.mkdirs();
            configFolder.mkdirs();
            civDataFolder.mkdirs();

            SQLiteController.initializeConnection();
        }
    }





}
