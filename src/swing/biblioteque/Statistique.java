package swing.biblioteque;

public class Statistique extends javax.swing.JFrame{
    //a frame with multiple tabs
    public Statistique(){
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Statistique");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        javax.swing.JTabbedPane tabbedPane = new javax.swing.JTabbedPane();
//        tabbedPane.addTab("Nombre de livre par catégorie", new ());
    }
}
