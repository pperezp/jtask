package cl.prezdev.jtask.jpopupmenu.listener;

import cl.prezdev.jtask.service.Services;
import cl.prezdev.util.gui.jpopupmenu.Option;
import java.awt.event.ActionEvent;

public class RemoveTaskActionListener implements Option {

    @Override
    public void actionPerformed(ActionEvent ae) {
        Services.getJTreeService().removeSelectedNode();
    }

    @Override
    public String getOptionText() {
        return "Remote task";
    }
    
}
