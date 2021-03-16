package com.example.drsnoopy.Model;

public class DoctorModel {
int image,location;
String doctorname,experience,km;

    public DoctorModel(int image, int location, String doctorname, String experience, String rating, String km) {
        this.image = image;
        this.location = location;
        this.doctorname = doctorname;
        this.experience = experience;
      //  this.rating = rating;
        this.km = km;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

  /*  public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
*/
    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }
}
