package ChatApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatClientGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private JPanel emojiPanel;
    private JButton themeToggleButton;

    private String username;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    private boolean darkMode = true;

    public ChatClientGUI(String username) {
        this.username = username;
        setTitle("Chat Client - " + username);
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Emoji + Theme Toggle Panel (Top)
        emojiPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(emojiPanel, BorderLayout.NORTH);

        // Add emojis
        addEmojis();

        // Add theme toggle
        themeToggleButton = new JButton("Switch to Light ☀️");
        themeToggleButton.setFont(new Font("Arial", Font.PLAIN, 12));
        themeToggleButton.addActionListener(e -> toggleTheme());
        emojiPanel.add(Box.createHorizontalStrut(10)); // spacing
        emojiPanel.add(themeToggleButton);

        // Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        // Input panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        sendButton = new JButton("Send");

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        // Send button action
        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());

        applyTheme(); // Apply dark mode by default
        connectToServer();
        setVisible(true);
    }

    private void applyTheme() {
        Color bgColor = darkMode ? new Color(30, 30, 30) : Color.WHITE;
        Color fgColor = darkMode ? new Color(230, 230, 230) : Color.BLACK;

        Font font = new Font("Monospaced", Font.PLAIN, 14);

        // Chat area
        chatArea.setBackground(bgColor);
        chatArea.setForeground(fgColor);
        chatArea.setFont(font);

        // Input field
        inputField.setBackground(darkMode ? Color.DARK_GRAY : Color.WHITE);
        inputField.setForeground(fgColor);
        inputField.setCaretColor(fgColor);
        inputField.setFont(font);

        // Send button
        sendButton.setBackground(null);
        sendButton.setForeground(fgColor);
        sendButton.setFont(font);

        // Emoji panel
        emojiPanel.setBackground(bgColor);

        // Theme toggle text
        themeToggleButton.setText(darkMode ? "Switch to Light ☀️" : "Switch to Dark 🌙");

        getContentPane().setBackground(bgColor);
    }

    private void toggleTheme() {
        darkMode = !darkMode;
        applyTheme();
    }

    private void addEmojis() {
        String[] emojis = { "😀", "😂", "❤️", "👍", "🔥", "😭", "😎", "🤯", "😡", "🎉" };
        for (String emoji : emojis) {
            JButton emojiBtn = new JButton(emoji);
            emojiBtn.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
            emojiBtn.setMargin(new Insets(2, 4, 2, 4));
            emojiBtn.setFocusPainted(false);
            emojiBtn.addActionListener(e -> inputField.setText(inputField.getText() + " " + emoji));
            emojiPanel.add(emojiBtn);
        }
    }

    private void connectToServer() {
        try {
            socket = new Socket("localhost", 12345);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("📥 " + username + " has joined the chat! 🚀");

            new Thread(() -> {
                String msg;
                try {
                    while ((msg = in.readLine()) != null) {
                        chatArea.append(msg + "\n");
                    }
                } catch (IOException e) {
                    chatArea.append("❌ Disconnected from server.\n");
                }
            }).start();

        } catch (IOException e) {
            showError("Could not connect to server: " + e.getMessage());
        }
    }

    private void sendMessage() {
        String text = inputField.getText().trim();
        if (!text.isEmpty()) {
            out.println("👤 " + username + ": " + text);
            inputField.setText("");
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Enter your name:");
        if (name != null && !name.trim().isEmpty()) {
            SwingUtilities.invokeLater(() -> new ChatClientGUI(name.trim()));
        } else {
            System.out.println("No name entered. Exiting.");
        }
    }
}
