package com.kolyadko_polovtseva.book_maze.util;

import com.cloudinary.Cloudinary;
import com.cloudinary.SingletonManager;
import com.cloudinary.utils.ObjectUtils;

import java.util.ResourceBundle;

/**
 * Created by DaryaKolyadko on 28.11.2016.
 */
public class CloudinaryManager {
    private static final String CONFIG_FILE = "cloudinary";
    private static final String CLOUD_NAME_PARAM = "cloud_name";
    private static final String API_KEY_PARAM = "api_key";
    private static final String API_SECRET_PARAM = "api_secret";

    private Cloudinary cloudinary;
    private SingletonManager singletonManager;

    public Cloudinary getCloudinary() {
        if (cloudinary == null) {
            ResourceBundle cloudinaryConfig = ResourceBundle.getBundle(CONFIG_FILE);
            cloudinary = new Cloudinary(ObjectUtils.asMap(
                    CLOUD_NAME_PARAM, cloudinaryConfig.getString(CLOUD_NAME_PARAM),
                    API_KEY_PARAM, cloudinaryConfig.getString(API_KEY_PARAM),
                    API_SECRET_PARAM, cloudinaryConfig.getString(API_SECRET_PARAM)));
            singletonManager = new SingletonManager();
            singletonManager.setCloudinary(cloudinary);
            singletonManager.init();
        }

        return cloudinary;
    }

    public SingletonManager getSingletonManager() {
        if (singletonManager == null) {
            getCloudinary();
        }

        return singletonManager;
    }
}