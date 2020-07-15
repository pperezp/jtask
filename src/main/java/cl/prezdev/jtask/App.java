package cl.prezdev.jtask;

import cl.prezdev.jtask.model.Task;
import cl.prezdev.jtask.model.TaskTreeModel;
import cl.prezdev.util.gui.jpopupmenu.JPopUpMenuService;
import cl.prezdev.util.gui.jtree.JTreeService;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class App extends javax.swing.JFrame {
    
    private TaskTreeModel taskTreeModel;
    private JTreeService<Task> jTreeService;
    private JPopUpMenuService jPopUpMenuService;
    
    public App() {
        initComponents();
        taskTreeModel = new TaskTreeModel(new Task("Tareas"));
        
        tasksTree.setModel(taskTreeModel);
        tasksTree.setBackground(Color.black);
        
        jTreeService = new JTreeService<>(tasksTree);
        jPopUpMenuService = new JPopUpMenuService(tasksTree);
        
        jPopUpMenuService.addOption("option 1", (ActionEvent ae) -> {
            System.out.println("option 1");
        });
        
        jPopUpMenuService.addSeparator();
        
        jPopUpMenuService.addOption("option 2", (ActionEvent ae) -> {
            System.out.println("option 2");
        });
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
        tasksTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tasksTreeMouseReleased(evt);
            }
        });
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

    private void tasksTreeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tasksTreeMouseReleased
        if(evt.getButton() == 2){
            System.out.println("eliminar");
        }else if(evt.getClickCount() == 2){
            System.out.println("enable / disable");
        }else if(evt.isPopupTrigger()){
            System.out.println("pop up");
        }
    }//GEN-LAST:event_tasksTreeMouseReleased

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
}
