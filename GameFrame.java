package com.puzzlegame;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GameFrame extends JFrame implements ActionListener,KeyListener
{   int count=0;
    int[][] abab = new int[4][4];
    int a=0;
    int b=0;
    int [][] win=new int [][]
            {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
    //随机图片组中的图片序号
    Random picturenum=new Random();
    //引入变量记录路径，方便之后更换图片
    String  path="D:\\codejavajava\\letusgo\\src\\com\\puzzlegame\\image\\animal\\animal1\\";;

    //    JButton jtb3=new JButton("xixi");
    //创建选项下面的条目对象
    JMenuItem replayItem = new JMenuItem("重新开始游戏");
    JMenuItem reloginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem helloItem = new JMenuItem("我的历程");
    JMenuItem beauty=new JMenuItem("美女");
    JMenuItem animal=new JMenuItem("动物");
    JMenuItem sport=new JMenuItem("运动");
    public GameFrame() {
        //初始化页面
        initGameFrame();
        //初始化菜单
        initjmenubar();
        //初始化数据
        initDate();
        //初始化图片
        initIamge();
        this.setVisible(true);
    }
    private void initDate(){
        //初始化数据
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();

        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            int m = r.nextInt(arr.length);
            x = arr[i];
            arr[i] = arr[m];
            arr[m] = x;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                abab[i][j] = arr[i * 4 + j];
                if(abab[i][j]==0)
                {
                    a=i;
                    b=j;
                }
            }
        }
    }

    private void initIamge()  {
        //清空原来的东西
        this.getContentPane().removeAll();
        //记录0的位置
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建一个imageIcon的对象
                //创建一个JLable的对象（管理容器）
                //合并写法
                JLabel jLabel = new JLabel(new ImageIcon(path+ + abab[i][j] + ".jpg"));
                //制定图片位置
                //传递的是0的话，图片会凸起，1则相反
                jLabel.setBounds(105 * j+83, 105 * i+134, 105, 105);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(1));
                //将管理容器添加到界面
                this.getContentPane().add(jLabel);
                if (gameover()){
                    JLabel wimage=new JLabel(new ImageIcon("D:\\codejavajava\\letusgo\\src\\com\\puzzlegame\\image\\win.png"));
                    wimage.setBounds(203,283,197,73);
                    this.getContentPane().add(wimage);
                }
                JLabel stepcount=new JLabel("步数:"+count);
                stepcount.setBounds(50,30,100,20);
                this.getContentPane().add(stepcount);
            }
        }
        //添加背景
        //创建一个imageIcon的对象
        ImageIcon bg=new ImageIcon("D:\\codejavajava\\letusgo\\src\\com\\puzzlegame\\image\\background.png");
        //创建一个JLable的对象（管理容器）
        JLabel background=new JLabel(bg);
        //设置位置
        background.setBounds(40,40,508,560);
        //添加至界面中
        this.getContentPane().add(background);
        //先加载的图片在上方，后加载的图片在下方
        //刷新界面
        this.getContentPane().repaint();

    }

    private void initjmenubar() {
        //初始化菜单
        //创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单上面的两个选项的对象（功能 关于我们）
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenu changepicture=new JMenu("更换图片");
        //将每一个选项对应的条目添加到对应的选项中
        functionJMenu.add(replayItem);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);
        aboutJMenu.add(helloItem);
        functionJMenu.add(changepicture);
        //创建更换图片对应的条目对象
        //添加至上方
        //加入对应的更换图片选项总
        changepicture.add(beauty);
        changepicture.add(animal);
        changepicture.add(sport);
        //给对应的条目对象添加对应的功能
        //将菜单中的两个选项添加到菜单中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
        //给条目绑定事件
        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        helloItem.addActionListener(this);
        //给更换图片对应的条目绑定事件
        beauty.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);
    }

    private void initGameFrame() {
        //设置界面的宽高
        this.setSize(600, 680);
        //设置界面的标题
        this.setTitle("静心拼图1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中布局，只有取消了才能按照x与y的位置来布局
        this.setLayout(null);
        //之后被removeall弄走了
        //创建一个按钮对象
        JButton jtb1 = new JButton("点我啊");
        //设置位置和宽高
        jtb1.setBounds(0, 0, 100, 50);
        //给按钮设置 动作监听
        //addActionListener:表示我要给组件添加哪个事件监听（动作监听，鼠标左键点击，空格）
        jtb1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hwb");
            }
        });
        this.getContentPane().add(jtb1);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();
//        JButton jtb4=new JButton("exampleformouseclick");
//        jtb4.setBounds(100,100,200,200);
//        jtb4.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("单击");
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                System.out.println("按下不松");
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                System.out.println("松开");
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                System.out.println("划入");
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                System.out.println("划出");
//            }
//        });
//        this.getContentPane().add(jtb4);
//        JButton jtb2=new JButton("abab");
//        jtb2.setBounds(0,0,200,100);
//        jtb2.addActionListener(this);
//        this.getContentPane().add(jtb2);
//        jtb3.setBounds(200,200,100,100);
//        jtb3.addActionListener(this);
//        this.getContentPane().add(jtb3);

    }
    private boolean gameover(){
        for (int j=0;j<4;j++) {
            for (int i = 0; i < 4; i++) {
                if(win[j][i]!=abab[j][i])
                {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //多对象时使用
//        Object source=e.getSource();
//        if(source==jtb3)
//        {
//            Random r=new Random();
//            jtb3.setLocation(r.nextInt(500),r.nextInt(500));
//        }
        Object source=e.getSource();
        if(source==replayItem)
        {   //先步数清零
            count=0;
            //初始化数据
            initDate();
            //初始化页面
            initIamge();
        }
        else if (source==reloginItem)
        {
            this.setVisible(false);
            new LoginFrame();

        }
        else if (source==closeItem) {
            System.exit(0);
        }
        else if (source==helloItem) {
            //设置弹窗
            JDialog jDialog=new JDialog();
            //创建一个管理图片的容器对象
            JLabel jLabel=new JLabel(new ImageIcon("D:\\codejavajava\\letusgo\\src\\com\\puzzlegame\\image\\animal\\animal8\\all.jpg"));
            //设置位置和宽高
            jLabel.setBounds(0,0,258,258);
            //添加图片
            jDialog.getContentPane().add(jLabel);
            //给弹框设置大小
            jDialog.setSize(344,344);
            //让弹框置顶
            jDialog.setAlwaysOnTop(true);
            //让弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭无法操作下面的界面
            jDialog.setModal(true);
            //显示弹框
            jDialog.setVisible(true);
        }
        else if (source==beauty) {
            //更换图片
            path="D:\\codejavajava\\letusgo\\src\\com\\puzzlegame\\image\\girl\\girl"+(1+picturenum.nextInt(13))+"\\";
            //初始化
            initIamge();
        }
        else if(source==animal){
            //更换图片
            path="D:\\codejavajava\\letusgo\\src\\com\\puzzlegame\\image\\animal\\animal"+(1+picturenum.nextInt(8))+"\\";
            //初始化
            initIamge();
        }
        else if(source==sport)
        {
            //更换图片
            path="D:\\codejavajava\\letusgo\\src\\com\\puzzlegame\\image\\sport\\sport"+(1+picturenum.nextInt(10))+"\\";
            //初始化
            initIamge();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameover()){
            return;
        }
        int code=e.getKeyCode();
        if (code==65){
            //删除图片
            this.getContentPane().removeAll();
            //添加一张完整的图片
            JLabel all=new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            //添加背景
            //创建一个imageIcon的对象
            ImageIcon bg=new ImageIcon("D:\\codejavajava\\letusgo\\src\\com\\puzzlegame\\image\\background.png");
            //创建一个JLable的对象（管理容器）
            JLabel background=new JLabel(bg);
            //设置位置
            background.setBounds(40,40,508,560);
            //添加至界面中
            this.getContentPane().add(background);
            //先加载的图片在上方，后加载的图片在下方
            //刷新界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (gameover()){
            return;
        }
        int i=e.getKeyCode();
        count++;
        if(i==37){
            abab[a][b]=abab[a][b+1];
            abab[a][b+1]=0;
            b++;
            initIamge();
        }
        if(i==38){
            abab[a][b]=abab[a+1][b];
            abab[a+1][b]=0;
            a++;
            initIamge();
        }
        if(i==39){
            abab[a][b]=abab[a][b-1];
            abab[a][b-1]=0;
            b--;
            initIamge();
        }
        if(i==40){
            abab[a][b]=abab[a-1][b];
            abab[a-1][b]=0;
            a--;
            initIamge();
        }
        else if(i==65){
            initIamge();
        }
        else if(i==87){

            abab=new int [][]
                    {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
        }
        initIamge();
    }
}
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        System.out.println("fuck");
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
//}