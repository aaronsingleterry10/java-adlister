public class CarModel extends Car {
    private String trim;
    private int cylinders;
    private boolean is4X4;


    public CarModel(long id, String make, String model, int year, String trim, int cylinders, boolean is4X4) {
        super(id, make, model, year);
        this.trim = trim;
        this.cylinders = cylinders;
        this.is4X4 = is4X4;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public boolean isIs4X4() {
        return is4X4;
    }

    public void setIs4X4(boolean is4X4) {
        this.is4X4 = is4X4;
    }
}
