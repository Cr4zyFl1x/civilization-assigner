package eu.flrkv.civassign.Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Utils {


    /**
     * Gibt eine Statusmeldung in der Konsole aus.
     * @param pPrefix Prefix/Typ der Statusmeldung (z.B. WARNING/ERROR/INFO)
     * @param pMessage Auszugebende Statusmeldung.
     */
    public static void consoleLog(String pPrefix, String pMessage)
    {
        pPrefix = "[" + pPrefix + "]";
        System.out.println(pPrefix + " " + pMessage);
    }

    public static ImageIcon base64BinaryToImageIcon(String base64)
    {
        try {
            return new ImageIcon(ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode(base64))));
        } catch (IOException e) {
            return null;
        }
    }

    private static String FileToBase64Binary(File file) throws Exception{
        FileInputStream fileInputStreamReader = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        fileInputStreamReader.read(bytes);
        return new String(Base64.getEncoder().encode(bytes), StandardCharsets.UTF_8);
    }
}
