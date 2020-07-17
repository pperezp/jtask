package cl.prezdev.jtask.service;

import cl.prezdev.jtask.model.Task;
import cl.prezdev.jtask.model.TaskStatus;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TaskService {
    private final Logger logger = Logger.getLogger("TaskService");
    
    public void addTask(){
        if(Services.treeService.isSomeNodeSelected()){
            String taskString = JOptionPane.showInputDialog("New task:");

            if (taskString != null && !taskString.trim().isEmpty()) {
                Services.treeService.addNodeToSelectedNode(new Task(taskString.trim()));
                logger.log(Level.INFO, "Add task [{0}]", taskString.trim());

                Services.saveService.save();
            }
        }
    }

    public void removeTask() {
        if(Services.treeService.isSomeNodeSelected()){
            Services.treeService.removeSelectedNode();
            Services.saveService.save();
        }
        
    }

    public void renameTask() {
        if(Services.treeService.isSomeNodeSelected()){
            Task task = Services.treeService.getSelectedNode();
            String newTaskString = JOptionPane.showInputDialog("Rename task:", task.getText());

            if (newTaskString != null && !newTaskString.trim().isEmpty()) {
                task.setText(newTaskString);
                Services.treeService.updateUI();
                Services.saveService.save();
            }
        }
    }

    public TaskStatus changeTaskStatus() {
        if (Services.treeService.isSomeNodeSelected()) {
            TaskStatus taskStatus;
            
            if (Services.treeService.getSelectedNode().isDone()) {
                Services.treeService.undoneTask();
                taskStatus = TaskStatus.DONE;
            } else {
                Services.treeService.doneTask();
                taskStatus = TaskStatus.UNDONE;
            }

            Services.saveService.save();
            
            return taskStatus;
        }
        
        return null;
    }
}
