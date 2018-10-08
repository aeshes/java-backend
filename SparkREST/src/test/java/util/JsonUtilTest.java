package util;

import model.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonUtilTest {

    @Test
    public void toJson() {
        System.out.println(JsonUtil.toJson(new User(1, "xxx", "yyy")));
    }

    @Test
    public void json() {
    }
}