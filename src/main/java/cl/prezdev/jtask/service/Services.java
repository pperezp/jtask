package cl.prezdev.jtask.service;

import cl.prezdev.util.gui.jpopupmenu.JPopUpMenuService;
import javax.swing.JTree;

public class Services {
    private static JPopUpMenuService jPopUpMenuService;
    private static JTaskTreeService jTreeService;
    
    public static void initServices(JTree jTree){
        jPopUpMenuService = new JPopUpMenuService(jTree);
        jTreeService = new JTaskTreeService(jTree);
    }

    public static JTaskTreeService getJTreeService() {
        return jTreeService;
    }

    public static JPopUpMenuService getJPopUpMenuService() {
        return jPopUpMenuService;
    }
}
