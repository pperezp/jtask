package cl.prezdev.jtask;

import cl.prezdev.jtask.jpopupmenu.listener.AddTaskActionListener;
import cl.prezdev.jtask.jpopupmenu.listener.RemoveTaskActionListener;
import cl.prezdev.jtask.jpopupmenu.listener.SwitchDoneTaskActionListener;
import cl.prezdev.jtask.model.Task;
import cl.prezdev.jtask.model.TaskTreeModel;
import cl.prezdev.jtask.service.Services;
import cl.prezdev.util.gui.jpopupmenu.JPopUpMenuService;
import cl.prezdev.util.gui.jtree.JTreeService;
import java.awt.Color;

public class App extends javax.swing.JFrame {
    private TaskTreeModel taskTreeModel;
    private JTreeService<Task> jTreeService;
    private JPopUpMenuService jPopUpMenuService;
    
    public App() {
        initComponents();
        
        initTreeModel();
        initServices();
        initPopUpMenu();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        treeScrollPane = new javax.swing.JScrollPane();
        tasksTree = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(treeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(treeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree tasksTree;
    private javax.swing.JScrollPane treeScrollPane;
    // End of variables declaration//GEN-END:variables

    private void initServices() {
        Services.initServices(tasksTree);

        jTreeService        = Services.getJTreeService();
        jPopUpMenuService   = Services.getJPopUpMenuService();
    }

    private void initPopUpMenu() {
        jPopUpMenuService.addOption(new AddTaskActionListener());
        jPopUpMenuService.addOption(new SwitchDoneTaskActionListener());
        jPopUpMenuService.addSeparator();
        jPopUpMenuService.addOption(new RemoveTaskActionListener());
    }

    private void initTreeModel() {
        taskTreeModel = new TaskTreeModel(new Task("Tareas"));

        tasksTree.setModel(taskTreeModel);
        tasksTree.setBackground(Color.black);
    }
}
