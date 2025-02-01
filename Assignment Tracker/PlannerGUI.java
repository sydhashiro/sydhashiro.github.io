import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;

public class PlannerGUI extends JFrame {
    private DefaultListModel<Task> taskListModel;
    private JList<Task> taskList;
    private JTextField taskField;
    private JTextField dateField;
    private JButton addButton, completeButton, removeButton;

    private static final String FILE_PATH = "data/tasks.txt";

    public PlannerGUI() {
        setTitle("📅 Task Planner");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        loadTasksFromFile();

        JScrollPane scrollPane = new JScrollPane(taskList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 5, 5));

        taskField = new JTextField();
        dateField = new JTextField("YYYY-MM-DD");

        addButton = new JButton("Add Task");
        completeButton = new JButton("Mark Completed");
        removeButton = new JButton("Remove Task");

        inputPanel.add(new JLabel("Task:"));
        inputPanel.add(taskField);
        inputPanel.add(new JLabel("Due Date:"));
        inputPanel.add(dateField);
        inputPanel.add(addButton);
        inputPanel.add(completeButton);

        add(inputPanel, BorderLayout.NORTH);
        add(removeButton, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addTask());
        completeButton.addActionListener(e -> markTaskCompleted());
        removeButton.addActionListener(e -> removeTask());
    }

    private void addTask() {
        String desc = taskField.getText().trim();
        String dateStr = dateField.getText().trim();

        if (desc.isEmpty() || dateStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter task and due date.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            LocalDate dueDate = LocalDate.parse(dateStr);
            Task newTask = new Task(desc, dueDate);
            taskListModel.addElement(newTask);
            saveTasksToFile();
            taskField.setText("");
            dateField.setText("YYYY-MM-DD");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid date format! Use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void markTaskCompleted() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            Task selectedTask = taskListModel.get(selectedIndex);
            selectedTask.markCompleted();
            taskList.repaint();
            saveTasksToFile();
        } else {
            JOptionPane.showMessageDialog(this, "Select a task to mark as completed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskListModel.remove(selectedIndex);
            saveTasksToFile();
        } else {
            JOptionPane.showMessageDialog(this, "Select a task to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveTasksToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            ArrayList<Task> tasks = new ArrayList<>();
            for (int i = 0; i < taskListModel.size(); i++) {
                tasks.add(taskListModel.get(i));
            }
            out.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    private void loadTasksFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            ArrayList<Task> tasks = (ArrayList<Task>) in.readObject();
            for (Task task : tasks) {
                taskListModel.addElement(task);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading tasks.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PlannerGUI planner = new PlannerGUI();
            planner.setVisible(true);
        });
    }
}
