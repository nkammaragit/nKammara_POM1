package NaveenTests;

  class A {

	 public A() {
		 System.out.println("In A");
	 }
	 public A(int n) {
		 System.out.println("In int A");
	 }
	 
}

  class B extends A{
	 public B() {
		 System.out.println("In B");
	 }
	 public B(int n) {
		 this();
		 System.out.println("In int B");
	 }

}

 
