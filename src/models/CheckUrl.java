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
        String s = "https://";

        if (url.isEmpty()) {
            url = "https://index.hu";

            valid = true;
        } else if (!url.contains(s)) {
            url = s + url;

            valid = true;
        }

        return valid;

    }

    public static void expandProtocol(String url) {

    }
}
