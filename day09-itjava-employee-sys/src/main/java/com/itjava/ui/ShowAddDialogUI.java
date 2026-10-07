package com.itjava.ui;

import com.itjava.bean.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

//继承JFrame 作为独立的窗口
public class ShowAddDialogUI extends JFrame {
    private EmployeeManagementUI employeeManagementUI;

    public ShowAddDialogUI(EmployeeManagementUI employeeManagementUI,DefaultTableModel tableModel){
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        JTextField idField = new JTextField("自动生成");
        idField.setEditable(false);
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField deptField = new JTextField();
        JTextField posField = new JTextField();
        JTextField salaryField = new JTextField();

        panel.add(new JLabel("工号:"));
        panel.add(idField);
        panel.add(new JLabel("姓名:"));
        panel.add(nameField);
        panel.add(new JLabel("年龄:"));
        panel.add(ageField);
        panel.add(new JLabel("入职日期:"));
        panel.add(dateField);
        panel.add(new JLabel("部门:"));
        panel.add(deptField);
        panel.add(new JLabel("职位:"));
        panel.add(posField);
        panel.add(new JLabel("薪资:"));
        panel.add(salaryField);



        int result = JOptionPane.showConfirmDialog(this, panel, "添加新员工", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            // 简单生成新工号（实际开发中应由数据库生成）
            String newId = String.valueOf(tableModel.getRowCount() + 1);
            String name = nameField.getText().trim();
            String age = ageField.getText().trim();
            String date = dateField.getText().trim();
            String dept = deptField.getText().trim();
            String pos = posField.getText().trim();
            String salary = salaryField.getText().trim();

            //将输入的数据封装成一个对象
            if (!name.isEmpty()) {
                Employee employee=new Employee(); //创建对象时要new 类名 不然不会有真正的对象能赋值
                employee.setId(Integer.parseInt(newId));
                employee.setName(name);
                employee.setAge(Integer.parseInt(age));
                employee.setEntryDate(date);
                employee.setDept(dept);
                employee.setPosition(pos);
                employee.setSalary(Double.parseDouble(salary));
                //再将这个对象传回给EmployeeManagementUI中的allEmployee集合中去
                //可以给EmployeeManagementUI创建一个接受这个对象数据的方法addEmployee
                employeeManagementUI.addEmployee(employee,tableModel);

                JOptionPane.showMessageDialog(this, "添加成功！");
                //添加完成后关闭这个窗口
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "姓名不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
