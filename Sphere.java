public class Sphere
    extends Circle
{
	protected double thickness;
    protected double density;
    protected String metalType;

    public Sphere()
    {
        super();
        metalType = "tin";
		density = TIN;
		thickness = 1;
    }//End standard sphere
    
    public Sphere (double radius, double thickness, String metalType)
    {
       this.radius = radius;
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
    }//End created sphere
    
    public void setThickness(double thickness)
    {
      this.thickness = thickness;
    }//End setThickness
    
    public double getThickness()
    {
        return thickness;
    }//End getThickness
    
    @Override
    public double findSurfaceArea ()
    {
        return 4 * java.lang.Math.PI * radius * radius;
    }//End findSurfaceArea
    
    @Override
    public double findCircumference()
    {
        return 2 * java.lang.Math.PI * radius;
    }//End findCircumference
    
    @Override
    public double findVolume()
    {
        return ((4 * java.lang.Math.PI * Math.pow(radius, 3)) / 3);
    }//End findVolume
    
    public double findMetalVolume()
    {
        return findVolume() - findInnerVolume();
    }//End findMetalVolume
    
    public double findInnerVolume()
    {
        return (4 * java.lang.Math.PI * (radius - thickness) * (radius - thickness) * (radius - thickness))/3;
    }//End findInnerVolume
    
    @Override
    public double findWeight()
    {
        return this.findMetalVolume() * density;
    }//End findWeight
    
    @Override
    public String toString()
    {
        return  "================================================================"
        		+"\nSphere is made of " + metalType + " with density " + density + "kg/dm\u00B3"
        		+"\nSphere radius = " + radius + "dm"
                + "\nSphere thickness = " + getThickness() + "dm"
                + "\nSphere surface area = " + findSurfaceArea() + "dm\u00B2"
                + "\nSphere volume = " + findVolume() + "dm\u00B3"
                + "\nSphere inner volume = " + findInnerVolume() + "dm\u00B3"
                + "\nSphere volume of the metal = " + findMetalVolume() + "dm\u00B3"
                + "\nSphere weight = " + findWeight() + "kg"
                +"\n================================================================\n";
    }//End toString
}//End class Sphere