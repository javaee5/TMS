package ir.university.toosi.tms.model.entity.zone;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BLookup;
import ir.university.toosi.tms.model.entity.BaseEntity;


public class GAC extends BaseEntity {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String code;
    @JsonProperty
    private BLookup gacType;
    @JsonProperty
    private BLookup gacUsageType;
    @JsonProperty
    private String IPAddress;
    @JsonProperty
    private String description;
    @JsonProperty
    private String status;
    @JsonProperty
    private String deleted;

    public GAC() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BLookup getGacType() {
        return gacType;
    }

    public void setGacType(BLookup gacType) {
        this.gacType = gacType;
    }

    public String getGacTypeCode() {
        return "GacType";
    }

    public BLookup getGacUsageType() {
        return gacUsageType;
    }

    public void setGacUsageType(BLookup gacUsageType) {
        this.gacUsageType = gacUsageType;
    }

    public String getGacUsageTypeCode() {
        return "GacUsageTypeCode";
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}