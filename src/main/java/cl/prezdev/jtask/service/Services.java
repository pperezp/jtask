package cl.prezdev.jtask.service;

import cl.prezdev.jtask.config.Config;
import cl.prezdev.util.gui.jpopupmenu.JPopUpMenuService;
import javax.swing.JTree;

public class Services {
    private static JPopUpMenuService jPopUpMenuService;
    private static TaskTreeService treeService;
    private static TaskSaveService taskSaveService;

    public Services(){
        throw new IllegalStateException("Utility class");
    }
    
    public static void initServices(JTree jTree){
        jPopUpMenuService = new JPopUpMenuService(jTree);
        treeService = new TaskTreeService(jTree);
        taskSaveService = new TaskSaveService(Config.SAVE_FILE);
    }

    public static TaskTreeService getTreeService() {
        return treeService;
    }

    public static JPopUpMenuService getJPopUpMenuService() {
        return jPopUpMenuService;
    }
    
    public static TaskSaveService getSaveService(){
        return taskSaveService;
    }
}
