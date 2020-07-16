package cl.prezdev.jtask.service;

import cl.prezdev.jtask.model.Task;
import cl.prezdev.util.gui.jtree.JTreeService;
import javax.swing.JTree;

public class JTaskTreeService extends JTreeService<Task>{
    
    public JTaskTreeService(JTree jtree) {
        super(jtree);
    }
    
    public void switchDone(){
        Task selectedNode = super.getSelectedNode();
        selectedNode.switchDone();
    }
}
