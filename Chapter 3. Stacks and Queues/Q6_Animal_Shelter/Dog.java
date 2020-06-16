package Q6_Animal_Shelter;

public class Dog extends Animal {
	public Dog(String n){
		super(n);
	}

	public String name(){
		return "Dog: " + name;
	}
}