public abstract class Rectangle
    extends GeometricObject
{
    protected double length, width;

    public Rectangle()// Sets standard values if nothing else is set
        {
            length = 3;
            width = 3;
        }//end standard rectangle
    
    public void setLength(double length)
    {
        this.length = length;
    }//end setLength
    
    public void setWidth(double width)
    {
        this.width = width;
    }//end setWidth
    
    public double getLenght()
    {
        return length;
    }//end getLength
    
    public double getWidth()
    {
        return width;
    }//end getWidth

    @Override
    public double findArea()
    {
        return length * width;
    }//end findArea

    @Override
    public double findCircumference()
    {
        return (2 * length) + (2 * width);
    }//End findCircumference
    
    @Override
    public String toString()
    {
        return "Rectangle length = " + length + "dm"
                +"\nRectangle width = " + width + "dm"
                +"\nRectangle circumferense = " + findCircumference() + "dm"
                +"\nRectangle area = " + findArea() + "dm\u00B2";
    }//End toString
}//End abstract class Rectangle