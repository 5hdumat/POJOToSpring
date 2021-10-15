package hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    // stateful한 설계
    public void statefulOrder(String name, int price) {
        System.out.println("name = " + name + "price = " + price);
        this.price = price;
    }

    // stateless한 설계
    public int statelessOrder(String name, int price) {
        System.out.println("name = " + name + "price = " + price);
        return price;
    }

    public int getPrice() {
        return price;
    }
}
