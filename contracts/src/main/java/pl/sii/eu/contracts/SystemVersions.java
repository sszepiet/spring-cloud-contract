package pl.sii.eu.contracts;

public class SystemVersions {
    private Version iPhone;
    private Version android;

    public SystemVersions() {
    }

    public SystemVersions(Version iPhone, Version android) {
        this.iPhone = iPhone;
        this.android = android;
    }

    public Version getiPhone() {
        return iPhone;
    }

    public void setiPhone(Version iPhone) {
        this.iPhone = iPhone;
    }

    public Version getAndroid() {
        return android;
    }

    public void setAndroid(Version android) {
        this.android = android;
    }
}
