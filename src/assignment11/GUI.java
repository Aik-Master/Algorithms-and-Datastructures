package assignment11;

import java.awt.FlowLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI{

    private JFrame                   frame;
    private JList<String>            jList;
    private JTextArea                jTextArea;
    private DefaultListModel<String> listModel;
    private JScrollPane              listScrollPane;

    public GUI(final HashTable table){

        jTextArea = new JTextArea();
        jTextArea.setColumns(40);
        jTextArea.setRows(9);

        listModel = new DefaultListModel<String>();
        jList = new JList<String>(listModel);

        for(int i = 0 ; i < table.nodes.length ; i++){
            if(table.nodes[i] != null) {
                listModel.addElement(table.nodes[i].ip);                
            }
        }

        jList.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if(e.getValueIsAdjusting() == false){
                    jTextArea.setText("");
                    HashTableNode node = table.get(jList.getSelectedValue());
                    do {
                        jTextArea.append(node.log+"\n");
                        node = node.next;
                    }while( node != null);
                }
            }
        });

        listScrollPane = new JScrollPane(jList);

        frame = new JFrame("Hashing... mit ner Bong!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.add(listScrollPane);
        frame.add(jTextArea);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
