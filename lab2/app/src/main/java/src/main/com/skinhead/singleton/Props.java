package src.main.com.skinhead.singleton;

import java.util.Properties;

public final class Props {
    private static Props instance;
    public Properties value;

    public Props(Properties value) {
        this.value = value;
    }

    public static Props getInstance(Properties value) {
        if (instance == null) {
            instance = new Props(value);
        }
        return instance;
    }
}
