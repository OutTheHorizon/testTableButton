import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class TableButton {
    private JFrame frame;
    private JTable table;
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TableButton window = new TableButton();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public TableButton() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 414, 242);
        frame.getContentPane().add(panel);

        panel.setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 394, 222);
        panel.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(
                new DefaultTableModel() {
                    private final Object[][] data = {
                            {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};
            @Override
            public Object getValueAt(int row, int column) {
                return data[row][column];
            }
            @Override
            public int getRowCount() {
                return 3;
            }
            @Override
            public int getColumnCount() {
                return 3;
            }
            @Override
            public void setValueAt(Object aValue, int row, int column){
                data[row][column] = aValue;
                fireTableCellUpdated(row, column);
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 2) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        table.getColumnModel().getColumn(2).setCellEditor(
                new MyButtonEditor());
        table.getColumnModel().getColumn(2).setCellRenderer(
                new MyButtonRender());
        table.setRowSelectionAllowed(false);
    }
}
