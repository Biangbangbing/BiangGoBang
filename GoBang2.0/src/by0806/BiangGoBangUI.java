package by0806;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * GoBang界面
 * 继承JFRame ，重写paint方法
 *
 * 属性：
 * 1.bgimg 背景图
 * 2.mylis GoBang棋盘操作监听器 ———— BiangGoBangListener mylis
 * 3.loginListener GOBang 登录页面监听器  ————— LoginListener loginListener
 * 4.二维int 数组 chessIf 存放棋盘放棋子 黑 白 空 棋情况  2 1 0    0-16 共 17*17个点
 * 5.一维int 数组 chessIndexX 按顺序存放棋子横坐标
 * 6.一维int 数组 chessIndexY 按顺序存放棋子纵坐标
 *
 *
 * 方法：
 * 1.initBiangGoBangUI() 初始化界面方法
 * 2.startGame()  开始游戏方法  点击开始游戏跳转棋盘界面
 * 3.loginGame()  登录游戏方法  开始实现用户名登录 跳转开始游戏界面
 *
 * 重写方法：
 * 1.paint() 实现窗体刷新之后重画 背景图 棋盘
 */
public class BiangGoBangUI extends JFrame implements BiangGoBangInterface {
    public static final Image bgimg = new ImageIcon("img/bg50.jpg").getImage();
    public static final Image winImg = new ImageIcon("img/winne2.jpg").getImage();
    public BiangGoBangListener mylis = new BiangGoBangListener();
    public LoginListener loginListener = new LoginListener();
    public int[][] chesses = new int[ROW+1][LINE+1];
    public ArrayList<chessShape> chessIndex = new ArrayList<chessShape>(300);
//    public int[] chessIndexX = new int [];
//    public int[] ChessIndexY = new int [];

    public void initBiangGoBangUI() {
        for(int i=0;i<17;i++){
            for(int j=0;j<17;j++){
                chesses[i][j]=0;
                System.out.print("i"+i+"j"+j+"   "+chesses[i][j]);
            }
            System.out.println();
        }

        //JFrame bgb = new JFrame("Biang's五子棋v 1.0");
        this.setTitle("Biang's 五子棋 v1.0");
        this.setSize(SIZE * LINE+X*2, SIZE * ROW+Y*3);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mylis.setGoBangUi(this);

        JPanel downBar = new JPanel();
        downBar.setBackground(Color.GRAY);
        Dimension dim = new Dimension(downWidth,downWidth);
        downBar.setPreferredSize(dim);

        JButton BeginBtn = new JButton("开始");
        BeginBtn.setBackground(Color.WHITE);
        BeginBtn.setSize(btnWidth,btnHeight);
        downBar.add(BeginBtn);

        JButton ClearBtn = new JButton("清空");
        ClearBtn.setBackground(Color.WHITE);
        ClearBtn.setSize(btnWidth,btnHeight);
        downBar.add(ClearBtn);

        JButton backBtn = new JButton("撤回");
        backBtn.setBackground(Color.WHITE);
        backBtn.setSize(btnWidth,btnHeight);
        downBar.add(backBtn);

        ClearBtn.addActionListener(mylis);
        backBtn.addActionListener(mylis);
        this.add(downBar,BorderLayout.SOUTH);
        //BeginBtn.addActionListener(mylis);

//  实现下棋子下在面板之内：特别为棋盘设置面板画笔不一致，需要重新写继承JPanel的paint方法，所以换在监听器里实现
//        this.setLayout(null);
//        JPanel chessBoard = new JPanel();
//        chessBoard.setLocation(X,Y);
//        Dimension dim = new Dimension(SIZE*ROW,SIZE*LINE);
//        //chessBoard.setPreferredSize(dim);
//        chessBoard.setSize(SIZE*ROW,SIZE*LINE);
//        chessBoard.setBackground(Color.BLUE);
//        this.add(chessBoard);

        this.setVisible(true);
        this.addMouseListener(mylis);
        Graphics pen = this.getGraphics();
        mylis.setGraphics(pen);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        System.out.println("调用了paint函数！" );
        g.drawImage(bgimg,X-SIZE,Y-SIZE,(ROW+2)*SIZE,(LINE+2)*SIZE,null);
        g.setColor(Color.BLACK);
        for(int i=0;i<=ROW;i++){
            g.drawLine(X,Y+i*SIZE,X+SIZE*LINE,Y+i*SIZE);  //y不变，画横线
            g.drawLine(X+i*SIZE,Y,X+i*SIZE,Y+SIZE*ROW);   //x不变，画竖线
        }
        for(int i=0;i<ROW+1;i++){
            for(int j=0;j<LINE+1;j++){
                if(chesses[i][j]==2){
                    g.setColor(Color.BLACK);
                    g.fillOval(X+j * SIZE-SIZE/2,Y+i*SIZE-SIZE/2,SIZE,SIZE);
                }
                else if(chesses[i][j]==1) {
                    g.setColor(Color.WHITE);
                    g.fillOval(X + j * SIZE - SIZE / 2, Y + i * SIZE - SIZE / 2, SIZE, SIZE);
                }
            }
        }
    }

    public void startGame(){
        JFrame startjf = new JFrame("Biang 's 五子棋v2.0");
        startjf.setSize(500,500);
        startjf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton btn1 = new JButton("开始游戏");
        btn1.addActionListener(mylis);
        startjf.add(btn1,BorderLayout.NORTH);

        startjf.setVisible(true);
        mylis.setGoBangUi(this);   //全局？？
        mylis.setStartJf(startjf);
    }

    public void loginGame(){
        JFrame loginJf = new JFrame("欢迎登录 Biang 's 五子棋v2.0");
        loginJf.setSize(500,500);
        loginJf.setLayout(null);
        loginJf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //FlowLayout fl = new FlowLayout();
        //loginJf.setLayout(fl);

        JTextField jTFLoginUser = new JTextField(12);
        JTextField jTFLoginPassword = new JTextField(12);
        jTFLoginUser.setSize(200,40);
        jTFLoginPassword.setSize(200,40);
        jTFLoginUser.setLocation(150,250);
        jTFLoginPassword.setLocation(150,300);

        JButton btn0 = new JButton("登录");
        btn0.setSize(200,30);
        btn0.setLocation(150,400);
        btn0.addActionListener(loginListener);

        JLabel loginLabel = new JLabel("用户名：");
        loginLabel.setSize(100,100);
        loginLabel.setLocation(200,200);

        loginJf.add(jTFLoginUser);
        loginJf.add(jTFLoginPassword);
        loginJf.add(btn0);
        loginJf.add(loginLabel);

//        btn0.setLocation(100,200);
//        jTFLoginUser.setLocation(100,100);
//        jTFLoginPassword.setLocation(100,150);
//        btn0.setSize();

//        loginJf.add(jTFLoginUser,BorderLayout.SOUTH);
//        loginJf.add(jTFLoginPassword,BorderLayout.SOUTH);
//        loginJf.add(btn0,BorderLayout.SOUTH);

        loginJf.setVisible(true);
        loginListener.setGoBangUi(this);
        loginListener.setLoginJf(loginJf);
        loginListener.setjTFUser(jTFLoginUser);
        loginListener.setjTFPassword(jTFLoginPassword);

    }

    public void WinGameUI(){

        JFrame winJf = new JFrame("兄弟！太厉害了");
        winJf.setSize(400,500);
        winJf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton btn1 = new JButton("再战一局");
        btn1.addActionListener(mylis);
        winJf.add(btn1,BorderLayout.SOUTH);

        winJf.setVisible(true);

//        JButton btn2 = new JButton("结束游戏");
//        btn2.addActionListener(mylis);
//        WinJf.add(btn2,BorderLayout.NORTH);
//
//        JButton btn3 = new JButton("回顾棋局");
//        btn3.addActionListener(mylis);
//        WinJf.add(btn3,BorderLayout.NORTH);
        mylis.setGoBangUi(this);   //全局？？
        mylis.setWinJf(winJf);

        Graphics wpen = winJf.getGraphics();
        mylis.setGraphics(wpen);

    }

}
