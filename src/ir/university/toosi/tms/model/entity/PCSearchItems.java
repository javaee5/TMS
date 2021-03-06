package ir.university.toosi.tms.model.entity;

import ir.university.toosi.tms.util.ThreadPoolManager;

public enum PCSearchItems {

    NAME, IP;

    public String getDescription() {

        switch (this) {
            case NAME:
                return ThreadPoolManager.getLangValue("TMS_NAME");
            case IP:
                return ThreadPoolManager.getLangValue("TMS_IP");
        }
        return "";
    }

    public String getValue() {

        switch (this) {
            case NAME:
                return "1";
            case IP:
                return "2";
        }

        return "0";
    }
}
