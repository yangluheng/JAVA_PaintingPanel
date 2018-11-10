import java.awt.*;                //定义一个接口，里面用抽象方法让图形类实现该接口
public interface NetJavaShape{
    public abstract void redraw();
}
class reline implements NetJavaShape{                //实现重绘直线图形
    Graphics g;
    int x,y,x1,y1,x2,y2,x3,y3,x4,y4;
    Color color;
    public reline(Graphics g,int x1,int y1,int x2,int y2,Color color){    //构造方法初始化对象
        this.g=g;
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.color=color;
    }
    @Override
    public void redraw() {                         //实现接口方法进行直线绘制
        g.setColor(color);
        g.drawLine(x1,y1,x2,y2);
    }
}
class refilljuxing implements NetJavaShape {                //实现重绘实矩形图形
    Graphics g;
    int x, y, x1, y1, x2, y2;
    Color color;

    public refilljuxing(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        this.g = g;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    @Override
    public void redraw() {
        g.setColor(color);
        g.fillRect(x1,y1,x2,y2);                          //实现接口方法进行实矩形绘制
    }
}
class requxian implements NetJavaShape {                //实现重绘曲线图形
    Graphics g;
    int x, y, x1, y1, x2, y2;
    Color color;

    public requxian(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        this.g = g;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    @Override
    public void redraw() {                                  //实现接口方法进行曲线绘制
        g.setColor(color);
        g.drawLine(x1,y1,x2,y2);
    }
}
class reshexian implements NetJavaShape {                //实现重绘射线方法
    Graphics g;
    int x, y, x1, y1, x2, y2;
    Color color;

    public reshexian(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        this.g = g;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    @Override
    public void redraw() {                          //实现接口方法进行射线绘制
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }
}
class rejuxing implements NetJavaShape {                //实现重绘矩形方法
    Graphics g;
    int x, y, x1, y1, x2, y2;
    Color color;

    public rejuxing(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        this.g = g;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    @Override
    public void redraw() {                                 //实现接口方法进行矩形绘制
        g.setColor(color);
                         /*
                                窗体左上角的坐标为（0，0）。所以左上角的坐标是较小的.
                                所以只需调用一个取较小值的一个方法Math.min(x1,x2)，Math.min(y1, y2)这样分别赋给x,y就可以了。
                                长宽的设置，我们也不能直接就x2-x1，y2-y1，需要对其取一个绝对值
                                Math.abs(x1-x2),Math.abs(y1-y2)。这样就可以正确的画出.
                                 */
        //g.drawRect(Math.min(x1,x2),Math.max(y1,y2),Math.abs(x1-x2),Math.abs(y1-y2));
        g.drawRect(x1,y1,x2,y2);
    }
}
class rezhexian implements NetJavaShape {                //实现重绘折线图形
    Graphics g;
    int x, y, x1, y1, x2, y2, x3, y3, x4, y4;
    Color color;

    public rezhexian(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        this.g = g;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    @Override
    public void redraw() {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }
}
class retuoyuan implements NetJavaShape {                //实现重绘椭圆图形
    Graphics g;
    int  x1, y1, x2, y2;
    Color color;

    public retuoyuan(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        this.g = g;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    @Override
    public void redraw() {
        g.setColor(color);
                                /*
                                窗体左上角的坐标为（0，0）。所以左上角的坐标是较小的.
                                所以只需调用一个取较小值的一个方法Math.min(x1,x2)，Math.min(y1, y2)这样分别赋给x,y就可以了。
                                长宽的设置，我们也不能直接就x2-x1，y2-y1，需要对其取一个绝对值
                                Math.abs(x1-x2),Math.abs(y1-y2)。这样就可以正确的画出.
                                 */
        g.drawOval(Math.min(x1,x2),Math.max(y1,y2),Math.abs(x1-x2),Math.abs(y1-y2));    //椭圆中x,y是左上角的位置，width,height是横轴和纵轴用Math函数找最大值最小值
    }
}
class refilltuoyuan implements NetJavaShape {                //实现重绘实椭圆图形
    Graphics g;
    int x, y, x1, y1, x2, y2, x3, y3, x4, y4;
    Color color;

    public refilltuoyuan(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        this.g = g;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    @Override
    public void redraw() {
        g.setColor(color);
        g.fillOval(Math.min(x1,x2),Math.max(y1,y2),Math.abs(x1-x2),Math.abs(y1-y2));
    }
}
/* class redubianxing implements NetJavaShape{                //实现重绘多边形图形
     Graphics g;
     int x1, y1, x2, y2;
     Color color;
     public redubianxing(Graphics g, int x1, int y1, int x2, int y2, Color color){
         this.g = g;
         this.x1 = x1;
         this.y1 = y1;
         this.x2 = x2;
         this.y2 = y2;
         this.color = color;
     }
     @Override
     public void redraw() {

     }
 }*/
class clear implements NetJavaShape{        //实现画板清除
    Graphics g;
    public clear(Graphics g){
        this.g=g;
    }
    @Override
    public void redraw() {
        g.clearRect(0,0,8808,8800);
    }
}
class bishua implements NetJavaShape {     //实现笔刷功能
    Graphics g;
    Graphics2D g1;
    int x1, y1, x2, y2;
    Color color;

    public bishua(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        this.g1 = (Graphics2D) g;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    @Override
    public void redraw() {
        g1.setColor(color);
        g1.setStroke(new BasicStroke(6));        //定义画笔大小
        g1.drawLine(x1, y1, x2, y2);
        g1.setStroke(new BasicStroke(2));
    }
}
