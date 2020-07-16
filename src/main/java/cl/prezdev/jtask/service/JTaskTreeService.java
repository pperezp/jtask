package cl.prezdev.jtask.service;

import cl.prezdev.jtask.model.Task;
import cl.prezdev.util.gui.jtree.JTreeService;
import javax.swing.JTree;

public class JTaskTreeService extends JTreeService<Task>{
    
    public JTaskTreeService(JTree jtree) {
        super(jtree);
    }
    
    @Deprecated
    public void switchDone(){
        Task selectedNode = super.getSelectedNode();
        selectedNode.switchDone();
        super.updateUI();
    }
    
    public void doneTask(){
        Task selectedNode = super.getSelectedNode();
        selectedNode.setDone(true);
        super.updateUI();
    }
    
    public void undoneTask(){
        Task selectedNode = super.getSelectedNode();
        selectedNode.setDone(false);
        super.updateUI();
    }
}
