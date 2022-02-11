package stepic.t5s1;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ProcessDeliveryOrders {

    public static DeliveryOrder findFirstOrder(List<DeliveryOrder> orders) {
        return orders.stream().min(Comparator.comparing(DeliveryOrder::getDeliveryDate)).orElseGet(DeliveryOrder::new);
    }

    public static void printAddressesToDeliver(List<DeliveryOrder> orders) {
         orders.stream().sorted(Comparator.comparing(DeliveryOrder::getDeliveryDate))
                .distinct()
         .forEach(o -> System.out.println(o.getAddress()));
    }

    public static void main(String[] args) {
       /* final Scanner scanner = new Scanner(System.in);

        List<DeliveryOrder> orders = Stream.iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                .map(i -> scanner.nextLine().split("\\|"))
                .map(parts -> new DeliveryOrder(
                        Long.parseLong(parts[0]), parts[2], LocalDate.parse(parts[1])))
                .collect(Collectors.toList());*/

        //System.out.println(findFirstOrder(orders));

        //printAddressesToDeliver(orders);
        List<Integer> numbers = List.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6);

        numbers.stream()
                .filter(n -> n > -5 && n <= 5)
                .filter(n -> n < 0 || n > 2)
                .forEach(System.out::println);
    }

    public static int findMaxEvenNumber(Collection<Integer> numbers) {
        return numbers.stream().filter(i -> i % 2 == 0).max(Comparator.naturalOrder()).orElseGet( () -> 0); // write your code here
    }

}

class DeliveryOrder {
    private final long orderId;
    private final String address;
    private final LocalDate deliveryDate;
    // there are even more fields: customer name, phone, products info, etc

    public DeliveryOrder() {
        this.orderId = -1;
        this.address = "No address";
        this.deliveryDate = LocalDate.MIN;
    }

    public DeliveryOrder(long orderId, String address, LocalDate deliveryDate) {
        this.orderId = orderId;
        this.address = address;
        this.deliveryDate = deliveryDate;
    }

    public static Comparator<DeliveryOrder> getComparatorByDeliveryDate() {
        return Comparator.comparing(DeliveryOrder::getDeliveryDate);
    }

    public long getOrderId() {
        return orderId;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeliveryOrder that = (DeliveryOrder) o;
        return address.equals(that.address) &&
                deliveryDate.equals(that.deliveryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, deliveryDate);
    }

    @Override
    public String toString() {
        return orderId + "|" + deliveryDate + "|" + address;
    }
}
