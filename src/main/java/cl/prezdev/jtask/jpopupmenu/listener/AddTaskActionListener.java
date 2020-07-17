package cl.prezdev.jtask.jpopupmenu.listener;

import cl.prezdev.jtask.model.Task;
import cl.prezdev.jtask.service.Services;
import cl.prezdev.util.gui.jpopupmenu.Option;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddTaskActionListener implements Option {
    
    private final static Logger LOGGER = Logger.getLogger("AddTaskActionListener");
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String taskString = JOptionPane.showInputDialog("New task:");
        
        if(taskString != null && !taskString.trim().isEmpty()){
            Services.getTreeService().addNodeToSelectedNode(new Task(taskString.trim()));
            LOGGER.info("Add task [" + taskString.trim() + "]");
            
            Services.getSaveService().save();
        }
    }

    @Override
    public String getOptionText() {
        return "Add task";
    }
    
}
