package ua.lvivskiy.v_dembovskiy.api_tests;


import java.util.Arrays;
import java.util.Objects;

public class Planet1 {
    private String name;
    private String rotation_period;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;
    private String[] residents;
    private String[] films;
    private String created;
    private String edited;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRotation_period() {
        return rotation_period;
    }

    public void setRotation_period(String rotation_period) {
        this.rotation_period = rotation_period;
    }

    public String getOrbital_period() {
        return orbital_period;
    }

    public void setOrbital_period(String orbital_period) {
        this.orbital_period = orbital_period;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getSurface_water() {
        return surface_water;
    }

    public void setSurface_water(String surface_water) {
        this.surface_water = surface_water;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String[] getResidents() {
        return residents;
    }

    public void setResidents(String[] residents) {
        this.residents = residents;
    }

    public String[] getFilms() {
        return films;
    }

    public void setFilms(String[] films) {
        this.films = films;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet1 planet1 = (Planet1) o;
        return Objects.equals(name, planet1.name) &&
                Objects.equals(rotation_period, planet1.rotation_period) &&
                Objects.equals(orbital_period, planet1.orbital_period) &&
                Objects.equals(diameter, planet1.diameter) &&
                Objects.equals(climate, planet1.climate) &&
                Objects.equals(gravity, planet1.gravity) &&
                Objects.equals(terrain, planet1.terrain) &&
                Objects.equals(surface_water, planet1.surface_water) &&
                Objects.equals(population, planet1.population) &&
                Arrays.equals(residents, planet1.residents) &&
                Arrays.equals(films, planet1.films) &&
                Objects.equals(created, planet1.created) &&
                Objects.equals(edited, planet1.edited) &&
                Objects.equals(url, planet1.url);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, rotation_period, orbital_period, diameter, climate, gravity, terrain, surface_water, population, created, edited, url);
        result = 31 * result + Arrays.hashCode(residents);
        result = 31 * result + Arrays.hashCode(films);
        return result;
    }
}
