/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Booking;

/**
 *
 * @author Jonas Borg Petersen
 */
public class RentalCar {
    public int id;
    public String licenseplateNumber;
//    public typeName typeName;
    
    public RentalCar(){}

    public RentalCar(int id, String licenseplateNumber) {
        this.id = id;
        this.licenseplateNumber = licenseplateNumber;
//z        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public String getLicenseplateNumber() {
        return licenseplateNumber;
    }

//    public typeName getTypeName() {
//        return typeName;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLicenseplateNumber(String licenseplateNumber) {
        this.licenseplateNumber = licenseplateNumber;
    }

//    public void setTypeName(typeName typeName) {
//        this.typeName = typeName;
//    }

    
    
    
}

enum typeName {
    A("a"), 
    B("b"), 
    C("c"), 
    D("d"), 
    E("e"), 
    F("f");
    private final String type;
    private typeName(String type){
        this.type = type;
    }
};
