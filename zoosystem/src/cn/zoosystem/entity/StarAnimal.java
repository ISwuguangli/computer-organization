package cn.zoosystem.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="star_animal")
public class StarAnimal implements Serializable,Cloneable{
    /** 明星动物id */
    @Id
    @GeneratedValue
    private int animalId ;
    /** 明星动物名 */
    private String animalName ;
    /** 所属园区号 */
    private int zoneId ;
    /** 园区名 */
    private String zoneName ;

    public StarAnimal()
    {

    }

    public StarAnimal(String animalName,int zoneId,String zoneName)
    {
        this.animalName=animalName;
        this.zoneId=zoneId;
        this.zoneName=zoneName;
    }

    public StarAnimal(int animalId,String animalName,int zoneId,String zoneName)
    {
        this.animalId=animalId;
        this.animalName=animalName;
        this.zoneId=zoneId;
        this.zoneName=zoneName;
    }

    /** 明星动物id */
    public int getAnimalId(){
        return this.animalId;
    }
    /** 明星动物id */
    public void setAnimalId(int animalId){
        this.animalId = animalId;
    }
    /** 明星动物名 */
    public String getAnimalName(){
        return this.animalName;
    }
    /** 明星动物名 */
    public void setAnimalName(String animalName){
        this.animalName = animalName;
    }
    /** 所属园区号 */
    public int getZoneId(){
        return this.zoneId;
    }
    /** 所属园区号 */
    public void setZoneId(int zoneId){
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