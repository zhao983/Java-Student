package com.itjava.ui;

import com.itjava.bean.Employee;
import com.itjava.bean.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EmployeeManagementUI extends JFrame {
    private User user;
    private JTextField searchField;  //搜索输入框
    private JTable employeeTable;
    private DefaultTableModel tableModel;  //封装数据表格
    private TableRowSorter<DefaultTableModel> rowSorter; // 用于实现搜索过滤
    private static ArrayList<Employee> allEmployee = new ArrayList<>();
    private static Employee[] employee = new Employee[2];  //数组的大小数字应该放在等号右边

    //测试数据
    static {
        employee[0]=new Employee(1,"张三",18,"23-9","开发部","员工",5000);
        employee[1]=new Employee(2,"李四",23,"23-8","维护部","经理",15000);
        allEmployee.add(employee[0]);
        allEmployee.add(employee[1]);

    }

    // 列名
    private final String[] COLUMN_NAMES = {"工号", "姓名", "年龄", "入职日期", "部门", "职位", "薪资"};

    public EmployeeManagementUI() {
    }

    public EmployeeManagementUI(User user) {
        // 1. 初始化窗口基本属性
        setTitle("员工信息管理系统" + "\t" + "登陆人:" + user.getName());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中显示
        setLayout(new BorderLayout());

        // 2. 初始化顶部面板 (输入框、搜索按钮、添加按钮)
        initTopPanel();

        // 3. 初始化中间表格
        initTable();

        // 4. 初始化右键菜单
        initPopupMenu();

        setVisible(true);
    }

    //这边是为了接受ShowAddDialogUI添加的员工数据创建的方法
    public static void addEmployee(Employee employee, DefaultTableModel tableModel) {
        allEmployee.add(employee);
        //添加一行数据到表格中
        tableModel.addRow(new Object[]{employee.getId(), employee.getName(), employee.getAge(), employee.getEntryDate(), employee.getDept(), employee.getPosition(), employee.getSalary()});
    }

    /**
     * 初始化顶部面板：包含输入框、搜索按钮、添加按钮，并居中
     */
    private void initTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel searchLabel = new JLabel("搜索员工:");
        searchField = new JTextField(15);
        JButton searchButton = new JButton("搜索");
        JButton addButton = new JButton("添加");

        topPanel.add(searchLabel);
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(addButton);

        // 搜索按钮事件
        searchButton.addActionListener(e -> {
            String text = searchField.getText().trim();
            if (text.isEmpty()) {
                rowSorter.setRowFilter(null);
            } else {
                // 模糊搜索(忽略大小写)
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
        });

        // 添加按钮事件
        addButton.addActionListener(e -> new ShowAddDialogUI(this, this.tableModel));

        // 将顶部面板添加到窗口上方
        add(topPanel, BorderLayout.NORTH);
    }

    /**
     * 初始化中间表格：展示2个员工信息
     */
    private void initTable() {
        // 创建初始数据（20个员工）
        Object[][] data = new Object[allEmployee.size()][COLUMN_NAMES.length];
        for (int i = 0; i < allEmployee.size(); i++) {
            Employee employee = allEmployee.get(i);
            data[i][0] = employee.getId();
            data[i][1] = employee.getName();
            data[i][2] = employee.getAge();
            data[i][3] = employee.getEntryDate();
            data[i][4] = employee.getDept();
            data[i][5] = employee.getPosition();
            data[i][6] = employee.getSalary();
        }

        // 创建表格模型
        tableModel = new DefaultTableModel(data, COLUMN_NAMES) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 表格内容不可直接编辑，必须通过菜单修改
            }
        };

        employeeTable = new JTable(tableModel);
        rowSorter = new TableRowSorter<>(tableModel);
        employeeTable.setRowSorter(rowSorter); // 将排序/过滤器绑定到表格

        // 设置表格的一些视觉属性
        employeeTable.setRowHeight(25);
        employeeTable.getTableHeader().setReorderingAllowed(false);

        // 将表格放入滚动面板，并添加到窗口中间
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * 初始化右键菜单：修改和删除
     */
    private void initPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem editItem = new JMenuItem("修改");
        JMenuItem deleteItem = new JMenuItem("删除");

        popupMenu.add(editItem);
        popupMenu.add(deleteItem);

        // 绑定表格鼠标事件
        employeeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) { // 右键按下
                    showPopup(e, popupMenu);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) { // 右键释放
                    showPopup(e, popupMenu);
                }
            }
        });

        // 修改菜单项事件
        editItem.addActionListener(e -> showEditDialog());

        // 删除菜单项事件
        deleteItem.addActionListener(e -> deleteSelectedRow());
    }

    /**
     * 辅助方法：显示右键菜单
     */
    private void showPopup(MouseEvent e, JPopupMenu popupMenu) {
        int row = employeeTable.rowAtPoint(e.getPoint());
        if (row >= 0) {
            employeeTable.setRowSelectionInterval(row, row); // 选中当前右键的行
            popupMenu.show(employeeTable, e.getX(), e.getY());
        }
    }

    /**
     * 弹出修改员工的对话框
     */
    private void showEditDialog() {
        System.out.println("未完善");
        JOptionPane.showMessageDialog(this, "未完善");  //this锁定这个页面
        /*int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow == -1) return;

        // 转换视图索引到模型索引 (因为可能有排序/过滤)
        int modelRow = employeeTable.convertRowIndexToModel(selectedRow);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        JTextField idField = new JTextField(tableModel.getValueAt(modelRow, 0).toString());
        idField.setEditable(false);
        JTextField nameField = new JTextField(tableModel.getValueAt(modelRow, 1).toString());
        JTextField deptField = new JTextField(tableModel.getValueAt(modelRow, 2).toString());
        JTextField posField = new JTextField(tableModel.getValueAt(modelRow, 3).toString());
        JTextField salaryField = new JTextField(tableModel.getValueAt(modelRow, 4).toString());

        panel.add(new JLabel("工号:"));
        panel.add(idField);
        panel.add(new JLabel("姓名:"));
        panel.add(nameField);
        panel.add(new JLabel("部门:"));
        panel.add(deptField);
        panel.add(new JLabel("职位:"));
        panel.add(posField);
        panel.add(new JLabel("薪资:"));
        panel.add(salaryField);

        int result = JOptionPane.showConfirmDialog(this, panel, "修改员工信息", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            tableModel.setValueAt(nameField.getText().trim(), modelRow, 1);
            tableModel.setValueAt(deptField.getText().trim(), modelRow, 2);
            tableModel.setValueAt(posField.getText().trim(), modelRow, 3);
            tableModel.setValueAt(salaryField.getText().trim(), modelRow, 4);
            JOptionPane.showMessageDialog(this, "修改成功！");
        }*/
    }

    /**
     * 删除选中行
     */
    private void deleteSelectedRow() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow == -1) return;

        int modelRow = employeeTable.convertRowIndexToModel(selectedRow);

        int confirm = JOptionPane.showConfirmDialog(this, "确定要删除该员工信息吗？", "删除确认", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            tableModel.removeRow(modelRow);
            allEmployee.remove(selectedRow);
            JOptionPane.showMessageDialog(this, "删除成功！");
        }
    }


}