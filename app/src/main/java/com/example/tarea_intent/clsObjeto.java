package com.example.tarea_intent;

import android.os.Parcel;
import android.os.Parcelable;

public class clsObjeto implements Parcelable {
    private String nombre;
    private String apellido;
    private String sexo;
    private int edad;

    public clsObjeto(String nombre, String apellido, String sexo, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
    }

    public clsObjeto(){
        this.nombre = "";
        this.apellido = "";
        this.sexo = "";
        this.edad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getInfo() {
        return (this.nombre+" "+this.apellido+" "+this.sexo+" "+this.edad);
    }


    protected clsObjeto(Parcel in) {
        nombre = in.readString();
        apellido = in.readString();
        sexo = in.readString();
        edad = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellido);
        dest.writeString(sexo);
        dest.writeInt(edad);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<clsObjeto> CREATOR = new Parcelable.Creator<clsObjeto>() {
        @Override
        public clsObjeto createFromParcel(Parcel in) {
            return new clsObjeto(in);
        }

        @Override
        public clsObjeto[] newArray(int size) {
            return new clsObjeto[size];
        }
    };
}
