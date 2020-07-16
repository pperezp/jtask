package cl.prezdev.jtask.model;

import cl.prezdev.util.gui.jlabel.JLabelUtils;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;

public class TaskTreeRenderer extends JLabel implements TreeCellRenderer{

    @Override
    public Component getTreeCellRendererComponent(
        JTree tree, Object value, boolean selected, boolean expanded,
        boolean leaf, int row, boolean hasFocus
    ) {
        Task task = (Task) value;
        
        setName(task.getText());
        setText(task.getText());
        
        if(task.isDone()){
            JLabelUtils.applyStrikeThrough(this);
        }else{
            JLabelUtils.takeOutStrikeThrough(this);
        }
        
        this.setBackground(Color.BLACK);
        
        if(selected){
            this.setForeground(Color.yellow);
        }else{
            this.setForeground(Color.white);
        }
        
        return this;
    }
    
}
