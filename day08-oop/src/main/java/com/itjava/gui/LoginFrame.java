package com.itjava.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        // ------------------------------
        // 1. 设置窗口
        // ------------------------------
        setTitle("用户登录");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // 设置背景
        GradientPanel backgroundPanel = new GradientPanel();
        backgroundPanel.setLayout(new GridBagLayout());
        setContentPane(backgroundPanel);

        // ------------------------------
        // 2. 登录卡片
        // ------------------------------
        RoundedPanel loginPanel = new RoundedPanel(30);
        loginPanel.setPreferredSize(new Dimension(400, 470));
        loginPanel.setBackground(new Color(255, 255, 255, 235));

        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBorder(new EmptyBorder(35, 45, 35, 45));

        // 标题
        JLabel titleLabel = new JLabel("欢迎登录");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 30));
        titleLabel.setForeground(new Color(45, 55, 75));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitleLabel = new JLabel("Welcome Back");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(130, 140, 155));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginPanel.add(titleLabel);
        loginPanel.add(Box.createVerticalStrut(8));
        loginPanel.add(subtitleLabel);
        loginPanel.add(Box.createVerticalStrut(35));

        // ------------------------------
        // 3. 用户名
        // ------------------------------
        JLabel usernameLabel = createLabel("用户名");
        loginPanel.add(usernameLabel);
        loginPanel.add(Box.createVerticalStrut(8));

        usernameField = new JTextField();
        styleTextField(usernameField);

        loginPanel.add(usernameField);
        loginPanel.add(Box.createVerticalStrut(20));

        // ------------------------------
        // 4. 密码
        // ------------------------------
        JLabel passwordLabel = createLabel("密码");
        loginPanel.add(passwordLabel);
        loginPanel.add(Box.createVerticalStrut(8));

        passwordField = new JPasswordField();
        styleTextField(passwordField);

        loginPanel.add(passwordField);
        loginPanel.add(Box.createVerticalStrut(15));

        // ------------------------------
        // 5. 记住密码
        // ------------------------------
        JPanel optionPanel = new JPanel(new BorderLayout());
        optionPanel.setOpaque(false);
        optionPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        JCheckBox rememberBox = new JCheckBox("记住密码");
        rememberBox.setOpaque(false);
        rememberBox.setForeground(new Color(100, 105, 120));
        rememberBox.setFont(new Font("微软雅黑", Font.PLAIN, 13));

        JLabel forgetLabel = new JLabel("忘记密码？");
        forgetLabel.setForeground(new Color(90, 120, 230));
        forgetLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        forgetLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        optionPanel.add(rememberBox, BorderLayout.WEST);
        optionPanel.add(forgetLabel, BorderLayout.EAST);

        loginPanel.add(optionPanel);
        loginPanel.add(Box.createVerticalStrut(25));

        // ------------------------------
        // 6. 登录按钮
        // ------------------------------
        RoundedButton loginButton = new RoundedButton("登 录");
        loginButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 48));
        loginButton.setPreferredSize(new Dimension(300, 48));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginPanel.add(loginButton);
        loginPanel.add(Box.createVerticalStrut(22));

        // 注册
        JPanel registerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 0));
        registerPanel.setOpaque(false);

        JLabel noAccountLabel = new JLabel("还没有账号？");
        noAccountLabel.setForeground(new Color(130, 135, 145));

        JLabel registerLabel = new JLabel("立即注册");
        registerLabel.setForeground(new Color(90, 120, 230));
        registerLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
        registerLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        registerPanel.add(noAccountLabel);
        registerPanel.add(registerLabel);

        loginPanel.add(registerPanel);

        backgroundPanel.add(loginPanel);

        // ------------------------------
        // 7. 登录事件
        // ------------------------------
        loginButton.addActionListener(e -> login());

        passwordField.addActionListener(e -> login());

        setVisible(true);
    }

    /**
     * 登录逻辑
     */
    private void login() {

        String username = usernameField.getText();

        // 不推荐 getText() 获取密码
        String password = new String(passwordField.getPassword());

        if (username.isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "请输入用户名！",
                    "提示",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (password.isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "请输入密码！",
                    "提示",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // 演示账号
        if (username.equals("admin") && password.equals("123456")) {

            JOptionPane.showMessageDialog(
                    this,
                    "登录成功！欢迎：" + username,
                    "登录成功",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "用户名或密码错误！",
                    "登录失败",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    /**
     * 创建标签
     */
    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);

        label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        label.setForeground(new Color(80, 85, 100));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        return label;
    }

    /**
     * 设置输入框样式
     */
    private void styleTextField(JTextField textField) {

        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        textField.setPreferredSize(new Dimension(300, 42));

        textField.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        textField.setBackground(new Color(245, 247, 250));

        textField.setForeground(new Color(50, 55, 65));

        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        new Color(220, 225, 235),
                        1
                ),
                new EmptyBorder(5, 12, 5, 12)
        ));

        // 获得焦点时改变边框颜色
        textField.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {

                textField.setBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(
                                        new Color(95, 125, 235),
                                        2
                                ),
                                new EmptyBorder(4, 11, 4, 11)
                        )
                );
            }

            @Override
            public void focusLost(FocusEvent e) {

                textField.setBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(
                                        new Color(220, 225, 235),
                                        1
                                ),
                                new EmptyBorder(5, 12, 5, 12)
                        )
                );
            }
        });
    }

    /**
     * 渐变背景
     */
    static class GradientPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();

            GradientPaint gradient = new GradientPaint(
                    0,
                    0,
                    new Color(90, 120, 235),
                    getWidth(),
                    getHeight(),
                    new Color(135, 90, 200)
            );

            g2.setPaint(gradient);

            g2.fillRect(
                    0,
                    0,
                    getWidth(),
                    getHeight()
            );

            g2.dispose();
        }
    }

    /**
     * 圆角面板
     */
    static class RoundedPanel extends JPanel {

        private final int radius;

        public RoundedPanel(int radius) {

            this.radius = radius;

            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2.setColor(getBackground());

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    radius,
                    radius
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }

    /**
     * 圆角按钮
     */
    static class RoundedButton extends JButton {

        public RoundedButton(String text) {

            super(text);

            setFont(new Font("微软雅黑", Font.BOLD, 16));

            setForeground(Color.WHITE);

            setBackground(new Color(90, 120, 235));

            setFocusPainted(false);

            setBorderPainted(false);

            setContentAreaFilled(false);

            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        protected void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            // 鼠标按下时颜色稍微变深
            if (getModel().isPressed()) {

                g2.setColor(new Color(70, 100, 210));

            } else if (getModel().isRollover()) {

                // 鼠标经过
                g2.setColor(new Color(105, 135, 245));

            } else {

                g2.setColor(getBackground());
            }

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    20,
                    20
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(LoginFrame::new);
    }
}