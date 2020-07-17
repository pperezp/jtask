package cl.prezdev.jtask;

import cl.prezdev.jtask.jpopupmenu.listener.AddTaskActionListener;
import cl.prezdev.jtask.jpopupmenu.listener.RemoveTaskActionListener;
import cl.prezdev.jtask.jpopupmenu.listener.RenameTaskActionListener;
import cl.prezdev.jtask.jpopupmenu.listener.SwitchDoneTaskActionListener;
import cl.prezdev.jtask.model.TaskTreeModel;
import cl.prezdev.jtask.model.TaskTreeRenderer;
import cl.prezdev.jtask.service.Services;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends javax.swing.JFrame {
    
    public App() {
        initComponents();
        
        initServices();
        initPopUpMenu();
        initWindow();
        initTreeModel();
        initTreeCellRenderer();
    }

    private void initTreeCellRenderer() {
        tasksTree.setCellRenderer(new TaskTreeRenderer());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        treeScrollPane = new javax.swing.JScrollPane();
        tasksTree = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Tareas");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Tarea 1");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("sub tarea1");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Tarea 2");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("sub tarea2");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("sub tarea 3");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        tasksTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeScrollPane.setViewportView(tasksTree);

        getContentPane().add(treeScrollPane);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new App().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree tasksTree;
    private javax.swing.JScrollPane treeScrollPane;
    // End of variables declaration//GEN-END:variables

    private void initServices() {
        Services.initServices(tasksTree);
    }

    private void initPopUpMenu() {
        Services.jPopUpMenuService.addOption(new AddTaskActionListener());
        Services.jPopUpMenuService.addOption(new SwitchDoneTaskActionListener());
        Services.jPopUpMenuService.addOption(new RenameTaskActionListener());
        Services.jPopUpMenuService.addSeparator();
        Services.jPopUpMenuService.addOption(new RemoveTaskActionListener());
    }

    private void initTreeModel() {
        try {
            TaskTreeModel taskTreeModel = Services.taskSaveService.load();
            tasksTree.setModel(taskTreeModel);
            tasksTree.setBackground(Color.black);
            Services.treeService.expandAllNodes();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initWindow() {
        this.setTitle("JTask");
        this.setBounds(new Rectangle(800, 600));
        this.setLocationRelativeTo(null);
    }
}
