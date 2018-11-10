import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
class Gui extends JFrame{                                             //主界面类
    DrawListener draw=new DrawListener();                             //创建事件监听类对象
    private Graphics g;                                               //画笔是一个组件
    private List<NetJavaShape> shapeArray=new ArrayList<NetJavaShape>();

    JPanel panel;
    JPanel panel2;
    JButton button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,clear,nowcolor,brush,eraser;
    JButton red,green,yellow,blue,purple,pink;
    public Gui(){                                                          //构造方法初始化对象
        panel=new JPanel();
        panel2=new JPanel(new GridLayout(15,6,10,10));         //网格布局
        button1=new JButton("矩形");
        button2=new JButton("椭圆");
        button3=new JButton("实椭圆");
        button4=new JButton("直线");
        button5=new JButton("射线");
        button6=new JButton("曲线");
        button7=new JButton("实矩形");
        button8=new JButton("折线");
        button9=new JButton("多边形");
        button10=new JButton("喷桶");
        brush=new JButton("笔刷");
        eraser=new JButton("橡皮擦");
        clear=new JButton("擦除面板");
        nowcolor=new JButton();
        nowcolor.setBackground(Color.black);
        red=new JButton();
        red.setBackground(Color.red);
        green=new JButton();
        green.setBackground(Color.green);
        yellow=new JButton();
        yellow.setBackground(Color.yellow);
        blue=new JButton();
        blue.setBackground(Color.blue);
        purple=new JButton();
        purple.setBackground(Color.magenta);
        pink=new JButton();
        pink.setBackground(Color.pink);
        //为按钮添加事件类对象
        button1.addActionListener(draw);
        button2.addActionListener(draw);
        button3.addActionListener(draw);
        button4.addActionListener(draw);
        button5.addActionListener(draw);
        button6.addActionListener(draw);
        button7.addActionListener(draw);
        button8.addActionListener(draw);
        button9.addActionListener(draw);
        button10.addActionListener(draw);
        brush.addActionListener(draw);
        eraser.addActionListener(draw);
        clear.addActionListener(draw);
        red.addActionListener(draw);
        green.addActionListener(draw);
        yellow.addActionListener(draw);
        blue.addActionListener(draw);
        purple.addActionListener(draw);
        pink.addActionListener(draw);
        nowcolor.addActionListener(draw);
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button6);
        panel2.add(button7);
        panel2.add(button8);
        panel2.add(button9);
        panel2.add(button10);
        panel2.add(brush);
        panel2.add(eraser);
        panel2.add(red);
        panel2.add(green);
        panel2.add(yellow);
        panel2.add(blue);
        panel2.add(purple);
        panel2.add(pink);
        panel2.add(clear);
        panel2.add(nowcolor);
        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension(880,800));
        panel2.setPreferredSize(new Dimension(190,100));
        this.add(panel,BorderLayout.WEST);
        this.add(panel2,BorderLayout.EAST);
        this.setTitle("简易画板***杨路恒");
        this.setSize(1100,800);
        this.setLocation(500,200);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //在绘图面板上画笔
        panel.addMouseListener(draw);
        panel.addMouseMotionListener(draw);
        g=panel.getGraphics();
        draw.setG(g);
        draw.setNowColor(nowcolor);
        shapeArray=draw.getShapeArr();
    }

    @Override
    public void paint(Graphics g) {                   //进行图形遍历重绘
        super.paint(g);
        for (NetJavaShape a:shapeArray){
            a.redraw();
        }
    }

    public static void main(String []args){
        new Gui();
    }     //程序运行
}
