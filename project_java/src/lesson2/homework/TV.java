package lesson2.homework;

/**
 * Complete the TV class
 * Write methods that appropriately change the attributes of this class
 * Don't forget to check if the TV is turned on before changing channels and volume!
 */
public class TV {

    String brand;
    int channel = 1;
    int volumeLevel = 1;
    boolean on = false;

    public TV(String brandName) {
        brand = brandName;
    }

    public void turnOn() {

    }

    public void turnOff() {

    }

    public void setChannel(int newChannel) {

    }

    public void setVolume(int newVolumeLevel) {

    }

    public void channelUp() {

    }

    public void channelDown() {

    }

    public void volumeUp() {

    }

    public void volumeDown() {

    }


    public static void main(String[] args) {

        TV tv = new TV("Samsung");
        tv.turnOn();
        tv.setChannel(6);
        tv.channelUp();
        tv.volumeUp();
        tv.setVolume(50);
        tv.turnOff();

    }

}
