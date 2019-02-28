import java.util.Scanner;

public class CalculateObjects
{
    private static Scanner input;

	public static void main(String[] args)
    {
    	input = new Scanner(System.in);
        int firstChoice = 1;
        
        System.out.println("This program calculates the weight of 3D objects.");
        System.out.println("The availible objects are; cylinder, cone, sphere and box.");
        System.out.println("The objects is availible in four different types of metal;");
        System.out.println("iron, aluminium, copper and tin.");
        System.out.println("All objects are in 'closed' form with same thickness from all sides.");
        System.out.println("All availible data will be shown.\n");
        
		while (firstChoice != 0)
        {
			firstChoice = 0;
	        System.out.println("Would you like to run a set of standard objects or make your own objekt?");
	        System.out.println("Enter 0 to exit");
	        System.out.println("Enter 1 for standard objects");
	        System.out.println("Enter 2 to create your own object");
	        firstChoice = input.nextInt();
        if (firstChoice == 1)
        {
        	runStandard();
        }//end if
        if (firstChoice == 2)
        {
        	runOwnObject();
        }
        }//end while
    }//end main
	
    private static void runStandard()
    {
    	 //Creates new standard cylinder
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder.toString());

        //Creates new standard cone
        Cone cone = new Cone();
        System.out.println(cone.toString());

        //Creates a new standard sphere
        Sphere sphere = new Sphere ();
        System.out.println(sphere.toString());

        //Creates new standard box
        Box box = new Box();
        System.out.println(box.toString());
    }
    private static void runOwnObject()
    {
    	int chooseObject;
    	System.out.println("What kind of object do you want to create?");
    	System.out.println("Enter 1 for cylinder");
    	System.out.println("Enter 2 for cone");
    	System.out.println("Enter 3 for sphere");
    	System.out.println("Enter 4 for box");
    	chooseObject = input.nextInt();
    	
    	if (chooseObject == 1)
    	{
    		createCylinder();
    	}
    	if (chooseObject == 2)
    	{
    		createCone();
    	}
    	if (chooseObject == 3)
    	{
    		createSphere();
    	}
    	if (chooseObject == 4)
    	{
    		createBox();
    	}
    }//End runOwnObjects
    
    private static void createCylinder()
    {
    	double radius = 0;
    	double length = 0;
    	double thickness = 0;
    	int c = 0;
    	String metalType = "";
    	
    	System.out.println("Now set the parameters of the cylinder.");
    	radius = askUserRadius();
    	length = askUserLength();
    	
    	/* Asks the user about the thickness*/
    	while (c == 0)
    	{
    		thickness = askUserThickness();
    		if (thickness > radius)
    		{
    			System.out.println("Thickness can not be >radius.");
    			System.out.println("Try again.");
    		}
    		else if ((2 * thickness) > length)
    		{
    			System.out.println("2 * thickness can not be >length.");
    			System.out.println("Try again.");
    		}
    		else
    			c = 1;
    	}//End while
    	metalType = askUserMetalType();
    	
    	Cylinder cylinder = new Cylinder(radius, length, thickness, metalType);
    	System.out.println(cylinder.toString());
    }//End createCylinder
    
    private static void createCone()
    {
    	double radius;
    	double height;
    	double thickness=0;
    	String metalType;
    	
    	System.out.println("Now set the parameters of the cone.");
    	radius = askUserRadius();
    	height = askUserHeight();
    	int a=0;
    	double newRadius;
    	double newHeight;
    	double x;
    	double y;
    	while (a==0)
    	{
    		thickness = askUserThickness();
    		
        	
        	x = (height * thickness)/radius;
        	y = Math.sqrt(Math.pow(x, 2) + Math.pow(thickness, 2));
        	newHeight = height - thickness - y;
        	newRadius = (newHeight * radius) / height;
    		if (newRadius<0)
    		{
    			System.out.println("Thickness can not be > inner radius.");
    			System.out.println("Try again.");

    		}//end if
    		else
    			a++;
    	}//end while
    	metalType = askUserMetalType();
    	
    	Cone cone = new Cone(radius, height, thickness, metalType);
        System.out.println(cone.toString());
    }//End createCone
    
    private static void createSphere()
    {
    	double radius;
    	double thickness = 0;
    	String metalType;
    	int c = 0;
    	
    	System.out.println("Now set the parameters of the sphere.");
    	radius = askUserRadius();
    	while (c == 0)
    	{
    	thickness = askUserThickness();
    	if (thickness > radius)
    	{
    		System.out.println("Thickness can not be >radius.");
    		System.out.println("Maximum thickness is " + radius + "dm");
    		System.out.println("Try again.");
    	}
    	else
    		c = 1;
    	}
    	metalType = askUserMetalType();
    	
    	//Creates a new sphere (radius, thickness, metalType)
        Sphere sphere = new Sphere (radius, thickness, metalType);
        System.out.println(sphere.toString());
    }//End createSphere
    
    private static void createBox()
    {
    	double length;
    	double width;
    	double height;
    	double thickness = 0;
    	String metalType;
    	int c = 0;
    	
    	System.out.println("Now set the parameters of the box.");
    	length = askUserLength();
    	width = askUserWidth();
    	height = askUserHeight();
    	
    	while (c == 0)
    	{
    		thickness = askUserThickness();
    		
    		if (2 * thickness > length)
    		{
    			System.out.println("2 * thickness can not be >length.");
    			System.out.println("Try again.");
    		}//if
    		else if ((2 * thickness) > width)
    		{
    			System.out.println("2 * thickness can not be >width.");
    			System.out.println("Try again.");
    		}//if
    		else if ((2 * thickness) > height)
    		{
    			System.out.println("2 * thickness can not be >height.");
    			System.out.println("Try again.");
    		}//if
    		else
    			c = 1;
    	}//End while
    	metalType = askUserMetalType();
    	Box box = new Box(length, width, height, thickness, metalType);
        System.out.println(box.toString());
    }//End createBox
    
    private static double askUserRadius()
    {
    	double radius = 0;
    	int check = 0;
    	while (check == 0)
    	{
    		System.out.print("Radius:");
    		radius = input.nextDouble();
    		if (radius < 0)
    		{
    			System.out.println("Radius can not be <0.");
    			System.out.println("Try again.");
    		}
    		else
    			check = 1;
    	}
    	return radius;
    }//end askUserRadius
    
    private static double askUserLength()
    {
    	double length = 0;
    	int check = 0;
    	while (check == 0)
    	{
    		System.out.print("Length:");
    		length = input.nextDouble();
    		if (length < 0)
    		{
    			System.out.println("Length can not be <0.");
    			System.out.println("Try again.");
    		}
    		else
    			check = 1;
    	}
    	return length;
    }//End askUserLength
    
    private static double askUserHeight()
    {
    	double height = 0;
    	int check = 0;
    	while (check == 0)
    	{
    		System.out.print("Height:");
    		height = input.nextDouble();
    		if (height < 0)
    		{
    			System.out.println("Height can not be <0.");
    			System.out.println("Try again.");
    		}
    		else
    			check = 1;
    	}
    	return height;
    }//End askUserHeight
    
    private static double askUserWidth()
    {
    	double width = 0;
    	int check = 0;
    	while (check == 0)
    	{
    		System.out.print("Width:");
    		width = input.nextDouble();
    		if (width < 0)
    		{
    			System.out.println("Width can not be <0.");
    			System.out.println("Try again.");
    		}
    		else
    			check = 1;
    	}
    	return width;
    }//End askUserWidth
    
    private static double askUserThickness()
    {
    	double thickness = 0;
    	int c = 0;
    	while (c == 0)
    	{
    		System.out.print("\nThickness:");
    		thickness = input.nextDouble();
    		if (thickness <0)
    		{
    			System.out.println("Thickness can not be <0");
    			System.out.println("Try again.");
    		}
    		else
    			c = 1;
    	}//end while
    	return thickness;
    }
    
    private static String askUserMetalType()
    {
    	String metalType = "";
    	int c = 0;
    	while (c == 0)
    	{
	    	System.out.println("Choose metal type;");
	    	System.out.println("Enter 1 for iron");
	    	System.out.println("Enter 2 for aluminium");
	    	System.out.println("Enter 3 for copper");
	    	System.out.println("Enter 4 for tin\n:");
	    	int choice = input.nextInt();
	    	switch (choice)
	    	{
	    	case 1:
	    	{
	    		metalType = "iron";
	    		c = 1;
	    		break;
	    	}
	    	case 2:
	    	{
	    		metalType = "aluminium";
	    		c = 1;
	    		break;
	    	}
	    	case 3:
	    	{
	    		metalType = "copper";
	    		c = 1;
	    		break;
	    	}
	    	case 4:
	    	{
	    		metalType = "tin";
	    		c = 1;
	    		break;
	    	}
	    	default:
	    	{
	    		System.out.println("You entered a invalid number.");
	    		System.out.println("Try again.");
	    	}
	    	}//End switch
    	}//End while
    	return metalType;
    }//End askUserMetalType
}//end class