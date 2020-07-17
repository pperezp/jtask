package cl.prezdev.jtask.model;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class TaskTreeModel implements TreeModel{
    private Task root;

    public TaskTreeModel(Task root) {
        this.root = root;
    }
    
    @Override
    public Object getRoot() {
        return this.root;
    }

    @Override
    public Object getChild(Object o, int i) {
        Task task = (Task) o;
        return task.getChildAt(i);
    }

    @Override
    public int getChildCount(Object o) {
        Task task = (Task) o;
        return task.getChildCount();
    }

    @Override
    public boolean isLeaf(Object o) {
        Task task = (Task) o;
        return task.isLeaf();
    }

    @Override
    public void valueForPathChanged(TreePath tp, Object o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        Task task = (Task) parent;
        return task.getIndex((Task)child);
    }

    @Override
    public void addTreeModelListener(TreeModelListener tl) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTreeModelListener(TreeModelListener tl) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
