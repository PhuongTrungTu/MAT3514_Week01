package ex6;

import javax.swing.*;
import java.awt.*;

public class EcoSystemGUI {
    private JFrame frame;
    private JPanel canvas;
    private final Ecosystem ecosystem = Ecosystem.createEcosystem();
    private JLabel size;
    private JTextField sizeField;

    public EcoSystemGUI() {
        initializeFrame();
        initializeCanvas();
        initializeButtons();
        initializeSizeLabel();

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void initializeFrame() {
        frame = new JFrame("Simulation Ecosystem");
        frame.setLayout(new BorderLayout());
    }

    private void initializeCanvas() {
        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                final int TEMP = 20000;
                for (int i = 0; i < ecosystem.size(); i++) {
                    int x = (int) ecosystem.get(i).getX();
                    int y = (int) ecosystem.get(i).getY();
                    Image image = ecosystem.get(i).getImage();

                    Image scaledImage = image.getScaledInstance(TEMP / ecosystem.MAP_SIZE,
                            TEMP / ecosystem.MAP_SIZE,
                            Image.SCALE_SMOOTH);
                    ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                    g.drawImage(scaledImageIcon.getImage(), x, y, this);
                }
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(ecosystem.MAP_SIZE, ecosystem.MAP_SIZE);
            }
        };

        frame.add(canvas, BorderLayout.CENTER);
    }

    private void update() {
        canvas.repaint();
        updateSize();
    }

    private void initializeButtons() {
        JButton changeButton = new JButton("Step By Step");
        changeButton.addActionListener(e -> {
            ecosystem.action();
            update();
        });

        sizeField = new JTextField(5);
        sizeField.setText("200");
        JButton createEcosystem = new JButton("Create");
        createEcosystem.addActionListener(e -> {
            try {
                int SIZE = Integer.parseInt(sizeField.getText());
                if (ecosystem.size() != 0) {
                    ecosystem.clear();
                    ecosystem.randomEcosystem(SIZE);
                } else {
                    ecosystem.randomEcosystem(SIZE);
                }
                update();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Vui lòng nhập một số nguyên hợp lệ.");
            }
        });

        JButton run = new JButton("Run");
        run.addActionListener(e -> {
            while (ecosystem.alive()) {
                ecosystem.action();
                update();
//                try {
//                    Thread.sleep(1000);
//                    System.out.println("Running!");
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
//                }
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2));

        buttonPanel.add(run, BorderLayout.WEST);
        buttonPanel.add(changeButton, BorderLayout.EAST);
        buttonPanel.add(createEcosystem, BorderLayout.AFTER_LAST_LINE);
        buttonPanel.add(sizeField, BorderLayout.AFTER_LAST_LINE);

        frame.add(buttonPanel, BorderLayout.EAST);
    }

    private void initializeSizeLabel() {
        size = new JLabel();
        updateSize();
        frame.add(size, BorderLayout.NORTH);
    }

    private void updateSize() {
        size.setText("Size: " + ecosystem.size());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EcoSystemGUI::new);
    }
}