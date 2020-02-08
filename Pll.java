
public class Pll{

    public boolean onGround = false;
    public boolean gg = false;
	public boolean collided = false;
	
	public Cos sta = Cos.fall;

    public double dx = 0.5;
	public double dy = 0.0;

	private double g = 	0.0015;
	private double friction = 0.01;

    private double xPosition = 0;			// The X coordinate of this Rectangle
	private double yPosition = 0;			// The Y coordinate of this Rectangle
	private double width = 20;				// The width of this Rectangle
	private double height = 20;
	private double cwid = width-1;
	private double chig = height-1;
	private String colour = "GREY";				// The colour of this Rectangle

    public Pll(double x, double y, String col)
	{
		xPosition = x*20;
		yPosition = y*20;
		colour = col;
	}

    public void updataPos(long dTime){
		if (dx>0) dx = Math.max(0, dx-friction);
		if (dx<0) dx = Math.min(0, dx+friction);
		this.xPosition = between(980, 0, xPosition + dTime * dx);
		this.yPosition = between(480, 0, yPosition + dTime * dy);
		if(dy>0 && sta.equals(Cos.jump)) sta = Cos.fall;
		
	}
	public void applyg(long dTime){
		dy += g*dTime;
	}

	public void slowdown(){
		dx = 0;
	}
	
	private double between(double upper, double lower, double value){
		if(value>upper){
			return upper;
		}else if(value<lower){
			return lower;
		}
		return value;
	}

    public boolean collide(Brick b){
		if(b.exist){
			return !(yPosition + chig < b.getYPosition() || yPosition > b.getYPosition() + b.getHeight() 
				|| xPosition > b.getXPosition()+b.getWidth() || xPosition + cwid < b.getXPosition());
		}
		return false;


    }


	public void setdx(double newdx){
		dx = newdx;
	}

	public void setdy(double newdy){
		dy = newdy;
	}

    public double getXPosition()
	{
		return xPosition;
	}

	public double getYPosition()
	{
		return yPosition;
	}


	public void setXPosition(double x)
	{
		this.xPosition = x;
	}


	public void setYPosition(double y)
	{
		this.yPosition = y;
	}

	public double getWidth()
	{
		return width;
	}

	public void setWidth(double w)
	{
		width = w;
    }
    
	public double getHeight()
	{
		return height;
    }
    
	public void setHeight(double h)
	{
		height = h;
	}

	public String getColour()
	{
		return colour;
	}

	public void setColour(String c)
	{
		colour = c;
	}


}