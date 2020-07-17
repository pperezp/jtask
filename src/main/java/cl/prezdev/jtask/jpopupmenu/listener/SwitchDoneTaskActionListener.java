package cl.prezdev.jtask.jpopupmenu.listener;

import cl.prezdev.jtask.service.Services;
import cl.prezdev.util.gui.jpopupmenu.Option;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class SwitchDoneTaskActionListener implements Option {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JMenuItem jMenuItem = (JMenuItem) actionEvent.getSource();
        
        if(Services.treeService.getSelectedNode().isDone()){
            Services.treeService.undoneTask();
            jMenuItem.setText("Done");
        }else{
            Services.treeService.doneTask();
            jMenuItem.setText("Undone");
        }
        
        Services.taskSaveService.save();
    }

    @Override
    public String getOptionText() {
        return "Done";
    }
    
}
