package cl.prezdev.jtask.jpopupmenu.listener;

import cl.prezdev.jtask.model.TaskStatus;
import cl.prezdev.jtask.service.Services;
import cl.prezdev.util.gui.jpopupmenu.Option;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class ChangeTaskStatusActionListener implements Option {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        TaskStatus taskStatus = Services.taskService.changeTaskStatus();
        
        if(taskStatus != null){
            JMenuItem jMenuItem = (JMenuItem) actionEvent.getSource();
            jMenuItem.setText(taskStatus.getDescription());
        }
    }

    @Override
    public String getOptionText() {
        return "Done";
    }
    
}
