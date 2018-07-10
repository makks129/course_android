package lesson5.observer_pattern;

public class Button {

    private OnButtonClickListener listener;

    public void setListener(OnButtonClickListener listener) {
        this.listener = listener;
    }

    public void onClick() {
        // called by the system
        listener.onClick();
    }

}
