/*
 * File: CheckUrl.java
 * Created Date: 2021-09-24 15:50:04
 * Author: Sallai Andras
 * Github: https://github.com/andteki
 * -----
 * Last Modified: 2022-11-21
 * Modified By: Balogh Csenge
 * -----
 * Copyright (c) 2021 Sallai Andras
 * 
 * GNU GPL v2
 */

package models;

public class CheckUrl {
    public static boolean isValidUrl(String url) {

        boolean valid = false;

        if (url.isEmpty()) {
            url = "https://index.hu";

            valid = true;
        } else {
            url = expandProtocol(url);

            valid = true;
        }

        return valid;

    }

    public static String expandProtocol(String url) {

        String s = "https://";

        if (!url.contains(s)) {
            url = s + url;
        }

        return url;
        
    }
}
