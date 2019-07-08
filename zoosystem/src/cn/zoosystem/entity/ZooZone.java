package cn.zoosystem.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="zoo_zone")
public class ZooZone implements Serializable,Cloneable{
    /** 园区号 */
    @Id
    @GeneratedValue
    private String zoneId ;
    /** 园区名 */
    private String zoneName ;

    /** 园区号 */
    public String getZoneId(){
        return this.zoneId;
    }
    /** 园区号 */
    public void setZoneId(String zoneId){
        this.zoneId = zoneId;
    }
    /** 园区名 */
    public String getZoneName(){
        return this.zoneName;
    }
    /** 园区名 */
    public void setZoneName(String zoneName){
        this.zoneName = zoneName;
    }
}