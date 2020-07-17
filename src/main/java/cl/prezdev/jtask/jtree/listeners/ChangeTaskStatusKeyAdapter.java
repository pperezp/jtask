package cl.prezdev.jtask.jtree.listeners;

import cl.prezdev.jtask.service.Services;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChangeTaskStatusKeyAdapter extends KeyAdapter{
    
    @Override
    public void keyReleased(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_F4){
            Services.taskService.changeTaskStatus();
        }
    }
}
