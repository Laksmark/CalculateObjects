public abstract class Circle
    extends GeometricObject
{
    protected double radius;

    public Circle()
    {
        super();
        radius = 3;
    }//End standard Circle
    
    public void setRadius(double radius)
    {
        this.radius = radius;
    }//End setRadius
    
    public double getRadius()
    {
        return this.radius;
    }//End getRadius
    
    @Override
    public double findArea()
    {
        return (java.lang.Math.PI * radius * radius);
    }//End findArea

    @Override
    public double findCircumference()
    {
        return (java.lang.Math.PI * 2 * radius);
    }//End findCircumference
    
    @Override
    public String toString()
    {
        return " Circle radius = " + radius + "dm";
    }//End toString
}//End abstract class Circle