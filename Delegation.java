public class Delegation {
	public static void main(String args[]) {
		C111 c111 = new C111();
		System.out.println(c111.m111());

		C112 c112 = new C112();
		System.out.println(c112.m112());
		
		D111 d111 = new D111();
		System.out.println(d111.m111());

		D112 d112 = new D112();
		System.out.println(d112.m112());
	}
}
 class C1 {
	 
	protected int a1 = 1;

	public int m1() {
		return a1 + p1(100) + q1(100);
	}

	public int p1(int m) {
		return m;
	}
	
	public int q1(int m) {
		return m;
	}
}

 class C11 extends C1 {
	protected int a11 = 11;

	public int m11() {
		return m1() + q1(200);
	}

	public int p1(int m) {
		return m * a1;
	}

	public int q1(int m) {
		return m + a11;
	}
}

class C111 extends C11 {
	protected int a111 = 111;
	

	public int m111() {
		return m1() + m11() + a111;
	}
	
	public int p1(int m) {
		return m * a1 * a11;
	}
}

class C112 extends C11 {
	protected int a112 = 112;

	public int m112() {
		return m1() + m11() + a112;
	}

	public int p1(int m) {
		return m * a1 * a11 * a112;
		
	}
}


// -------SIMULATING CLASS INHERITANCE BY DELEGATION ---------

interface I1 {
	
	public int m1(I1 objI1);
	public int getA1();
	public int p1(int m);
	public int q1(int m);
	 
}

interface I11 extends I1 {
	 
	public int m11(I11 objI11);
	public int getA11();
}

interface I111 extends I11 {
	
	public int getA111();
	public int m111();
	 
}

interface I112 extends I11 {
	 
	public int getA112();
	public int m112();
	
}

class D1 implements I1 {
	
	private int a1 = 1;

	public int getA1() {
		return a1;
	}
	
	public int m1(I1 objI1) {
		//Call methods on passed in object
		return objI1.getA1() + objI1.p1(100) + objI1.q1( 100);
	}

	public int p1(int m) {
		
		return m;
	}
	public int q1(int m){
		
		return m;
	}
	
	}
	 


class D11 implements I11 {
	
	private int a11 = 11;
	//Encapsulate parent as delegate
	I1 delegate1 = new D1();
	
	//This is like directly inherited method
	public int m1(I1 objI1) {
		//Delegate the call
		return delegate1.m1(objI1);
		
	}
	public int getA1() {
		
		return delegate1.getA1();
	}
	public int getA11() {
		
		return a11;
	}
	
	//This is like overridden method
	public int p1(int m) {
		
		return m* getA1();	
	}
	public int q1(int m) {
		
		return m + getA11();	
	}
	
	//This is like methods exclusive to the child class
	public int m11(I11 objI11) {
		
		return m1(objI11) + objI11.q1(200);	
	}
	
}

 
class D111 implements I111 { 
	
	private int a111 = 111;
	//Encapsulate parent as delegate
	I11 delegate11 = new D11();
	
	//Like inherited methods
	public int getA1(){
		//delegate the call
		return delegate11.getA1();
	}
	public int getA11(){
		return delegate11.getA11();
	}
	public int m1(I1 obj1){
		return delegate11.m1(obj1);
	}
	public int m11(I11 obj2){
		return delegate11.m11(obj2);
	}	
	public int q1(int m){
		return delegate11.q1(m);
	}	
	
	//Like overridden methods
	public int p1(int m){
		//m * a1 * a11;
		return m * getA1()*getA11();
	}

	//Like exclusive child class methods
	public int m111(){
		//m1() + m11() + a111
		return delegate11.m1(this) + delegate11.m11(this) + getA111();
	}
	public int getA111(){
		return a111;
	}
}	

class D112 implements I112 {
	
	private int a112 = 112;
	I11 delegate11  = new D11();
	
	public int getA1(){
		return delegate11.getA1();
	}
	public int getA11(){
		return delegate11.getA11();
	}
	public int q1(int m){
		return delegate11.q1(m);
	}
	public int m1(I1 obj1){
		return delegate11.m1(obj1);
	}
	public int m11(I11 obj2){
		return delegate11.m11(obj2);
	}
	
	//Like overridden methods
	public int p1(int m){
		//m * a1 * a11 * a112;
		return m*getA1()*getA11()*getA112();
	}
	
	//Exclusive methods
	public int m112(){
		// m1() + m11() + a112
		return delegate11.m1(this) + delegate11.m11(this) + getA112();
	}
	public int getA112(){
		return a112;
	}
	
	 
}
