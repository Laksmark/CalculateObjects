public class Cone
    extends Circle
{
    protected double height;
    protected double thickness;
    protected double density;
    protected String metalType;

    public Cone()
    {
        super();
        height =3;
        thickness = 1;
        density = COPPER;
        metalType = "copper";
    }//End standard cone
    
    public Cone (double radius, double height, double thickness, String metalType)
    {
        this.radius = radius;
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
    }//End created cone
    
    public double getHeight()
    {
        return height;
    }//End getHeight
    
    public double getThickness()
    {
        return thickness;
    }//End getThickness
    
    public void setHeight(double height)
    {
        this.height = height;
    }//End setHeight
    
    public void setThickness(double thickness)
    {
      this.thickness = thickness;
    }//End setThickness
    
    public void setDensity (double density)
    {
        this.density = density;
    }//End setDensity
    
    public double findVolume()
    {
    	return (java.lang.Math.PI * (radius * radius) * height) / 3;
    }//End findVolume2
    
    public double findInnerVolume()
    {
    	double newRadius;
    	double newHeight;
    	double x;
    	double y;
    	
    	x = (height * thickness)/radius;
    	y = Math.sqrt(Math.pow(x, 2) + Math.pow(thickness, 2));
    	newHeight = height - thickness - y;
    	newRadius = (newHeight * radius) / height;
    	//System.out.println("x: "+x);
    	//System.out.println("y: "+y);
    	//System.out.println("newHeight: "+newHeight);
    	//System.out.println("newRadius: "+newRadius);
    	
    	return (java.lang.Math.PI * Math.pow(newRadius, 2) * newHeight) / 3;
    }
    
    public double findMetalVolume()
    {
    	return findVolume() - findInnerVolume();
    }
    
    @Override
    public double findWeight()
    {
        return findMetalVolume() * density;
    }//End findWeight
    
    @Override
    public double findSurfaceArea ()
    {
    	double side;
    	side = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
    	
		return java.lang.Math.PI * radius * side
              + java.lang.Math.PI * Math.pow(radius, 2);
    }//End findSurfaceArea
    
    @Override
    public String toString()
    {
        return  "================================================================"
        		+"\nCone is made of " + metalType + " with density " + density + "kg/dm\u00B3" 
        		+"\nCone radius = " + radius + "dm"
                + "\nCone height = " + getHeight() + "dm"
                + "\nCone thickness = " + getThickness() + "dm"
                + "\nCone surface area = " + findSurfaceArea()+ "dm\u00B2"
                + "\nCone volume = " + findVolume() + "dm\u00B3"
                + "\nCone inner volume = " + findInnerVolume() + "dm\u00B3"
                + "\nCone metal volume = " + findMetalVolume() + "dm\u00B3"
                + "\nCone weight = " + findWeight() + "kg"
                +"\n================================================================\n";
    }//End toString
}//End class Cone