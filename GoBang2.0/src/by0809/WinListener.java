package by0809;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * WinListener 获胜监听器 负责实现获胜界面按键功能
 *
 * 属性
 * 1.goBangUi 棋盘界面对象 BiangGoBangUI goBangUi
 * 2.winJf 获胜界面对象 JFrame winJf
 * 3.mylis 棋盘监听器对象 BiangGoBangListener mylis
 * 4.pen 画笔对象
 *
 * 重写的方法
 * 1.void actionPerformed(ActionEvent e) 重写 actionPerformed 方法实现获胜界面的按键功能 (再战一局 回顾棋局 退出游戏)
 * 2.
 *
 * 方法：
 * 1.void setGoBangUi(BiangGoBangUI goBangUi) 设置棋盘界面 传参
 * 2.void setWinJf(JFrame winJf)  设置获胜界面 传参
 * 3.void setMylis(BiangGoBangListener mylis) 设置棋盘界面监听器 传参
 * 4.void setGraphics(Graphics pen) 设置画笔传参
 *
 *
 */

public class WinListener implements ActionListener {
    BiangGoBangUI goBangUi;
    JFrame winJf;
    BiangGoBangListener mylis;
    Graphics pen;

    public void setGoBangUi(BiangGoBangUI goBangUi){
        this.goBangUi = goBangUi;
    }

    public void setWinJf(JFrame winJf) {
        this.winJf = winJf;
    }

    public void setMylis(BiangGoBangListener mylis) {
        this.mylis = mylis;
    }

    public void setGraphics(Graphics pen) {
        this.pen = pen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnStr = e.getActionCommand();
        if(btnStr.equals("再战一局")){
            winJf.setVisible(false);
            mylis.countBlack=0;
            mylis.countWhite=0;
            mylis.countSum=0;
            mylis.controlColor=0;
            goBangUi.chessIndex.clear();
            goBangUi.initBiangGoBangUI();
        }
        else if(btnStr.equals("回顾棋局")){

        }
        else if(btnStr.equals("结束游戏")){

        }

    }
}
