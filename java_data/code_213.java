package com.derbysoft.ui.uibuilder;

public interface Const {
    int SECONDS = 1000;
    int MINUTES = 60 * SECONDS;
    int HOURS = 60 * MINUTES;
    String ZIP_FILE_EXTENSION = ".zip";

    String SITE_PAGE_SUFFIX = ".jhtml";

    String DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    String DATE_FORMAT_PATTERN = "yyyy-MM-dd";

        int DEFAULT_SELECT_PAGE_SIZE = 10;

        interface ResourcePath {
        String BASE_PATH = "static/";
        String IMAGE_AVATAR = "resource/image/avatar";     }

    interface Account {
        String HASH_ALGORITHM = "SHA-1";
        int HASH_INTERATIONS = 1024;
        int SALT_SIZE = 8;
    }

    interface SessionKey {
        String CAPTCHA = "simpleCaptcha";
    }

    interface CategoryType {
        String PERMISSION = "权限分类";
        String OTHER = "其它分类";
    }

    interface ResourceType {
        String MENU = "菜单";
    }

    interface ExceptionCode {
        String AUTHORIZATION_ERROR = "AUTH_00";
    }

    String[] RESOURCE_TYPES = new String[]{ResourceType.MENU};

    interface JwtKey {
        String IDENTITY = "identity";
    }
}