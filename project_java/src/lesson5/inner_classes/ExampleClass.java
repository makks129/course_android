package lesson5.inner_classes;

public class ExampleClass {

    private int data;
    private InnerClass innerClass;

    public ExampleClass() {
        innerClass = new InnerClass();
    }

    private void outerClassMethod() {
        data++;
    }


    public class InnerClass {

        public InnerClass() {
        }

        private void innerClassMethod() {
            data++;
            outerClassMethod();
        }

    }




    public interface InnerInterface {
        void method();
    }



}