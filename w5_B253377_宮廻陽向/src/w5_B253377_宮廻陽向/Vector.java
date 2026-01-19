package w5_B253377_宮廻陽向;

public class Vector {
	double x;
	double y;
	double z;
	
	Vector(double x, double y, double z){
		
		this.x = x;
		this.y = y;
		this.z = z;
		//System.out.println("(x, y, z)=(" + x +","+ y +","+ z +")");
		this.show();
	}
	
	Vector(){
		
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
		//System.out.println("(x, y, z)=(" + x +","+ y +","+ z +")");
		this.show();
	}
	
	void show() {
		System.out.println("(x, y, z)=(" + x +","+ y +","+ z +")");
	}
	
	void add(Vector other) {
		this.x += other.x;
		this.y += other.y;
		this.z += other.z;
		
	}
	
	void sub(Vector other) {
		this.x -= other.x;
		this.y -= other.y;
		this.z -= other.z;
		
	}
	
	public static void main(String[] args) {
		System.out.print("v1: ");
		Vector v1 = new Vector(1, 2, 3);
		System.out.print("v2: ");
		Vector v2 = new Vector(0, 2, 0);
		
		//v1.add(v2);
		
		//System.out.print("v1 + v2 = ");
		//v1.show();
		
		v1.sub(v2);
		
		System.out.print("v1 - v2 = ");
		v1.show();

	}

}
