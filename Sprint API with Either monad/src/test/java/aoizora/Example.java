package aoizora;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Example {

    private enum Type {
        EXTRA_CHECK,
        COMPLETED
    }

    @Test
    public void test() {
        List<Type> types = List.of(Type.COMPLETED);
        List<String> res = types.stream()
                .map(Enum::name)
                .collect(Collectors.toList());
        System.out.println(res);
    }

    public static void main(String[] args) {
        new Example().test();
    }
}
