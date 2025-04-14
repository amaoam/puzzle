package com.puzzlegame;

import javax.swing.*;

public class Registergame extends JFrame {
    public Registergame(){
        //设置页面宽高
        this.setSize(400,500);
        //设置页面标题
        this.setTitle("拼图 注册");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置页面显示与否
        this.setVisible(true);
    }
}
