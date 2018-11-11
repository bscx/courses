public class ControllerClass {

    public DedicatedClass dedicatedClass;
    public DedicatedClass2 dedicatedClass2;

    public ControllerClass() {
        this.dedicatedClass = new DedicatedClass();
        this.dedicatedClass2 = new DedicatedClass2();
    }

    public DedicatedClass getDedicatedClass() {
        return dedicatedClass;
    }

    public DedicatedClass2 getDedicatedClass2() {
        return dedicatedClass2;
    }
}
