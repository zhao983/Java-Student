package com.itjava.ui;

import com.itjava.bean.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

//自定义登录页面
public class LoginFrameUI extends JFrame implements ActionListener {


    private JTextField loginNameField;  //用户名输入框
    private JPasswordField passwordField;  //密码输入框
    private RoundedButton loginButton;  //登录按钮
    private JLabel registerLabel;  //注册按钮
    private JPanel registerPanel;  //注册面板

    /*系统中需要存在用户信息，大家可以先开发注册，注册一些用户信息（这个交给大家自己做）
    可以在系统直接准备一些用户对象，作为正确的用户信息。
    准备一个集合容器，存储系统中全部的用户信息。这个集合只需要一个*/
    //定义一个静态集合，存放全部的用户对象
    private static ArrayList<User> allUser = new ArrayList<>();
    //静态代码块
    static {
        //添加自己的实体类要用 new 实体类构造器
        allUser.add(new User("张三","123456","admin"));
        allUser.add(new User("李四","123456","admin2"));

    }
    public LoginFrameUI() {
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
        JPanel usernamePanel = new JPanel();
        usernamePanel.setOpaque(false);
        usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.Y_AXIS));

        usernamePanel.setMaximumSize(new Dimension(300, 75));
        usernamePanel.setPreferredSize(new Dimension(300, 75));
        usernamePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameLabel = createLabel("用户名");
        usernameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        loginNameField = new JTextField();
        styleTextField(loginNameField);
        loginNameField.setAlignmentX(Component.LEFT_ALIGNMENT);

        usernamePanel.add(usernameLabel);
        usernamePanel.add(Box.createVerticalStrut(8));
        usernamePanel.add(loginNameField);

        loginPanel.add(usernamePanel);
        loginPanel.add(Box.createVerticalStrut(20));

        // ------------------------------
        // 4. 密码
        // ------------------------------
        JPanel passwordPanel = new JPanel();
        passwordPanel.setOpaque(false);
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.Y_AXIS));

        passwordPanel.setMaximumSize(new Dimension(300, 75));
        passwordPanel.setPreferredSize(new Dimension(300, 75));
        passwordPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel passwordLabel = createLabel("密码");
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        passwordField = new JPasswordField();
        styleTextField(passwordField);
        passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);

        passwordPanel.add(passwordLabel);
        passwordPanel.add(Box.createVerticalStrut(8));
        passwordPanel.add(passwordField);

        loginPanel.add(passwordPanel);
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
        loginButton=new RoundedButton("登录");
        loginButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 48));
        loginButton.setPreferredSize(new Dimension(300, 48));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginPanel.add(loginButton);
        loginPanel.add(Box.createVerticalStrut(22));
        loginButton.addActionListener(this);

        // 注册
        registerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 0));
        registerPanel.setOpaque(false);

        JLabel noAccountLabel = new JLabel("还没有账号？");
        noAccountLabel.setForeground(new Color(130, 135, 145));

        registerLabel=new JLabel("立即注册");
        registerLabel.setForeground(new Color(90, 120, 230));
        registerLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
        registerLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        registerPanel.add(noAccountLabel);
        registerPanel.add(registerLabel);

        loginPanel.add(registerPanel);

        backgroundPanel.add(loginPanel);

        //注册点击事件
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("点击了注册事件");
            }
        });

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

        String loginName = loginNameField.getText();

        // 不推荐 getText() 获取密码
        String password = new String(passwordField.getPassword());

        if (loginName.isBlank()) {
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

        // 先判断有无用户名
        User user = getUserLoginName(loginName);
        if (user!=null) {
            //再判断密码是否相同
             if(user.getPassword().equals(password)){
                 JOptionPane.showMessageDialog(
                         this,
                         "登录成功！欢迎：" + user.getName(),
                         "登录成功",
                         JOptionPane.INFORMATION_MESSAGE
                 );

                 //登录成功后跳转到员工管理页面
                 //把登录成功的用户转过去
                 new EmployeeManagementUI(user);
                 //再关闭当前登录窗口
                 this.dispose();
             }


        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "用户名或密码错误！",
                    "登录失败",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    //加一个登录判断查询功能
    //需求：当判断登录名字又符合条件的时候就把那个User返回
    private User getUserLoginName(String loginName){
        for (int i = 0; i< allUser.size(); i++){
            User user = allUser.get(i);
            if(user.getLoginname().equals(loginName)){
                return user;
            }
        }
        return null;
    }

    /**
     * 创建标签
     */
    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);

        label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        label.setForeground(new Color(80, 85, 100));

        return label;
    }

    /**
     * 设置输入框样式
     */
    private void styleTextField(JTextField textField) {

        textField.setPreferredSize(new Dimension(300, 42));
        textField.setMaximumSize(new Dimension(300, 42));

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

    //重写按钮点击事件
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn =(JButton) e.getSource(); //getSource()取按钮
        if (btn == loginButton){
            System.out.println("点击了登录事件");
        }
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


}