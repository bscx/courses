public class ApplicationClass {

    private ControllerClass controller;

    public ApplicationClass() {
        controller = new ControllerClass();
    }

    public String printHelloWorldMessage() {

        return controller.getDedicatedClass().showMessage() + "\n" +
                controller.getDedicatedClass2().showMessage();
    }

    public static void main (String[] args) {
        System.out.println(new ApplicationClass().printHelloWorldMessage());
    }
}
