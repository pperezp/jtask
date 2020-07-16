package cl.prezdev.jtask.jpopupmenu.listener;

import cl.prezdev.jtask.model.Task;
import cl.prezdev.jtask.service.Services;
import cl.prezdev.util.gui.jpopupmenu.Option;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class RenameTaskActionListener implements Option {

    @Override
    public void actionPerformed(ActionEvent ae) {
        Task task = Services.getJTreeService().getSelectedNode();
        String newTaskString = JOptionPane.showInputDialog("Rename task:", task.getText());
        
        if(newTaskString != null && !newTaskString.trim().isEmpty()){
            task.setText(newTaskString);
            Services.getJTreeService().updateUI();
        }
    }

    @Override
    public String getOptionText() {
        return "Rename task";
    }
    
}
