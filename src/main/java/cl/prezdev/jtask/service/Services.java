package cl.prezdev.jtask.service;

import cl.prezdev.jtask.config.Config;
import cl.prezdev.util.gui.jpopupmenu.JPopUpMenuService;
import javax.swing.JTree;

public class Services {
    public static JPopUpMenuService jPopUpMenuService;
    public static TaskTreeService treeService;
    public static TaskSaveService taskSaveService;

    public Services(){
        throw new IllegalStateException("Utility class");
    }
    
    public static void initServices(JTree jTree){
        jPopUpMenuService = new JPopUpMenuService(jTree);
        treeService = new TaskTreeService(jTree);
        taskSaveService = new TaskSaveService(Config.SAVE_FILE);
    }
}
