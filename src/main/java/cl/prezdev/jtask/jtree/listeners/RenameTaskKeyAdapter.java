package cl.prezdev.jtask.jtree.listeners;

import cl.prezdev.jtask.service.Services;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RenameTaskKeyAdapter extends KeyAdapter{
    
    @Override
    public void keyReleased(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_F2){
            Services.taskService.renameTask();
        }
    }
}
