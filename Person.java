public class Person {
    protected String name;
    protected String id;
    protected String email;

    public Person(String name,String email,String id){
        this.name=name;
        this.id=id;
        this.email=email;

    } 

    public String getName(){
        return name;
    }
    public String getId(){
        return id;

    }
 

    @Override
    public String toString(){
        return "Name: "+name+", ID:"+id+", Email: "+email;
    }
}