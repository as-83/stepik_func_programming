package stepic.t4s1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class PhoneBook {
    private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

    public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
        nameToPhoneNumbersMap.merge(name, numbers, (col1, col2) -> {
            col1.addAll(col2);
            return col1;
        });
    }

    public void printPhoneBook() {
        nameToPhoneNumbersMap.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(n -> System.out.println(n.getType() + ": " + n.getNumber()));
        });
    }
}

enum PhoneNumberType {
    MOBILE, HOME, WORK,
}

class PhoneNumber {

    private PhoneNumberType type;
    private String number;

    public PhoneNumber(PhoneNumberType type, String number) {
        this.type = type;
        this.number = number;
    }

    public PhoneNumberType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}
