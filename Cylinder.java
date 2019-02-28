public class Cylinder
    extends Circle
{
    protected double length;
    protected double thickness;
    protected double density;
    protected String metalType;

    public Cylinder()
    {
      super();
      length = 3.0;
      thickness = 1.0;
      metalType = "aluminium";
      density = ALUMINIUM;
    }//End standard Cylinder
    //Creates new cylinder
    public Cylinder (double radius, double length, double thickness, String metalType)
    {
        this.radius = radius;
        this.length = length;
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
    }//End created Cylinder
    
    public double getLength()
    {
      return length;
    }//End getLength
    
    public double getThickness()
    {
        return thickness;
    }//End getThickness

    /** Set length */
    public void setLength(double length)
    {
      this.length = length;
    }//End setLength
    
    public void setThickness(double thickness)
    {
      this.thickness = thickness;
    }//End setThickness
    
    public void setDensity (double density)
    {
        this.density = density;
    }//End setDensity
    
    public void setMetalType(String metalType)
    {
        this.metalType = metalType;
    }//End setMetalType
    
      @Override
    public double findVolume()
    {
      return (super.findArea() * length);
    }//End findVolume
      
    public double findInnerVolume()
    {
      return (java.lang.Math.PI * (super.getRadius() - thickness) * (super.getRadius() - thickness)  * (length-thickness*2));
    }//End findInnerVolume
    
    public double findMetalVolume()
    {
      return (super.findArea() * length) - (java.lang.Math.PI * (super.getRadius() - thickness) * (super.getRadius() - thickness)  * (length - (thickness * 2)));
    }//End findMetalVolume
    
      @Override
    public double findWeight()
    {
        return this.findMetalVolume() * density;
    }//End findWeight
      
      @Override
    public double findSurfaceArea ()
    {
        return (2 * super.findArea() + length * super.findCircumference());
    }//End findSurfaceArea
      
      //Prints out cylinders data.
      @Override
    public String toString()
      {
          return  "================================================================"
        		  +"\nCylinder is made of " + metalType + " with density " + density + "kg/dm\u00B3"
                  +"\nCylinder radius = " + radius + "dm"
                  + "\nCylinder length = " + length + "dm"
                  + "\nCylinder thickness = " + thickness + "dm"
                  + "\nCylinder surface area = " + findSurfaceArea()+ "dm\u00B2"
                  + "\nCylinder volume = " + findVolume() + "dm\u00B3"
                  + "\nCylinder inner volume = " + findInnerVolume() + "dm\u00B3"
                  + "\nCylinder volume of the metal = " + findMetalVolume() + "dm\u00B3"
                  + "\nCylinder weight = " + findWeight() + "kg"
                  +"\n================================================================\n";
      }//End toString
}//End class Cylinder