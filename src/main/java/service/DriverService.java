package service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DriverService {
    private static final Logger LOGGER = LogManager.getLogger(DriverService.class);


    private DriverService() {
    }

    /**
     * Singleton instance
     */
    private static DriverService instance = null;

    public static synchronized DriverService getInstance() {
        if (instance == null)
            instance = new DriverService();
        return instance;
    }
}
