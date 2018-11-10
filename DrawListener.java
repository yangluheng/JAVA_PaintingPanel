import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class DrawListener implements MouseListener,ActionListener,MouseMotionListener {               //实现鼠标、组件事件监听接口
    private Color color;                                                                              //颜色引用
    private Graphics g;                                                                               //创建画笔
    private Graphics2D g1;
    private String str;                                                                               //字符串用来存放按钮上的内容
    private int x1,x2,y1,y2,x3,y3,x4,y4,x,y,startx1,starty1,startx2,starty2;                          //坐标定义
    private JButton nowColor;                                                                         //当前选中颜色按钮
    private List<NetJavaShape> shapeArr=new ArrayList<NetJavaShape>();                                //存放图形类的集合
    //创建各种图形类对象引用
    private reline shapeline;
    private refilljuxing shapefilljuxing;
    private requxian shapequxian;
    private reshexian shapeshexian;
    private rejuxing shapejuxing;
    private rezhexian shapezhexian;
    private retuoyuan shapetuoyuan;
    private refilltuoyuan shapefilltuoyuan;
    private clear reclear;
    private bishua bs;
    private boolean flag=false;                                                                      //定义布尔变量用于判断多边形是否绘制
    private Random rand=new Random();                                                                //用随机数刻画喷桶的范围大小

    public List<NetJavaShape> getShapeArr() {
        return shapeArr;
    }                                     //获取图形集合的方法

    public void setG(Graphics g){
        this.g=g;
    }                                                       //获取画笔方法
    public void setNowColor(JButton nowColor){
        this.nowColor=nowColor;
    }                            //获取当前颜色按钮
    @Override
    public void actionPerformed(ActionEvent e) {
        //获取按钮上的字符串
        if ("".equals(e.getActionCommand())){                                                       //点击的是颜色按钮
            JButton button=(JButton)e.getSource();
            color=button.getBackground();
            nowColor.setBackground(color);
        }
        else str=e.getActionCommand();                                                              //点击的是图形按钮
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("成功");
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if ("射线".equals(str)) {                               //调用射线类方法
            shapeshexian = new reshexian(g, x1, y1, x2, y2, color);
            shapeshexian.redraw();
            shapeArr.add(shapeshexian);                       //把射线类对象添加到集合中
            x2 = e.getX();
            y2 = e.getY();
        }
        else if ("曲线".equals(str)){
            x=e.getX();
            y=e.getY();
            shapequxian=new requxian(g,x,y,x1,y1,color);
            shapequxian.redraw();
            shapeArr.add(shapequxian);
            x1=x;
            y1=y;

        }
        else if ("橡皮擦".equals(str)){
            g.setColor(Color.white);
            g1=(Graphics2D)g;
            x=e.getX();
            y=e.getY();
            g1.setStroke(new BasicStroke(10));
            g1.drawLine(x,y,x1,y1);
            x1=e.getX();
            y1=e.getY();
            g1.drawLine(x,y,x1,y1);
            g1.setStroke(new BasicStroke(1));

        }
        else if ("笔刷".equals(str)){
            x1=e.getX();
            y1=e.getY();
            x2=e.getX();
            y2=e.getY();
            bs=new bishua(g,x1,y1,x2,y2,color);
            bs.redraw();
            shapeArr.add(bs);

        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        g.setColor(color);                                      //获取鼠标按下的画笔颜色和坐标
        x=e.getX();
        y=e.getY();
        x1=e.getX();
        y1=e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2=e.getX();                                         //获取鼠标释放时的坐标
        y2=e.getY();
        if ("矩形".equals(str)) {
            //shapejuxing=new rejuxing(g,Math.min(x,x1),Math.min(y,y1),Math.abs(x-x1),Math.abs(y-y1),color);
            shapejuxing=new rejuxing(g,x,y,x2,y2,color);
            shapejuxing.redraw();
            shapeArr.add(shapejuxing);
        }
        else if ("椭圆".equals(str)){
            x1=e.getX();
            y1=e.getY();
            shapetuoyuan=new retuoyuan(g,Math.min(x,x1),Math.max(y,y1),Math.abs(x-x1),Math.abs(y-y1),color);
            shapetuoyuan.redraw();
            shapeArr.add(shapetuoyuan);

        }
        else if ("实椭圆".equals(str)){
            x1=e.getX();
            y1=e.getY();
            shapefilltuoyuan=new refilltuoyuan(g,Math.min(x,x1),Math.max(y,y1),Math.abs(x-x1),Math.abs(y-y1),color);
            shapefilltuoyuan.redraw();
            shapeArr.add(shapefilltuoyuan);

        }
        else if ("折线".equals(str)){
            shapezhexian=new rezhexian(g,x,y,x3,y3,color);
            shapezhexian.redraw();
            x3=e.getX();
            y3=e.getY();
            shapezhexian=new rezhexian(g,x,y,x3,y3,color);
            shapezhexian.redraw();
            shapeArr.add(shapezhexian);
        }
        else if ("直线".equals(str)){
            x4=e.getX();
            y4=e.getY();
            shapeline=new reline(g,x,y,x4,y4,color);
            shapeline.redraw();
            shapeArr.add(shapeline);
        }
        else if ("实矩形".equals(str)){
            x3=e.getX();
            y3=e.getY();
            shapefilljuxing=new refilljuxing(g,x,y,x3,y3,color);
            shapefilljuxing.redraw();
            shapeArr.add(shapefilljuxing);
        }
        else if ("喷桶".equals(str)) {
            x2 = e.getX();
            y2 = e.getY();
            for (int i = 0; i < 20; i++) {
                int r1 = rand.nextInt(30) - 10;
                int r2 = rand.nextInt(30) - 10;
                g.drawLine(x2 + r1, y2 + r2, x2 + r1, y2 + r2);
            }
        }
        else if ("多边形".equals(str)){
            g.setColor(color);
            x2=e.getX();
            y2=e.getY();
            if (!flag) {                       //!flag说明为真
                g.drawLine(x1, y1, x2, y2);
                startx1=x1;
                starty1=y1;
                startx2=x2;
                starty2=y2;
                flag=true;
            }

        }
        else if ("擦除面板".equals(str)){
            reclear=new clear(g);
            reclear.redraw();
            shapeArr.add(reclear);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(str.equals("多边形")&&flag){                            //鼠标点击时绘制连接多边形
            g.setColor(color);
            x2=e.getX();                              //获取新的点的坐标
            y2=e.getY();
            if(e.getClickCount()==2){                  //记录点击次数，点击第二次后开始直线连接
                g.drawLine(startx1,starty1,startx2,starty2);
                flag=false;
            }
            g.drawLine(startx2,starty2,x2, y2);

            startx2=x2;   //存下上个点的坐标
            starty2=y2;
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
