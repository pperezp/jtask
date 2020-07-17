package cl.prezdev.jtask.config;

import java.awt.Color;
import java.io.File;

public class Config {
    public static Integer FONT_SIZE = 16;
    public static Color BACKGROUND_COLOR = Color.black;
    public static Color FOREGROUND_COLOR = Color.white;
    public static Color TREE_SELECTED_COLOR = Color.yellow;
    public static Color DONE_TASK_COLOR = new Color(76,76,76);
    public static Color SELECTED_DONE_TASK_COLOR = new Color(100, 100, 100);
    public static File SAVE_FILE = new File("save.pojo");
}