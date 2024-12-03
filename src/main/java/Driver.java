import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Driver {
    private CardBinder binder;

    public static void main(String[] args) {
        CardBinder binder = new CardBinder();

        ImageIcon image = new ImageIcon("src/main/resources/images/pokedex.jpg");
        Border border = BorderFactory.createLineBorder(Color.green,10);
        /**
         * Labels
         *
         */

        JLabel add = new JLabel();
        add.setText("ADD");

        /**
         * Buttons
         */
        JButton submit = new JButton("ADD");
        submit.setPreferredSize(new Dimension(60, 60));
        submit.setBounds(40,420,50,50);
        submit.setFocusable(false);
        submit.setFont(new Font("comic sans",Font.BOLD,15));
        submit.setBorder(null);



        JButton remove = new JButton("REMOVE");
        remove.setBounds(100,420,70,50);
        remove.setText("Remove");
        remove.setFocusable(false);
        remove.setFont(new Font("comic sans",Font.BOLD,15));
        remove.setBorder(null);


        JButton view = new JButton("VIEW");
        view.setBounds(180,420,50,50);
        view.setText("View");
        view.setFocusable(false);
        view.setFont(new Font("comic sans",Font.BOLD,15));
        view.setBorder(null);


        JButton rarest = new JButton();
        rarest.setBounds(350,420,50,50);
        rarest.setText("Rarest");
        rarest.setFocusable(false);
        rarest.setFont(new Font("comic sans",Font.BOLD,15));
        rarest.setBorder(null);


        JButton alphabetical = new JButton();
        alphabetical.setBounds(410,420,90,50);
        alphabetical.setText("Alphabetical");
        alphabetical.setFocusable(false);
        alphabetical.setFont(new Font("comic sans",Font.BOLD,15));
        alphabetical.setBorder(null);

        JButton value = new JButton();
        value.setBounds(520,420,50,50);
        value.setText("Value");
        value.setFocusable(false);
        value.setFont(new Font("comic sans",Font.BOLD,15));
        value.setBorder(null);

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name: ");
        nameLabel.setFont(new Font("comic sans",Font.BOLD,30));
        nameLabel.setBounds(0,0,5,5);

        JLabel valueLabel = new JLabel();
        valueLabel.setText("Value: ");

        JTextField nameText = new JTextField();
        nameText.setBounds(0,0,50,50);
        nameText.setPreferredSize(new Dimension(250,40));
        nameText.setText("Card Name");

        JTextField valueText = new JTextField();
        valueText.setBounds(0,0,50,50);
        valueText.setPreferredSize(new Dimension(250,40));
        valueText.setText("Add card value. Do not add $");


        JRadioButton common = new JRadioButton("Common");
        JRadioButton uncommon = new JRadioButton("Uncommon");
        JRadioButton rare = new JRadioButton("Rare");
        JRadioButton ultraRare = new JRadioButton("Ultra Rare");

        ButtonGroup group = new ButtonGroup();
        group.add(common);
        group.add(uncommon);
        group.add(rare);
        group.add(ultraRare);


        JLabel label = new JLabel();
        label.setText("Collectible binder");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(255, 0, 0));
        label.setFont(new Font("MV Boili",Font.BOLD,30));
        label.setIconTextGap(0);
        label.setBackground(new Color(0, 0, 0));
        label.setOpaque(true);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        /**
         * Panel for user's input
         *
         */

        JPanel textPanel = new JPanel();
        textPanel.setBackground(new Color(255, 228, 48));
        textPanel.setBounds(30,165,250,250);
        textPanel.add(nameLabel,BorderLayout.NORTH);
        textPanel.add(nameText,BorderLayout.CENTER);
        textPanel.add(valueLabel,BorderLayout.SOUTH);
        textPanel.add(valueText,BorderLayout.CENTER);
        textPanel.add(common);
        textPanel.add(uncommon);
        textPanel.add(rare);
        textPanel.add(ultraRare);


        /**
         * Columns
         */
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NAME");
        model.addColumn("VALUE");
        model.addColumn("RARITY");
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        JScrollPane stuff = new JScrollPane(table);

        JPanel listPanel = new JPanel();
        listPanel.setBackground(new Color(16, 56, 103));
        listPanel.setBounds(350,160,240,250);
        listPanel.add(stuff, BorderLayout.CENTER);

        /**
         * ActionListeners
         */

        submit.addActionListener(new ActionListener() {
            final Driver driver = Driver.this; // Capture 'this' reference

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String rarity = getSelectedRarity(); // Implement method to get selected rarity
                int value;
                try {
                    value = Integer.parseInt(valueText.getText());
                } catch (NumberFormatException ex) {
                    // Handle invalid value input (e.g., show an error message)
                    value = 0; // Or set a default value if needed
                }
                driver.binder.add(name, rarity, value); // Call Driver's add method
            }
        });


        JFrame frame = new JFrame();
        frame.setTitle("Pokedex");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600,550);
        frame.setVisible(true);
        frame.add(textPanel);
        frame.add(rarest);
        frame.add(listPanel);
        frame.add(submit);
        frame.add(remove);
        frame.add(view);
        frame.add(alphabetical);
        frame.add(value);
        frame.add(label);

        frame.pack();


    }
}