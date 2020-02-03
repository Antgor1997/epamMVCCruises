package Managers;

import java.util.ResourceBundle;

public class ResourceManager {
    private static ResourceManager instance;

    private ResourceBundle resourceBundle;

    private final static String BUNDLE_NAME = "configuration";

    public static final String DRIVER = "DRIVER";
    public static final String URL = "URL";
    public static final String USER = "USER";
    public static final String PASSWORD = "PASSWORD";

    public static final String INDEX = "INDEX";
    public static final String REGISTRATION = "REGISTRATION";
    public static final String MAIN = "MAIN";
    public static final String ORDERS = "ORDERS";
    public static final String MAIN_ADMIN = "ADMIN";
    public static final String SHIP_ADMIN = "ADMIN";
    public static final String ADD_DRIVER = "ADD_DRIVER";
    public static final String EDIT_DRIVER = "EDIT_DRIVER";
    public static final String ERROR = "ERROR";

    private ResourceManager() {

    }

    public static ResourceManager getInstance() {
        if (instance == null) {
            instance = new ResourceManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    /**
     * get property from resource bundle by key
     *
     * @param key
     * @return
     */
    public String getProperty(String key) {
        return (String) resourceBundle.getObject(key);
    }
}
