package cl.prezdev.jtask.service;

import cl.prezdev.jtask.jpopupmenu.listener.AddTaskActionListener;
import cl.prezdev.jtask.model.Task;
import cl.prezdev.jtask.model.TaskTreeModel;
import cl.prezdev.util.save.SaveOption;
import cl.prezdev.util.save.SaveService;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskSaveService extends SaveService {
    
    public TaskSaveService(File saveFile) {
        super(saveFile, SaveOption.COMPLETE_OBJECT);
    }
    
    public TaskTreeModel load() throws ClassNotFoundException {
        if (existSaveFile()) {
            try {
                return new TaskTreeModel(load(Task.class));
            } catch (IOException ex) {
                return null;
            }
        } else {
            return new TaskTreeModel(new Task("Tareas"));
        }
    }
    
    public void save() {
        TaskTreeModel taskTreeModel = (TaskTreeModel) Services.treeService.getTreeModel();
        Task taskRoot = (Task) taskTreeModel.getRoot();

        try {
            save(taskRoot);
        } catch (IOException ex) {
            Logger.getLogger(AddTaskActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
