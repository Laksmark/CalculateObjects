public class Box
    extends Rectangle
{
    protected double height;
    protected double thickness;
    protected double density;
    protected String metalType;

    public Box()
    {
        super();
        height = 3.0;
        thickness = 1.0;
        density = IRON;
        metalType = "iron";
    }//End standard box
    
    public Box(double length, double width, double height, double thickness, String metalType)
    {
        this.length = length;
        this.width = width;
        this.height = height;
        this.thickness = thickness;
        this.metalType = metalType;
        
        /* Check what kind of metaltype to be used*/
        if (metalType.equals("iron"))
        {
        	this.density = IRON;
        }//End check iron
        if (metalType.equals("aluminium"))
        {
        	this.density = ALUMINIUM;
        }//End check aluminium
        if (metalType.equals("tin"))
        {
        	this.density = TIN;
        }//End check tin
        if (metalType.equals("copper"))
        {
        	this.density = COPPER;
        }//End copper
    }//End created box
    
    public double getHeight()
    {
        return height;
    }//End getHeight
    
    public void setHeight (double height)
    {
        this.height = height;
    }//End setHeight
    
    public void setDensity (double density)
    {
        this.density = density;
    }//End setDensity
    
    public void setThickness(double thickness)
    {
        this.thickness = thickness;
    }//End setThickness
    
    @Override
    public double findVolume()
    {
        return (height * findArea());
    }//End findVolume
    
    public double findInnerVolume()
    {
    	return (height-(thickness * 2))
                * (length - (thickness * 2))
                * (width - (thickness * 2));
    }//End findInnerVolume
    
    public double findMetalVolume()
    {
    	return (height * findArea())
                - ((height-(thickness * 2))
                * (length - (thickness * 2))
                * (width - (thickness * 2)));
    }//End findMetalVolume
    
    @Override
    public double findWeight ()
    {
        return findMetalVolume() * density;
    }//End findWeight
    
    @Override
    public double findSurfaceArea ()
    {
        return 2 * findArea() + 2 * (height * length) + 2 * (height * width);
    }//End FindSurfaceArea
    
    @Override
    public String toString()
    {
        return  "================================================================"
        		+"\nBox is made of " + metalType + " with density " + density + "kg/dm\u00B3"
        		+"\nBox length = " + length + "dm"
                +"\nBox width = " + width + "dm"
                +"\nBox height = " + height + "dm"
                +"\nBox surface area = " + findSurfaceArea() + "dm\u00B2"
                +"\nBox volume = " + findVolume() + "dm\u00B3"
                +"\nBox inner volume = " + findInnerVolume() + "dm\u00B3"
                +"\nBox volume of the matal = " + findMetalVolume() + "dm\u00B3"
                +"\nBox weight = " + findWeight() + "kg"
                +"\n================================================================\n";
    }//End toString
}//End class Box