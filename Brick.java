
public class Brick{

    public boolean exist = false;
    public double nx = 0;
    public double ny = 0;

    private double xPosition = 0;			// The X coordinate of this Rectangle
	private double yPosition = 0;			// The Y coordinate of this Rectangle
	private double width = 20;				// The width of this Rectangle
	private double height = 20;				// The height of this Rectangle
	private String colour = "GREY";				// The colour of this Rectangle

	public Brick(){

	}

	public Brick(double row, double colu, String col)
	{
        ny = row;
        nx = colu;
		xPosition = nx*20;
		yPosition = ny*20;
		colour = col;
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