package com.puzzlegame;

import javax.swing.*;

public class LoginFrame extends JFrame {
    public LoginFrame(){
        //设置页面宽高
        this.setSize(500,500);
        //设置页面标题
        this.setTitle("拼图 登录");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //去除正中间的设置
        this.setLayout(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置页面显示与否
        this.setVisible(true);
        //设置用户名登录页面
        initUser();
    }
    private void initUser(){
        //设置用户名图片
        JLabel Username=new JLabel(new ImageIcon("D:\\codejavajava\\letusgo\\src\\com\\puzzlegame\\image\\login\\用户名.png"));
        //设置位置
        Username.setBounds(116, 135, 51, 19);
        //设置可见
        this.getContentPane().add(Username);
        //设置用户名文本框
        JTextField enterUsername=new JTextField();
        enterUsername.setBounds(195, 134, 200, 30);
        this.add(enterUsername);
        //添加密码图片
        JLabel password=new JLabel(new ImageIcon("D:\\codejavajava\\letusgo\\src\\com\\puzzlegame\\image\\login\\密码.png"));
        //设置图片位置宽高
        password.setBounds(130, 195, 32, 16);
        //添加图片
        this.getContentPane().add(password);
        //添加密码输入框
        JPasswordField enter=new JPasswordField();
        //设置位置
        enter.setBounds(195, 195, 200, 30);
        //添加可见
        this.getContentPane().add(enter);
    }
}
