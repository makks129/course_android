package lesson5.observer_pattern;

public class Screen {

    public static void main(String[] args) {

//        Button button = new Button();
//        button.setListener(new OnButtonClickListener() {
//            @Override
//            public void onClick() {
//                System.out.println("Button click processed");
//            }
//        });
//
//
//
//
//
//
//        // System calls this method
//        button.onClick();


        Button button = new Button();
        button.setListener(new Button.OnButtonClickListener() {
            @Override
            public void onClick() {
                System.out.println("Click");
            }

            @Override
            public void onLongClick() {
                System.out.println("Long click");
            }
        });



    }

}
