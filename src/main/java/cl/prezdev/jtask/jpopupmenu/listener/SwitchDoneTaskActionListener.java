package cl.prezdev.jtask.jpopupmenu.listener;

import cl.prezdev.jtask.service.JTaskTreeService;
import cl.prezdev.jtask.service.Services;
import cl.prezdev.util.gui.jpopupmenu.Option;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class SwitchDoneTaskActionListener implements Option {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JTaskTreeService jTreeService = Services.getJTreeService();
        JMenuItem jMenuItem = (JMenuItem) actionEvent.getSource();
        
        if(Services.getJTreeService().getSelectedNode().isDone()){
            jTreeService.undoneTask();
            jMenuItem.setText("Done");
        }else{
            jTreeService.doneTask();
            jMenuItem.setText("Undone");
        }
    }

    @Override
    public String getOptionText() {
        return "Done";
    }
    
}
