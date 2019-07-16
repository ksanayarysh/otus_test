package data;

import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String firstNameEn;
    private String lastNameEn;
    private String nameInBlog;
    private String birthDate;
    private String city;
    private String country;
    private String email;
    private String phone;
    private String fb;
    private String vk;

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getVk() {
        return vk;
    }

    public void setVk(String vk) {
        this.vk = vk;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstNameEn(String firstNameEn) {
        this.firstNameEn = firstNameEn;
    }

    public void setLastNameEn(String firstLastEn) {
        this.lastNameEn = firstLastEn;
    }

    public void setNameInBlog(String nameInBlog) {
        this.nameInBlog = nameInBlog;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstNameEn() {
        return firstNameEn;
    }

    public String getLastNameEn() {
        return lastNameEn;
    }

    public String getNameInBlog() {
        return nameInBlog;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                firstNameEn.equals(person.firstNameEn) &&
                lastNameEn.equals(person.lastNameEn) &&
                nameInBlog.equals(person.nameInBlog) &&
                birthDate.equals(person.birthDate) &&
                city.equals(person.city) &&
                country.equals(person.country) &&
                fb.equals(person.fb) &&
                vk.equals(person.vk);
    }

    @Override
    public String toString() {
        return "data.Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstNameEn='" + firstNameEn + '\'' +
                ", lastNameEn='" + lastNameEn + '\'' +
                ", nameInBlog='" + nameInBlog + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", fb='" + fb + '\'' +
                ", vk='" + vk + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, firstNameEn, lastNameEn, nameInBlog, birthDate, city, country, fb, vk);
    }
}
