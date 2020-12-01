package com.example.sitioturistico;

import android.os.Parcel;
import android.os.Parcelable;

public class Sitios implements Parcelable {
    private String nombresitio;
    private String tipo;
    private String descripcion;
    private String nombremunicipio;

    public Sitios(String nombresitio, String tipo, String descripcion, String nombremunicipio) {
        this.nombresitio = nombresitio;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.nombremunicipio = nombremunicipio;
    }


    protected Sitios(Parcel in) {
        nombresitio = in.readString();
        tipo = in.readString();
        descripcion = in.readString();
        nombremunicipio = in.readString();
    }

    public static final Creator<Sitios> CREATOR = new Creator<Sitios>() {
        @Override
        public Sitios createFromParcel(Parcel in) {
            return new Sitios(in);
        }

        @Override
        public Sitios[] newArray(int size) {
            return new Sitios[size];
        }
    };

    @Override
    public String toString() {
        return "Sitios{" +
                "nombresitio='" + nombresitio + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", nombremunicipio='" + nombremunicipio + '\'' +
                '}';
    }

    public String getNombresitio() {
        return nombresitio;
    }

    public void setNombresitio(String nombresitio) {
        this.nombresitio = nombresitio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombremunicipio() {
        return nombremunicipio;
    }

    public void setNombremunicipio(String nombremunicipio) {
        this.nombremunicipio = nombremunicipio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombresitio);
        dest.writeString(tipo);
        dest.writeString(descripcion);
        dest.writeString(nombremunicipio);
    }
}
