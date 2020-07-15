package cl.prezdev.jtask.service;

import cl.prezdev.jtask.model.Task;
import cl.prezdev.util.gui.jpopupmenu.JPopUpMenuService;
import cl.prezdev.util.gui.jtree.JTreeService;
import javax.swing.JTree;

public class Services {
    private static JPopUpMenuService jPopUpMenuService;
    private static JTreeService jTreeService;
    
    public static void initServices(JTree jTree){
        jPopUpMenuService = new JPopUpMenuService(jTree);
        jTreeService = new JTreeService(jTree);
    }

    public static JTreeService<Task> getJTreeService() {
        return jTreeService;
    }

    public static JPopUpMenuService getJPopUpMenuService() {
        return jPopUpMenuService;
    }
}
