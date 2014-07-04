/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Lei
 */
@Embeddable
public class Address implements Serializable {

    private String street;
    private String city;
    private String state;
    private int zipCode;
    private String coutry;

    public Address() {
    }

    public Address(String street, String city, String state, int zipCode, String coutry) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.coutry = coutry;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCoutry() {
        return coutry;
    }

    public void setCoutry(String coutry) {
        this.coutry = coutry;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", coutry=" + coutry + '}';
    }
}
