package cl.prezdev.jtask.model;

import cl.prezdev.jtask.jpopupmenu.config.Config;
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
        setBackground(Config.BACKGROUND_COLOR);
        
        setForeground(getForegroundColor(task, selected));
        
        JLabelUtils.changeFontSize(this, Config.FONT_SIZE);
        
        if(task.isDone()){
            JLabelUtils.applyStrikeThrough(this);
            JLabelUtils.setItalic(this);
        }else{
            JLabelUtils.takeOutStrikeThrough(this);
            JLabelUtils.removeItalic(this);
        }
        
        return this;
    }

    private Color getForegroundColor(Task task, boolean selected) {
        if (task.isDone()) {
            if (selected) {
                return Config.SELECTED_DONE_TASK_COLOR;
            } else {
                return Config.DONE_TASK_COLOR;
            }
        } else if (selected) {
            return Config.TREE_SELECTED_COLOR;
        } else {
            return Config.FOREGROUND_COLOR;
        }
    }
}
