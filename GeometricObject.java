public abstract class GeometricObject
{
    protected double IRON = 7.8;
    protected double ALUMINIUM = 2.7;
    protected double COPPER = 8.9;
    protected double TIN = 7.3;
    
   // public java.util.Date dateCreated;
   // dateCreated = new java.util.Date();

    public abstract double findArea();
    public abstract double findVolume();
    public abstract double findCircumference();
    public abstract double findSurfaceArea ();
    public abstract double findWeight ();
    public abstract String toString ();
}//End abstract class GeometricObject