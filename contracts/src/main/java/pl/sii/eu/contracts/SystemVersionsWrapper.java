package pl.sii.eu.contracts;

public class SystemVersionsWrapper {
    private SystemVersions systemVersions;

    public SystemVersionsWrapper() {
    }

    public SystemVersionsWrapper(SystemVersions systemVersions) {
        this.systemVersions = systemVersions;
    }

    public SystemVersions getSystemVersions() {
        return systemVersions;
    }

    public void setSystemVersions(SystemVersions systemVersions) {
        this.systemVersions = systemVersions;
    }
}
