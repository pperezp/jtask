package cl.prezdev.jtask.service;

import cl.prezdev.jtask.config.Config;
import cl.prezdev.util.gui.jpopupmenu.JPopUpMenuService;
import javax.swing.JTree;

public class Services {
    public static JPopUpMenuService popUpMenuService;
    public static TaskTreeService treeService;
    public static TaskSaveService saveService;
    public static TaskService taskService;

    public Services(){
        throw new IllegalStateException("Utility class");
    }
    
    public static void initServices(JTree jTree){
        popUpMenuService = new JPopUpMenuService(jTree);
        treeService = new TaskTreeService(jTree);
        saveService = new TaskSaveService(Config.SAVE_FILE);
        taskService = new TaskService();
    }
}
