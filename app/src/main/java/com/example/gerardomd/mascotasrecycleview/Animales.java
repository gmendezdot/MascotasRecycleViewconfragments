package com.example.gerardomd.mascotasrecycleview;


import android.os.Parcel;
import android.os.Parcelable;

public class Animales implements Parcelable{

    private int photo;
    private int bone;
    private String name;
    private String count;
    private int bone2;


    public Animales(int photo, int bone, String name, String count, int bone2) {
        this.photo = photo;
        this.bone = bone;
        this.name = name;
        this.count = count;
        this.bone2 = bone2;
    }

    public Animales(Parcel input){
        photo=input.readInt();
        bone=input.readInt();
        name=input.readString();
        count=input.readString();
        bone2=input.readInt();
    }






    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getBone() {
        return bone;
    }

    public void setBone(int bone) {
        this.bone = bone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getBone2() {
        return bone2;
    }

    public void setBone2(int bone2) {
        this.bone2 = bone2;
    }




    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photo);
        dest.writeInt(bone);
        dest.writeString(name);
        dest.writeString(count);
        dest.writeInt(bone2);
    }

    public static final Parcelable.Creator<Animales> CREATOR = new Parcelable.Creator<Animales>() {
        public Animales createFromParcel(Parcel in) {
            return new Animales(in);
        }

        public Animales[] newArray(int size) {
            return new Animales[size];
        }
    };


















}
