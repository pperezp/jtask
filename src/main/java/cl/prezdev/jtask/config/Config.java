package cl.prezdev.jtask.config;

import java.awt.Color;
import java.io.File;

public class Config {
    public Config(){
        throw new IllegalStateException("Utility class");
    }

    public static final Integer FONT_SIZE = 12;
    public static final Color BACKGROUND_COLOR = Color.black;
    public static final Color FOREGROUND_COLOR = Color.white;
    public static final Color TREE_SELECTED_COLOR = Color.yellow;
    public static final Color DONE_TASK_COLOR = new Color(76,76,76);
    public static final Color SELECTED_DONE_TASK_COLOR = new Color(100, 100, 100);
    public static final File SAVE_FILE = new File("save.pojo");
}
