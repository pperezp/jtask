package cl.prezdev.jtask.model;

import cl.prezdev.util.gui.jtree.ITreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;
import javax.swing.tree.TreeNode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Task implements ITreeNode<Task>{
    private String id;
    private boolean done;
    private String text;
    private Task parent;
    private List<Task> childs;
    
    public Task(String text){
        this.id = UUID.randomUUID().toString();
        this.childs = new ArrayList<>();
        this.parent = null;
        this.done = false;
        this.text = text;
    }

    @Override
    public TreeNode getChildAt(int i) {
        return childs.get(i);
    }

    @Override
    public int getChildCount() {
        return childs.size();
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public int getIndex(TreeNode tn) {
        return childs.indexOf(tn);
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        return childs.isEmpty();
    }

    @Override
    public Enumeration children() {
        return Collections.enumeration(childs);
    }
    
    @Override
    public String toString(){
        return this.text;
    }

    @Override
    public Task addChild(Task task) {
        this.childs.add(task);
        task.setParent(this);

        return this;
    }
    
    @Override
    public Task removeChild(Task task) {
        this.childs.remove(task);
        
        return this;
    }

    @Override
    public Task removeMyself() {
        if(this.parent != null){
            this.parent.removeChild(this);
            this.parent = null;
        }
        
        return this;
    }
}