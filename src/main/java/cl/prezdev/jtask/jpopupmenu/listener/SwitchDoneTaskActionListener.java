package cl.prezdev.jtask.jpopupmenu.listener;

import cl.prezdev.jtask.service.TaskTreeService;
import cl.prezdev.jtask.service.Services;
import cl.prezdev.util.gui.jpopupmenu.Option;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class SwitchDoneTaskActionListener implements Option {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        TaskTreeService jTreeService = Services.getTreeService();
        JMenuItem jMenuItem = (JMenuItem) actionEvent.getSource();
        
        if(Services.getTreeService().getSelectedNode().isDone()){
            jTreeService.undoneTask();
            jMenuItem.setText("Done");
        }else{
            jTreeService.doneTask();
            jMenuItem.setText("Undone");
        }
        
        Services.getSaveService().save();
    }

    @Override
    public String getOptionText() {
        return "Done";
    }
    
}
