package pl.sii.eu.contracts;

import java.util.Objects;

public class Version {
    private int major;
    private int minor;
    private Integer patch;

    public Version() {
    }

    public Version(int major, int minor) {
        this(major, minor, null);
    }

    public Version(int major, int minor, Integer patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }

    public static Version fromString(String versionString) {
        String[] split = versionString.split("\\.");
        int major = Integer.parseInt(split[0]);
        int minor = Integer.parseInt(split[1]);
        Integer patch = null;
        if (split.length > 2) {
            patch = Integer.parseInt(split[2]);
        }
        return new Version(major, minor, patch);
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public Integer getPatch() {
        return patch;
    }

    public void setPatch(Integer patch) {
        this.patch = patch;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(major + "." + minor);
        if (Objects.nonNull(patch)) {
            stringBuilder.append(".").append(patch);
        }
        return stringBuilder.toString();
    }
}
