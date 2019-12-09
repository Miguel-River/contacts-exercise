public class Person {
    //init
    public Person(String nameP, String numP){
        this.name = nameP;
        this.phoneNumber = numP;
    }

    //info
    private String name;
    private String phoneNumber;

    //getters
    public String getName(){
        return this.name;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }
}
