import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WeaponComparisonTool extends JFrame {
    private JComboBox<String> weapon1Dropdown;
    private JComboBox<String> weapon2Dropdown;
    private JTextArea resultArea;

    public WeaponComparisonTool() {
        setTitle("Valorant Weapon Comparison Tool");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel selectionPanel = new JPanel();
        weapon1Dropdown = new JComboBox<>(WeaponDatabase.getWeaponNames());
        weapon2Dropdown = new JComboBox<>(WeaponDatabase.getWeaponNames());

        JButton compareButton = new JButton("Compare");
        compareButton.addActionListener(new CompareWeapons());

        selectionPanel.add(new JLabel("Weapon 1:"));
        selectionPanel.add(weapon1Dropdown);
        selectionPanel.add(new JLabel("Weapon 2:"));
        selectionPanel.add(weapon2Dropdown);
        selectionPanel.add(compareButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        add(selectionPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    private class CompareWeapons implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String weapon1Name = (String) weapon1Dropdown.getSelectedItem();
            String weapon2Name = (String) weapon2Dropdown.getSelectedItem();

            if (weapon1Name.equals(weapon2Name)) {
                resultArea.setText("Select two different weapons for comparison.");
                return;
            }

            Weapon weapon1 = WeaponDatabase.getWeapon(weapon1Name);
            Weapon weapon2 = WeaponDatabase.getWeapon(weapon2Name);

            StringBuilder result = new StringBuilder();
            result.append("Comparison Between ").append(weapon1.getName()).append(" and ").append(weapon2.getName()).append("\n\n");

            result.append(compareStat("Damage", weapon1.getDamage(), weapon2.getDamage()));
            result.append(compareStat("Fire Rate", weapon1.getFireRate(), weapon2.getFireRate()));
            result.append(compareStat("Magazine Size", weapon1.getMagazineSize(), weapon2.getMagazineSize()));
            result.append(compareStat("Cost", weapon1.getCost(), weapon2.getCost(), false));

            resultArea.setText(result.toString());
        }

        private String compareStat(String stat, double stat1, double stat2) {
            return compareStat(stat, stat1, stat2, true);
        }

        private String compareStat(String stat, double stat1, double stat2, boolean higherIsBetter) {
            String better = stat1 > stat2 ? "✅" : stat1 < stat2 ? "❌" : "=";
            if (!higherIsBetter) better = stat1 < stat2 ? "✅" : stat1 > stat2 ? "❌" : "=";

            return String.format("%s: %s %,.2f vs %s %,.2f %s\n", 
                stat, weapon1Dropdown.getSelectedItem(), stat1, 
                weapon2Dropdown.getSelectedItem(), stat2, better);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WeaponComparisonTool().setVisible(true));
    }
}
