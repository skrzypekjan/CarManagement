package pl.skrzypekjan.carmenagement.model;

public class Car {

  private long carId;
  private String mark;
  private String model;
  private Color color;
  private long productionYear;

  public Car(long id, String mark, String model, Color color, int prodYear) {
  }

  public Car(long carId, String mark, String model, Color color, long productionYear) {
    this.carId = carId;
    this.mark = mark;
    this.model = model;
    this.color = color;
    this.productionYear = productionYear;
  }

  public long getCarId() {
    return carId;
  }
  public void setCarId(long carId) {
    this.carId = carId;
  }


  public String getMark() {
    return mark;
  }
  public void setMark(String mark) {
    this.mark = mark;
  }


  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }


  public Color getColor() {
    return color;
  }
  public void setColor(Color color) {
    this.color = color;
  }


  public long getProductionYear() {
    return productionYear;
  }
  public void setProductionYear(long productionYear) {
    this.productionYear = productionYear;
  }

  @Override
  public String toString() {
    return "Cars{" +
            "carId=" + carId +
            ", mark='" + mark + '\'' +
            ", model='" + model + '\'' +
            ", color='" + color + '\'' +
            ", productionYear=" + productionYear +
            '}';
  }
}
